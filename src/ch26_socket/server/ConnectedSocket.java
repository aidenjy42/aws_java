package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread { //스레드를 상속 -> 스레드를 생성한다는 의미

	private final Socket socket; //final을 달아줘야 @required..가 활성화
	
	@Override
	public void run() { //스레드 위의 Runnable의 run() 메소드 오버라이딩
		
		BufferedReader bufferedReader = null;
		//서버의 소켓과 클라이언트 소켓이 연결되어야 하는데, 이때 클라이언트->서버 방향, 서버-> 클라이언트 방향은 input으로 받아야 함
		//BufferedReader생성자 매개변수 타입: Reader -> Reader를 상속받아서 업캐스팅된 InputStreamReader 타입으로 넣을 수 있음
		//socket의 getter로 inputStream 
		try {
			while(true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //inputStream: 입력을 기다림
				String requestBody = bufferedReader.readLine();
				System.out.println("입력데이터: " + requestBody);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
}
