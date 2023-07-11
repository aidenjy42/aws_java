package ch19_제네릭;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder //자식 객체 생성 시 부모 변수도 같이 선언할 수 있음
@ToString
public class AccountUser {
	private String username;
	private String password;
	
}
