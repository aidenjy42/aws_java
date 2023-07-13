package ch26_socket.simpleGUI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import lombok.RequiredArgsConstructor;

public class ClientReceiver extends Thread {
	//Socket socket; //지움-> 싱글톤으로 해결
	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance(); //싱글톤으로 만든 Client의 객체를 가져옴
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(simpleGUIClient.getSocket().getInputStream())); //Client클래스위에 getter로 socket 가져오기
				//서버 -> 클라이언트 방향으로 output하면 이쪽(client)에서 input함
				String requestBody = bufferedReader.readLine();
				
				requestController(requestBody);
				
//				simpleGUIClient.getTextArea().append(requestBody + '\n'); 
				//다른 클라이언트가 메시지를 치면 서버로 넘어가고,
				//서버가 스레드 리스트를 foreach() 돌려서 모든 클라이언트에 그 메시지를 전송
				// -> 클라이언트측(여기)에서 받아와서 그 데이터를 textArea에 추가
				//main test
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	private void requestController (String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
			case "updateRoomList":
				List<String> roomList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getRoomListModel().clear();
				SimpleGUIClient.getInstance().getRoomListModel().addAll(roomList);
				break;
			
			case "showMessage"://textArea에 메시지 출력
				//<> 안의 String타입은 다운캐스팅이 바로 된다 (<>가 사용자정의 클래스 타입이면 fromJson( , ReqDto.class) 해도 <> 타입이 다운캐스팅이 안됨)
				String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getChattingTextArea().append(messageContent + "\n");
				break;
				
			case "updateUserList":
				List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody(); //dto가 가져온 json 에서 body의 값를 가져옴
				SimpleGUIClient.getInstance().getUserListModel().clear(); // 기존 접속자리스트창을 비움
				SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList); //리스트 추가
				break;
		}
	}
}
