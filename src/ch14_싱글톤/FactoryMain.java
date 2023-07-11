package ch14_싱글톤;

public class FactoryMain {

	public static void main(String[] args) {
		
//		Samsung samsung = new Samsung(); //생성자가 private -> 외부에서 객체 생성 불가
		Samsung samsung = Samsung.getInstance(); //static메소드를 만들어 대신 삼성 객체 생성
		System.out.println(samsung.getCompanyName());//가능
		
		//싱글톤: 하나의 유일한 객체를 만들게끔 하고 그 하나로 조작하는 것. 그리고 어디서나 접근이 쉽게 만드는 것
		
		SamsungFactory factory1 = new SamsungFactory();
		SamsungFactory factory2 = new SamsungFactory();
		
		//factory1.produce("갤럭시s") == Galaxy 객체
		factory1.produce("갤럭시s").showInfo();
		factory1.produce("갤럭시s2").showInfo();
		factory1.produce("갤럭시s3").showInfo();
	}

}
//package ch14_싱글톤;
//
//
//public class FactoryMain {
//
//	public static void main(String[] args) {
//		Samsung samsung = Samsung.getInstance();
//		System.out.println(samsung.getCompanyName());
//		
//		SamsungFactory factory1 = new SamsungFactory();
//		SamsungFactory factory2 = new SamsungFactory();
//		
//		factory1.produce("갤럭시s").showInfo();
//		factory2.produce("갤럭시s2").showInfo();
//		factory1.produce("갤럭시s3").showInfo();
//		
//		
//		
//	}
//	
//}



