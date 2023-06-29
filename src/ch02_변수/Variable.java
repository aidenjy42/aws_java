package ch02_변수;

public class Variable {

	public static void main(String[] args) {
		boolean flag; //변수 선언법 : (자료형) (변수명);
		flag = true; //변수 초기화(대입) : (변수명) = (값);
		System.out.println("FLAG : " + flag);
		System.out.print("FLAG : ");
		System.out.println(flag);

		System.out.println();
		char lastName = '김'; //선언과 초기화를 동시에 가능
		System.out.println(lastName);
		
		int number = 100;
		System.out.println("번호: " + number);
		
		double pi = 3.14;
		System.out.println(pi);
		
		String name = "김준일"; //String: 참조 자료형
		System.out.println(name);
		
		//형변환(캐스팅)
		//캐스팅 범위: 문자 < 정수 < 실수 < String. 범위가 큰 자료형으로 바꾸면 업캐스팅, 반대는 다운캐스팅
		String num1 = "10";
		int num2 = 10;
		
		System.out.println("String: " + num1);
		System.out.println("int: " + num2);
		System.out.println(num1 + num2); //num2(정수)가 num1(문자열) 만나 문자열로 업캐스팅
		
		char num3 = '5'; //아스키코드 53
		System.out.println(num3 + num2); //num3(char)가 num2를 만나 정수로 업캐스팅
		System.out.println((double) num3); //53. 강제 업캐스팅
		
		System.out.println((double) '3'); //크기 : double > char
//		System.out.println((double) "3"); //에러. 크기: String > double
		
		//1. 묵시적 형변환(업캐스팅_ char -> int -> double)
		int num4 = num3; //53 //char -> int  //int num4 = (int) num3; 에서 (int)가 생략
		//2. 명시적 형변환(다운캐스팅_ double -> int -> char
		char num5 = (char) num4; //(char) 안 붙여주면 에러
		
	}

}
