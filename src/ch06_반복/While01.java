package ch06_반복;

import java.util.Scanner;

public class While01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selectedNumber = 0;
		boolean flag = true;
		
		while(flag) {
			System.out.println("[메뉴]");
			System.out.println("1. 1번");
			System.out.println("2. 2번");
			System.out.println("3. 3번");
			System.out.println("4. 4번");
			System.out.println("5. 종료");
			System.out.print("메뉴 번호: ");
			
			selectedNumber = scanner.nextInt();
			
			if(selectedNumber == 5) {
				flag = false; // == break;
			} else if(selectedNumber == 1) { //1번 메뉴(하위 1)
				boolean flag2 = true; 
				//1번 메뉴로 들어올때마다 flag2를 true로 바꿔줘야함 -> 그래야 하위 while문이 실행됨
				char selectedMenu = 0;
				
				while(flag2) {
					System.out.println("[1번 메뉴 안쪽]");
					System.out.println("a. a 메뉴");
					System.out.println("b. b 메뉴");
					System.out.println("c. 뒤로가기");
					System.out.println("d. 종료");
					System.out.print("메뉴 선택: ");
					
					selectedMenu = scanner.next().charAt(0);
					if(selectedMenu == 'c') {
						flag2 = false; // 외부 while 로 빠져나가기!
					}
				}
			}
		}
		System.out.println("프로그램 종료");
		
	}

}
