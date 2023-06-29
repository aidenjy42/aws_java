package ch03_연산자;

public class Operator01 {

	public static void main(String[] args) {
//		System.out.println(3 / 2);
//		System.out.println(3 / 2.0); //자동 캐스팅
		
		int num = 10; //변수를 선언과 동시에 초기화
//		System.out.println(num++); //++, -- 
//		System.out.println(num); //num = num + 1;
		
		System.out.println(num++); //10
		System.out.println(num++); //11
		System.out.println(num);  //12
		System.out.println(--num); //11
		System.out.println(num++); //11
		System.out.println(num); //12
	}

}
