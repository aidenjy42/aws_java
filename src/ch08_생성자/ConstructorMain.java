package ch08_생성자;

public class ConstructorMain {

	public static void main(String[] args) {
		Constructor01 constructor01 = new Constructor01();
		//Constructor01() : 생성자
		//생성자 호출한다 == 메모리에 할당된다 == 메모리 할당한 그 주소를 반환한다 
		//생성자 호출 후 할당된 메모리 주소를 변수에 대입
		System.out.println(new Constructor01()); //"생성자 호출" 출력 후 객체 주소값 출력
	}

}
