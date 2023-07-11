package ch22_익명클래스;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		//람다식(화살표 함수)
		//람다식을 이용한 프로그래밍을 '함수형 프로그래밍'이라고 한다.
		//클래스와 함수 정의를 동시에 하므로 함수명을 쓰지 않음
		//-> 람다식을 쓰려면 인터페이스에는 하나의 추상메소드만 가능하다
		//-> 람다식 이용할 때는 @FunctionalInterface 로 메소드를 하나로 제한시킨다.
		
		GrantedAuthorities authorities1 = new GrantedAuthorities() { //인터페이스는 객체 생성 불가 -> 익명 클래스로 객체 생성
//			생성과 메소드 정의가 동시에 이루어진다.
			@Override
			public String getAutority() { //메소드 구현
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		//위와 같으므로 아래도 또 하나의 Granted.. 클래스 객체가 생성된 것!! -> 그래서 Granted 메소드를 사용할 수 있다
//		GrantedAuthorities authorities2 = () -> { //() -> {} 는 반드시 앞에 대입이 필요함
//			System.out.println("권한 출력");
//			return "ROLE_USER";
//		};
		
		GrantedAuthorities authorities2 = () -> "ROLE_USER";
		System.out.println(authorities2.getAutority());
		
		//test ( forEach)
		Integer[] test= {1,2,3,4,5,6,7,8,9,10};
		Arrays.asList(test).forEach(num -> { //람다식 은 매개변수의 자료형을 생략할 수 있음. 매개변수가 하나만 있으면 ()를 생략할 수 있음
			System.out.println(num); 
		});
		
	}

}
