package ch23_예외;

public class ArrayExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = new Integer[] { 10, 20, 30, 40, 50 };

		for (int i = 0; i < nums.length + 1; i++) {
			try {
				System.out.println("index[" + i + "]: " + nums[i]); //nums[i] 부분에서 런타임 에러 발생
				//여기서 ArrayIndexOutOfBoundsException라는 클래스 객체가 생성되는 것임 -> 그래서 catch() 함수의 매개변수 타입으로 이 클래스 타입이 들어감
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 크기를 벗어났습니다.");
			} catch(NullPointerException e) { //catch()는 여러번 쓸 수 있다.
				System.out.println("참조할 수 없는 주소입니다.");
			} catch(RuntimeException e) { //모든 예외 클래스는 RuntimeException을 상속받으므로 모든 런타임 에러 catch 가능
				System.out.println("나머지 모든 예외 처리");
			} catch(Exception e) { //런타임 에러로 못 잡을 때
				System.out.println("최종 예외 처리"); //catch 블록들의 순서 중요
			} finally { //예외 여부와 상관없이 실행됨
				System.out.println("모든 상황에서 실행됨");
			}
		}
		
		System.out.println("프로그램 정상 종료");
	}

}
