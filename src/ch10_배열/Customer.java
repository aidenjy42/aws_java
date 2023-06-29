package ch10_배열;

public class Customer {
	private String name;
	private String rating;
	
	//AllArgs
	public Customer(String name, String rating) { //생성자도 default로 설정되어있으면 외부 패키지에서 접근 불가
		this.name = name;
		this.rating = rating;
	}

	public void showInfo() {
		System.out.println("고객명: " + name);
		System.out.println("고객 등급: " + rating);
		System.out.println();
	}
	
}
