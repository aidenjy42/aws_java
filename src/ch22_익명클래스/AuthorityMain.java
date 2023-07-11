package ch22_익명클래스;
//한 파일에 여러 클래스는 가능하나, public class는 한개 뿐이다
public class AuthorityMain {
//익명 클래스: 이름 없는 클래스, '클래스'가 없다.
	
	////인터페이스를 구현하려면 그 클래스는 반드시 오버라이딩해야 함
		//-> 따로 클래스를 만들지 않고 
	public static void main(String[] args) {
		GrantedAuthorities authorities = new GrantedAuthorities() { 
			//인터페이스를 상속구현한 A 객체 생성 하는 방식과 똑같으나, 따로 클래스명이 없음 --> 익명 클래스
			
			@Override
			public String getAutority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		System.out.println(authorities.getAutority());
		
		A a = new A();
		System.out.println(a.getAutority());
	}

}
//인터페이스 구현방법2: 클래스를 따로 만듦 -> 구현된 형태가 한번만 사용될 때는 비효율적이다.
class A implements GrantedAuthorities { //접근 지정자 생략시 default

	@Override
	public String getAutority() {
		System.out.println("두번째 권한 출력");
		return "ROLE_ADMIN";
	}
	
}