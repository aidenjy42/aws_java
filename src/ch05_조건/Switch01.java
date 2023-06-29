package ch05_조건;

import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
//		String cmd = "";
		
		System.out.print("명령 선택: ");
//		cmd = scanner.next();
		
		char cmd = scanner.next().charAt(0);
		//-> case 'c': ... case 'r': ...
		
		switch (cmd) {
			case 'c':
				System.out.println("데이터를 생성합니다.");
				break;
			case 'r':
				System.out.println("데이터를 조회합니다.");
				break;
			case 'u':
				System.out.println("데이터를 수정합니다.");
				break;
			case 'd':
				System.out.println("데이터를 삭제합니다.");
				break;
			default:
				System.out.println("나머지 처리");
		}
	}

}
