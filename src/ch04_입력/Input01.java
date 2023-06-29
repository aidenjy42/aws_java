package ch04_입력;

import java.util.Scanner;

public class Input01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("입력1: ");
		String input1 = scanner.nextLine();
		//next(): 문자열 입력받고 엔터 치면 다음 문장 수행
		//띄어쓰기 포함되면 공백이 다음 입력을 받은 걸로 판단
		//nextLine() : 띄어쓰기 포함 문자열 입력함수
		System.out.print("입력2: ");
		String input2 = scanner.next();
		
		//nextInt(): 정수형 입력 함수
		System.out.println("출력: " + input1);
		System.out.println("출력2: " + input2);
		System.out.println("입력 완료");
		
	}

}
