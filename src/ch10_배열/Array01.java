package ch10_배열;

public class Array01 {

	public static void main(String[] args) {
		// 배열 생성법1
		int[] numbers = new int[5]; // 동적 할당-> numbers는 주소!
		// 배열: 같은 사이즈를 5개 묶어 순서대로 나열된 것. 그것 통째로 주소를 할당

//		System.out.println(numbers); //주소값

		// 배열 원소 참조 : [] (인덱스). 인덱스는 정수값
//		System.out.println(numbers[0]);
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;

		int index = 3;
//		System.out.println(numbers[index]);

		// 배열명.length : 배열 크기
		// 반복문은 0부터 'length 전'까지
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		// 배열 생성법2
		int[] numbers2 = { 1, 2, 3, 4, 5 }; // 배열은 크기를 늘릴 수 없다.
		// 생성법3
		int[] numbers3 = new int[] { 1, 2, 3, 4, 5 };

		sum(numbers);
//		sum({1,2,3,4,5}); //안됨
		sum(new int[] { 6, 7, 8, 9, 10 });
		// 배열 값 자체를 매개변수로 쓰려면 new int[]를 이용해 주소를 할당시켜줘야함
	}

	public static void sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
			// result = result + array[i];
		}
		System.out.println(result);
	}

}
