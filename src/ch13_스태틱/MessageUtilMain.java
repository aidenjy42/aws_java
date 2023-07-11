package ch13_스태틱;

import ch10_배열.Array01;

public class MessageUtilMain {
	private int a;
	
	public static void main(String[] args) {
//		System.out.println(a); //오류. 스태틱이 아니라서 객체 생성되어야 메모리가 할당됨-> 객체 생성 하고 변수 써야 됨
		MessageUtilMain messageUtilMain = new MessageUtilMain();
		System.out.println(messageUtilMain.a);
		//추가
//		Array01.main(null); //main이 static 함수이므로 Array01 클래스를 import하면 main함수를 호출할 수 있음
//		Array01.sum();
		
		MessageUtil messageUtil = new MessageUtil();
//		messageUtil.sendMail();
//		messageUtil.sendFile();
		
//		//static을 쓰는 이유
		//객체를 생성할 필요가 없다.
		MessageUtil.sendFile();
		System.out.println();//System 클래스의 out이라는 static 변수
		
		MessageUtil.data = "안녕";
		System.out.println(MessageUtil.data);
		System.out.println(messageUtil.data);
		//스태틱은 메모리를 공유함
	}

}
