package ch15_오브젝트;

public class ToStringMain {

	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "김영훈");
		
		System.out.println(koreaStudent); //출력 시에는 toString() 생략 가능
		System.out.println(koreaStudent.toString()); //같음

		String str = koreaStudent.toString();
//		String str2 = koreaStudent; 
	}

}
