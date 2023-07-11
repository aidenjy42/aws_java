package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;

public class ServerSender { //서버쪽에서 보내는 거는 여러개 클라이언트소켓마다 다 전달시켜줘야 함
	
	private Gson gson;
	//singleton
	private static ServerSender instance;
	private ServerSender() {
		gson = new Gson();
	}
	public static ServerSender getInstance() {
		if(instance == null) {
			instance = new ServerSender();
		}
		return instance;
	}
	
	public void send(Socket socket, RequestBodyDto<?> requestBodyDto) {
		try {
			PrintWriter printWriter =
					new PrintWriter(socket.getOutputStream(), true);
			printWriter.println(gson.toJson(requestBodyDto));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
