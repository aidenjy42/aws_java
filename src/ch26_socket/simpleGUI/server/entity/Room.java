package ch26_socket.simpleGUI.server.entity;

import java.util.List;

import ch26_socket.simpleGUI.server.ConnectedSocket;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Room { //방이 만들어질때마다 Room 객체가 생성
	private String roomName;
	private String owner;
	private List<ConnectedSocket> userList; //ServerReceiver
}
