package ch17_추상;

public class TestB extends TestA {
	@Override
	public void test() {
		System.out.println("재정의해서 쓸 거임"); //추상 클래스를 상속하려면 추상 클래스 내의 메소드를 오버라이드해줘야 한다.
		// 인터페이스는 멤버 변수 불가능, 스태틱 상수만 가능
		// 추상 클래스와 인터페이스의 중요한 차이: 다중상속 가능여부!
	}
}

