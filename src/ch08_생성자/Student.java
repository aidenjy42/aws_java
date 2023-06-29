package ch08_생성자;

public class Student {
	final String name; //필수 입력이므로 상수 처리
	int age;
	String address;
	
	//필수 생성자가 생성된 시점에는 기본 생성자가 비활성화된다.
	//(이유: 필수 입력해야하는 멤버가 있으므로 NoArgs는 효력이 없음
//	Student() { 
//		name = "";
//		System.out.println("NoArgsConstructor");
//		System.out.println("학생 한 명을 생성합니다. ");
//	}
	
	//오버로딩된 생성자
	//생성자도 메소드이기 때문에 똑같은 생성자를 만들 수 없다.
	Student(String name, int age, String address) { 
		//함수의 매개변수는 그 함수의 지역변수->위의 name, age ..와 다른 변수!
		//그래서 name을 인자로 받아서 위의 name에 값을 대입하고 싶으면 this를 사용
		
		//this: 객체 생성 시에 생성되는 자기 인스턴스의 주소값 -> .을 통해 주소 참조
		this.name = name; //변수 색깔 
		this.age = age;
		this.address = address;
		
		System.out.println("AllArgsConstructor");
	}
	
	//RequiredArgsConstructor : 필수 생성자
	//Req.
	Student(String name){
		System.out.println("RequiredArgsConstructor");
		this.name = name;
	}
}
