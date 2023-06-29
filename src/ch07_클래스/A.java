package ch07_클래스;

public class A {
	int num1;
	int num2;
	
	void test1() { //메소드: 클래스 안에 있는 함수
		//함수: 입력값에 따라 "정해진 논리" 에 의해 반환값이 정해지는 것 -> 기능
		System.out.println("테스트1 함수 호출");
	}
	
	void test2(int x, int y) {
		System.out.println("x값: " + x);
		System.out.println("y값: " + y);
	}
	
	void test3() {
		System.out.println("num1 : " + num1); //num1,2는 전역변수 -> test3() 내부에서 사용 가능
		System.out.println("num2 : " + num2);
	}
}
