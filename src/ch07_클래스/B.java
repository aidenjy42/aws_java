package ch07_클래스;

public class B {
	
	//반환x, 매개변수x
	void test1() {
		System.out.println("test1 메소드 호출");
	}
	
	//반환(정수), 매개변수 x
	int test2() {
		System.out.println("test2 메소드 호출");
		return 100;
	}
	
	//반환(boolean), 매개변수 x
	boolean test3() {
		System.out.println("test3 메소드 서비스를 실행합니다.");
//		return true;
		return test2() == 100; //test2()의 반환결과가 100이면 true 반환->main의 if의 조건으로 들어감
	}
	
	void test4(String name, int age) { //매개변수를 통해서도 변수 선언, 즉 메모리 할당을 함
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	//메소드 오버로딩: 매개변수의 자료형과 개수, 순서를 다르게하면 같은 함수명이어도 됨
	void test4(int age, String name) {
		System.out.println("나의 이름: " + name);
		System.out.println("나의 나이: " + age);
	}

}
