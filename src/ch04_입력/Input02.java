package ch04_입력;

import java.util.Scanner;

public class Input02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/*
		 * 이름:
		 * 나이:
		 * 연락처:
		 * 주소:
		 * 성별:
		 * 
		 * 고객님의 이름은 ___이고 나이는 __세입니다.
		 * 연락처는 010-0000-0000이며 주소는 부산 ... 입니다.
		 * 성별은 _ 입니다.
		 */
		
		String name = "";
		int age = 0;
		String phone = "";
		String address = "";
		String gender = "";
		
		System.out.print("이름: ");
		name = scanner.next(); 
		System.out.print("나이: ");
		age = scanner.nextInt();
		//위 next()에서 enter 친 걸 nextInt가 받고 또 입력하고 enter 치면 다음에 enter가 남음 
		System.out.print("연락처: ");
		phone = scanner.next(); //또 next() 함수는 enter를 무시함
		//-> 입력하고 엔터키 치면 버퍼에 enter가 남음
		scanner.nextLine(); //버퍼에 남은 enter를 nextLine()으로 처리
		System.out.print("주소: ");
		address = scanner.nextLine();
		System.out.print("성별: ");
		gender = scanner.nextLine();
		
		System.out.println("고객님의 이름은 " + name + "이고 나이는 " + age + "세입니다.");
		System.out.println("연락처는 " + phone + "이며 주소는 " + address + "입니다.");
		System.out.println("성별은 " + gender + "입니다.");
	}

}
