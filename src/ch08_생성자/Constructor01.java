package ch08_생성자;

public class Constructor01 {
	
	Constructor01() {
		/*생성자의 특징
		* 반환형이 없다.
		* 클래스이름과 동일하다.
		* 메소드처럼 오버로딩이 가능하다.(
		* NoArgsConstructor
		* RequiredCostructor
		* AllArgsConstructor)
		* 
		* 아무 생성자가 없을 시 기본 생성자가 존재한다.
		*/
		System.out.println("생성자 호출");
		//생성자 오버로딩은 후에 Dependency Injection에서 중요함
	}
	
}
