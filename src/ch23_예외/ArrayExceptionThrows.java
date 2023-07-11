package ch23_예외;

import javax.management.RuntimeErrorException;

public class ArrayExceptionThrows {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		
			try {
				printArray(nums);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //Exception 예외 처리를 반드시 하라는 의미의 빨간 줄이 뜸 -> 함수에 마우스 올려서 surround with try/catch 클릭 -> try/catch 예외 처리문 만들어줌

			
		System.out.println("프로그램 정상 종료");
	}

	public static void printArray(Integer[] numArray) throws Exception/* throws : 예외를 미루는 거임*/ {

		if(true) {
			throw new RuntimeException("내가 강제로 생성한 예외"); //무조건 이 문장이 실행됨 ->  catch가 받음
			//throw: 강제 예외 생성 -> 
		}
		//아래 문장이 실행이 안됨
		//노란줄: 문장이 실행이 안돼서 필요 없는 코드라는 의미
		for (int i = 0; i < numArray.length + 1; /* 예외 발생 */ i++) {
			System.out.println(numArray[i]);
		}

	}
}
