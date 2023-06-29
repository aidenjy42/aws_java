package ch07_클래스;

public class BMain {

	public static void main(String[] args) {
		B b1 = new B();
		
		b1.test1(); //반환값 없음
		int num1 = b1.test2(); 
		System.out.println(num1);
		int num2 = 200;
		System.out.println(b1.test2()); //함수 내부 문장 수행 후 종료하면서 반환된 100을 출력
		
		if(b1.test3()) { //test3()의 반환형은 논리형이므로 if 조건에 들어갈 수 있음
			System.out.println("if문을 실행합니다");
		}
		
		b1.test4("김준일", 30);
		b1.test4(30, "김준일"); //메소드 오버로딩
		
	}

}
