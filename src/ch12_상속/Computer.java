package ch12_상속;

public class Computer extends Product {
	private String type;

	//shift alt s 해서 superclass 생성자 생성하기
//	public Computer(String model, int price) {
////		컴퓨터 객체 생성할 때 product도 같이 생성하겠다는 의미
//		super(model, price);
//	}
	
//  shift alt s 해서 using fields 클릭
	public Computer(String model, int price, String type) {
		super(model, price);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
//	public Computer() {
//		super("",10); //super==상위 클래스!  //생략되어 있음
//		//상위 클래스는 AllArgs니까 매개변수 필요
//		System.out.println("컴퓨터 객체 생성");
//	}
	
}

