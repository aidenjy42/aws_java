package ch18_빌더;

public class KoreaUserMain {

	public static void main(String[] args) {
		
//		KoreaUser koreaUser = new KoreaUser(1, "aaa","1234", "김준일", "aaa@gmail.com");
		//생성할 때마다 어디 위치에 어떤 변수를 넣어야할지 일일이 매개변수 확인하고 넣어야 함 -> 넣고 싶은 거만 골라서 넣을 수 있게 할 수 없을까
		
		//builder()함수: KoreaUserBuilder 클래스 객체를 할당(주소 생성)하여 
		//자기 자신을 리턴하니까 자기 메소드를 계속 호출 할 수 있음!!
		KoreaUser koreaUser = KoreaUser.builder() 
										.userId(1)
										.username("aaa")
										.password("1234")
										.name("우주영")
										.email("aaa@gmail.com")
										.build(); // KoreaUser 객체를 생성하기 위해 마지막에 KoreaUser 주소를 생성하여 반환
		
		
//		KoreaUser koreaUser2 = new KoreaUser(1,null,null,null,null);
//		
//		KoreaUser koreaUser3 = new KoreaUser();
//		koreaUser3.setUserId(1);
//		
//		KoreaUser koreaUser = KoreaUser.builder() 
//				.userId(1).build();
		
	}

}
