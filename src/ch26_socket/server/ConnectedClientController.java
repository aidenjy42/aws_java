package ch26_socket.server;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ConnectedClientController {
	//singleton
	private static ConnectedClientController instance;
	@Getter //connectedSockets만 getter생성
	private List<ConnectedSocket> connectedSockets; 
	
	private ConnectedClientController() {
		connectedSockets = new ArrayList<>(); //생성은 한번만 이루어짐
	}
	
	public static ConnectedClientController getInstance() {
		if(instance == null) {
			instance = new ConnectedClientController();
		}
		return instance;
	}
	
}
