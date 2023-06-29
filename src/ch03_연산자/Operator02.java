package ch03_연산자;
/*
 * 논리연산자; 결과는 true 또는 false
 * 1. && -> and(그리고) - 곱
 * 	true && false => false
 * 	true && true => true
 * 2. || -> or(또는) - 합
 * 	true || false => true
 * 3. ! -> not(부정) - 반전
 * 	!(true || false) => false
 */
public class Operator02 {

	public static void main(String[] args) {
//		final int MAX = 100;
//		final int MIN = 0;
//		int num = -10;
//		
//		System.out.println(MAX < num); //false
//		System.out.println(MIN < num || MAX > num );
		
		int year = 2000;
		
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0);
		
		/*
		 * year % 4 == 0 && year % 100 != 0 || year % 400 == 0
		 * 
		 * year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
		 */
		int result = 10 + 1;
		System.out.println(result);
		
		boolean result2 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0; //연산 결과는 boolean type
		System.out.println(result2);
		
		int result3 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0; //조건이 참,거짓 일 때 값 두개는 자료형이 같아야 함
		System.out.println(result3);
	}

}

