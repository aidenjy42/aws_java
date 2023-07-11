package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleServer {

	public static void main(String[] args) {
		try {
			System.out.println("서버 실행");
			ServerSocket serverSocket = new ServerSocket(8000);
			List<Socket> socketList = new ArrayList<>();
			
			while(true) {
				Socket socket = serverSocket.accept(); //simpleClient.java가 실행되면 클라이언트의 소켓을 받아옴
				socketList.add(socket);
				
				Thread thread = new Thread(() -> { //스레드 정의(실행은 start()에서)
					Socket threadSocket = socket; //생성한 소켓을 담음
					while (true) {
						System.out.println("데이터 입력 기다림");
						BufferedReader bufferedReader;
						// read()와 readLine()이 있는데, read()는 한문자입력해서 int형으로, readLine()은 문자열을 유니코드 형식으로 반환
						try {
							InputStreamReader inputStreamReader = new InputStreamReader(threadSocket.getInputStream());
							//람다식 쓸 때 좋은 점: 따로 클래스를 만들면 socket이라는 변수를 클래스 쪽으로 넘겼다가 get해야됨 
							//InputStream -> I.S.Reader로 변환하여 BufferedReader의 매개변수로
							bufferedReader = new BufferedReader(inputStreamReader); //Reader타입(
							//bufferedReader.readLine()을 통해 요청을 계속 받아야 되기 때문에 스레드로 따로 만들어서 돌려야됨
							
							/*client의 output를 받아옴(=Server에서의 input)*/
							
							String requestbody = bufferedReader.readLine();
							//받은 데이터를 모든 리스트에 뿌려줌
							socketList.forEach(s -> {
								
								try {
									PrintWriter printWriter = new PrintWriter(s.getOutputStream(),true);
									printWriter.println("메세지 내용(" + requestbody + ")"); 
									//클라이언트에게서 받은 내용을 다시 클라이언트로 보냄
								} catch (IOException e) {
									e.printStackTrace();
								}
							});
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				thread.start(); //스레드 시작
			}
		} catch (IOException e) {}
	}

}
