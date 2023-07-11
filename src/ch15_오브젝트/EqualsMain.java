package ch15_오브젝트;

public class EqualsMain {

	public static void main(String[] args) {
		KoreaStudent koreaStudent1 = new KoreaStudent("20230001", "변정민");
		KoreaStudent koreaStudent2 = new KoreaStudent("20230002", "정가영");
		KoreaStudent koreaStudent3 = new KoreaStudent("20230003", "정혜성");
		KoreaStudent koreaStudent4 = new KoreaStudent("20230001", "변정민");
		
		//주소 비교
		System.out.println(koreaStudent1 == koreaStudent4); //false 
		
		// 값 비교
		System.out.println(koreaStudent1.getStudentCode() == koreaStudent4.getStudentCode()
				&& koreaStudent1.getName() == koreaStudent4.getName());
		
		System.out.println(koreaStudent1.equals(koreaStudent4)); //위 값 비교 코드와 같음
		
	}

}
