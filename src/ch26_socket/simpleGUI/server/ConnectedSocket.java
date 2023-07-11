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
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket; // 소켓 객체 받는 생성자 만들기 위함
	private String username;
	
	@Override
	public void run() {
		// 스레드 정의문
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// input에는 BufferedReader
				String requestBody = bufferedReader.readLine();// 데이터의 입력을 기다린 후 클라이언트로부터 내용을 받음
				
				requestController(requestBody);
				// server아니고 이 파일에서 forEach()돌리는 이유: 바로 위에서 readLine()해서 데이터를 받아옴
				// client에서 PrintWriter를 통해 output한 값을 bufferedReader가 input(readLine())해온 값을 출력

//				for(ConnectedSocket connectedSocket : SimpleGUIServer.connectedSocketList) { }
//				for(int i =0; i<SimpleGUIServer.connectedSocketList.size(); i++) {}

//				SimpleGUIServer.connectedSocketList.forEach(th -> {
//					try {// 클라이언트에게서 받은 내용을 클라이언트로 보냄
//						PrintWriter printWriter = new PrintWriter(th.socket.getOutputStream(), true);
//						printWriter.println(requestBody);
//						
//
//					} catch (IOException e) {
//						e.printStackTrace();
//					};
//
//				});

			} catch (SocketException e) {
				return; // 스레드 종료

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		//dto 클래스 가져올 때 server인지 client 쪽인지 확인 
//		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, RequestBodyDto.class);
		
//		RequestBodyDto<SendMessage> requBodyDto = gson.fromJson(requestBody, new TypeToken<>() {}.getType()); //아래 두 문장을 하나로 묶음
//		TypeToken<?> token = new TypeToken<>() { 
//					
//		};
//		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, token.getType()); //이걸 안하면 getBody() 반환값이 Object로 나옴
		
		
		switch(resource) {
		case "join": //접속. 접속과 동시에 클라이언트의 소켓 스레드마다 username이 저장!
			username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
			
			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
				List<String> usernameList = new ArrayList<>();
				SimpleGUIServer.connectedSocketList.forEach(t-> {
					usernameList.add(t.username); //새로 for돌려서 접속자 리스트를 새로 추가함
				});
				RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
				RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 들어왔습니다.");
				
				ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
			});
			
			break;
			
		case "sendMessage":
//			SendMessage sendMessage = (SendMessage) requestBodyDto.getBody(); //sendMessage는 지금 object 타입. 다운캐스팅 후 사용
			
			//1. 전체 채팅: toUsername == null이면 모두에게 전송
			
			TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<>() { };
			//TypeToken
			//Json을 객체로 변환
			RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
			SendMessage sendMessage = requestBodyDto.getBody(); //SendMessage 타입으로 변환
			
			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
				RequestBodyDto<String> dto =
						new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
				ServerSender.getInstance().send(connectedSocket.socket, dto);
				
			});
			
			//2. 귓속말 채팅:
//			ServerSender.getInstance().send(th.socket, null);
			break;
		}
		
		
	}
}
