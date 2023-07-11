package ch26_socket.simpleGUI.client.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SendMessage { //누가 보낸건지 + 메시지 내용
	private String fromUsername;
	private String toUsername;
	private String messageBody;
	
}
