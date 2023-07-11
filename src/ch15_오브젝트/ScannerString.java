package ch15_오브젝트;

import java.util.Scanner;

public class ScannerString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String username = "aaa";
		String password = "1234";
		String inputUsername = null;
		String inputPassword = null;
		
		System.out.print("아이디: ");
		inputUsername = scanner.nextLine(); //nextLine()은 buffer의 특성상 새로운 주소를 할당하는 거임 -> 주소 비교하면 false 뜸
		System.out.print("비밀번호: ");
		inputPassword = scanner.nextLine();
		
		
		System.out.println("입력한 ID: " + inputUsername.hashCode() + "PW: "+ inputPassword.hashCode());
		System.out.println();
		
		
		//!=: 주소 비교 -> String 클래스에서 오버라이딩한 equals()를 사용 하여 값 비교
		if(!username.equals(inputUsername)) {
			System.out.println("아이디가 일치하지 않습니다.");
			return;
		} 
		
		if(!password.equals(inputPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		System.out.println("로그인 성공!");
	}

}
