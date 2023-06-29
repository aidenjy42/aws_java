package ch06_반복;

public class While02 {

	public static void main(String[] args) {
		//for와 while의 차이
		/*
		 * for는 자신만의 지역변수 사용
		 * while은 전역 변수 사용
		 */

		int i = 0;
		
		while(i < 10) {
			if(i % 2 == 0) {
				i++; // 위치 조심. continue 전에 실행해야 됨
				continue; 
			}
			System.out.println(i);
			i++;
		}
	}

}
