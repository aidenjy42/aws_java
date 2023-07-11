package ch18_빌더;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //eqlulsAndHashcode, getter, setter, toString
@Builder

public class KoreaUser {
	private int userId;
	private String username;
	private String password;
	private String name;
	private String email;
	
	public static KoreaUserBuilder builder() {
		return new KoreaUserBuilder(); //자기 클래스 객체를 생성
	}
	
	//static으로 하면 자기 자신을 생성해야 메소드 호출 가능.
	//static으로 잡아야 하는 이유: KoreaUser 객체를 생성하자마자 써야함
	public static class KoreaUserBuilder { //내부 클래스
		//디자인 패턴_빌더 패턴
		private int userId;
		private String username;
		private String password;
		private String name;
		private String email;
		
		//"가장 마지막에 호출". KoreaUserBuilder클래스가 가지고 있던 멤버변수를 'KoreaUser' 생성자에 그대로 매개변수로 넣음 
		public KoreaUser build() { 
			return new KoreaUser(userId, username, password, name, email); 
		}
		
		//자기 자신을 리턴 -> ..builder 객체 주소이므로 builder클래스 메소드를 계속 쓸 수 있다.
		public KoreaUserBuilder userId(int userId) {
			this.userId = userId;
			return this;
		}
		
		public KoreaUserBuilder username(String username) {
			this.username = username;
			return this;
		}
		
		public KoreaUserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public KoreaUserBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public KoreaUserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		
	}
	
}
