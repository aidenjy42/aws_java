package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleGUIServer {
	
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();
	//스레드 리스트
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("[ 서버 실행 ]");
			
			while(true) {
				Socket socket = serverSocket.accept(); //client에서 접속하면 client측 소켓이 해당 socket이 됨
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				//소켓을 스레드에 넣어서 내부 동작
				//스레드를 리스트에 넣음
				connectedSocketList.add(connectedSocket);
				
				connectedSocket.start(); //소켓을 넣은 스레드가 실행
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
