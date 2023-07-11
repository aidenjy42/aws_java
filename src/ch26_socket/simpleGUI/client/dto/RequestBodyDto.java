package ch26_socket.simpleGUI.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestBodyDto<T> {
	private String resource; // 처리 내용 (명령)
	private T body;
}
