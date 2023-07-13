package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.client.SimpleGUIClient;
import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {
	private final Socket socket; // 소켓 객체 받는 생성자 만들기 위함
	private Gson gson;
	
	private String username;
	
	@Override
	public void run() {
		// 스레드 정의문
		gson = new Gson();
		
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// input에는 BufferedReader
				String requestBody = bufferedReader.readLine();// 데이터의 입력을 기다린 후 클라이언트로부터 내용을 받음
				
				requestController(requestBody);
				// server아니고 이 파일에서 forEach()돌리는 이유: 바로 위에서 readLine()해서 데이터를 받아옴
				// client에서 PrintWriter를 통해 output한 값을 bufferedReader가 input(readLine())해온 값을 출력

			} catch (SocketException e) {
				return; // 스레드 종료

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void requestController(String requestBody) {
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		//dto 클래스 가져올 때 server인지 client 쪽인지 확인
//		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, RequestBodyDto.class);
		
//		RequestBodyDto<SendMessage> requBodyDto = gson.fromJson(requestBody, new TypeToken<>() {}.getType()); //아래 두 문장을 하나로 묶음
//		TypeToken<?> token = new TypeToken<>() { 
//					
//		};
//		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, token.getType()); //이걸 안하면 getBody() 반환값이 Object로 나옴
		
		switch(resource) {
		case "connection":
			connection(requestBody);
			break;
			
		case "createRoom": //방마다 스레드 리스트가 필요
			createRoom(requestBody);
			break;
			
		case "join": //접속. 접속과 동시에 클라이언트의 소켓 스레드마다 username이 저장!
			join(requestBody);
			break;
			
		case "sendMessage":
			sendMessage(requestBody);
			break;
		}
		
	}
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody(); //접속한 username을 받아옴
		
		//접속이 됐을 때 이미 생성된 방 리스트를 보여줘야함
		List<String> roomNameList = new ArrayList<>(); //방 이름들만 담을 수 있는 리스트
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName()); //그 리스트에 (RoomLIst에서 방의 제목을 가져온것)을 넣음
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto =
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		ServerSender.getInstance().send(socket, updateRoomListRequestBodyDto); //들어온 사람만 방을 업데이트 시켜주면 되니까 자기 자신의 소켓만 요청을 보냄
		
	}
	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody(); //roomName을 가져옴
		
		Room newRoom = Room.builder()
		.roomName(roomName)
		.owner(username) 
		.userList(new ArrayList<ConnectedSocket>())//방마다 유저리스트 관리할 수 있게
		.build();
		
		SimpleGUIServer.roomList.add(newRoom); //Room 객체 리스트에 방을 추가
		
		List<String> roomNameList = new ArrayList<>(); //방 이름들만 담을 수 있는 리스트
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName()); //그 리스트에 (RoomLIst에서 방의 제목을 가져온것)을 넣음
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto =
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		SimpleGUIServer.connectedSocketList.forEach(con -> { //접속한 사용자 모두에게 룸리스트를 전달..?
			ServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
		});
	}
	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody(); //== RoomName
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getRoomName().equals(roomName)) {//접속하고자 하는 방이름을 가져와 그 방 안에 소켓(유저) 넣기
				room.getUserList().add(this); //this: connectedSocket/각 방 안에 유저 리스트가 있음-> 그 안에 스레드를
				
				List<String> usernameList = new ArrayList<>();
				
				//방 안에있는 유저리스트를 돌림
				room.getUserList().forEach(con -> {
					usernameList.add(con.username); //새로 for돌려서 접속자 리스트를 새로 추가함
				});
				
				room.getUserList().forEach(connectedSocket -> { 
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
					
					ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) { //0.1초 기다렸다가 실행
						e.printStackTrace();
					}
					ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
				});
			}
			
		});
		
	}
	//메시지 보내기
	private void sendMessage(String requestBody) {		
		//1. 전체 채팅
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<>() { };
		//TypeToken
		//Json을 객체로 변환
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody(); //SendMessage 타입의 body를 가져옴
		
		SimpleGUIServer.roomList.forEach(room -> {
			if(room.getUserList().contains(this)) { //this: connectedSocket. room의 유저리스트에 내가 있는지 확인
				room.getUserList().forEach(connectedSocket -> { //방 안의 유저리스트로 반복 돌림
					RequestBodyDto<String> dto =
								new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
					ServerSender.getInstance().send(connectedSocket.socket, dto);
				});
			}
			
		});
		
	}
}
