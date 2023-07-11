package ch18_빌더;

public class UserTest {
	
	//static 메소드에서는 static 메소드만 호출 가능
	public static void printUser() {
		System.out.println("사용자 정보 출력");
		//여기 안에서 test()를 호출하려면?
		//UserTest 객체를 먼저 생성!
		(new UserTest()).test();		
		
		//내부 static 클래스 객체 생성법
		new UserTestTest(); //UserTest() 내부에 UserTestTest()가 있으므로 UserTest.을 생략해도 됨
		new UserTest.UserTestTest(); //위와 같음. 근데 외부에서는 반드시 UserTest를 붙여줘야함
	}	
	
	public void test() {
		System.out.println("테스트 메소드 호출");
	}
	
	//클래스 안에 클래스 작성 가능(내부 클래스)
	//내부 클래스가 static으로 선언이 안돼 있으면 객체를 생성한 뒤에 생성을 해야함
	//내부 클래스도 주소가 생성된 다음에 해야 된다. 그래서 new UserTest() 한 다음 new UserTestTest() 해야 됨
	public static class UserTestTest {
		public void testTest() {
			System.out.println("테스트 테스트 메소드 호출");
			
		}
		
	}
	
}
