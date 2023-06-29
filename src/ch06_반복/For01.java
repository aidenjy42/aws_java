package ch06_반복;

public class For01 {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
//		System.out.println(numbers[0]);
		
		for(int i = 0; i < 6; i++) {
			System.out.println(numbers[i]);
			System.out.println("i: " + i);
		}
//		for(int i = 0, j = 0; i < 6; i++, j++) System.out.println(numbers[i]); 이렇게도 쓸 수 있음
		
		
	}

}
