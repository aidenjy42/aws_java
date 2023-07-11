package ch19_제네릭;

import lombok.Builder;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder //부모 객체 변수도 선언 가능
@ToString(callSuper = true) //부모 객체 정보도 같이 toString으로 출력
public class SignupUser extends AccountUser {

	private String name;
	private String email;
}
