package ch09_접근지정자;

public class Student2 {
	private String name;
	private int age;
	
	private void test() {
		System.out.println("private 메소드"); //외부에서는 이 메소드를 쓸 수 없음
		//클래스 내에서만 사용 가능
	}
	
	//Setter
	//생략하면 default: 동일 패키지 안에서만
	public void setName(String name) { 
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//Getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
}
