package ch18_빌더;

public class KoreaUserBuilder2 {
	//디자인 패턴_빌더 패턴-> KoreaUser 클래스 안에 그대로 들어가서 이 파일 안 씀
	private int userId;
	private String username;
	private String password;
	private String name;
	private String email;
	
	public KoreaUser build() {
		return new KoreaUser(userId, username, password, name, email); //가장 마지막에 KoreaUserBuilder클래스가 가지고 있던 멤버변수를 KoreaUser 생성자에 그대로 매개변수로 넣음 
	}
	
	//자기 자신을 리턴
	public KoreaUserBuilder2 userId(int userId) {
		this.userId = userId;
		return this;
	}
	
	public KoreaUserBuilder2 username(String username) {
		this.username = username;
		return this;
	}
	
	public KoreaUserBuilder2 password(String password) {
		this.password = password;
		return this;
	}
	
	public KoreaUserBuilder2 name(String name) {
		this.name = name;
		return this;
	}
	
	public KoreaUserBuilder2 email(String email) {
		this.email = email;
		return this;
	}
	
	
}
