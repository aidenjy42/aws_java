package ch15_오브젝트;

import java.util.Objects;

public class KoreaStudent {
	private String studentCode;
	private String name;
	
	public KoreaStudent(String studentCode, String name) {
		super();
		this.studentCode = studentCode;
		this.name = name;
	}
	
//	@Override //@ : annotation. 없어도 오버라이딩으로 판단함.(생략 가능)
//	//오버라이딩: 부모 클래스의 메소드를 그대로 가져와 함수 내부만 재정의
//	public boolean equals(Object obj) {
//		KoreaStudent koreaStudent = (KoreaStudent) obj; //다운캐스팅해야 studentCode 참조 가능
//		boolean equalsFlag = this.studentCode.equals(koreaStudent.studentCode)
//				&& this.name.equals(koreaStudent.name);
//		return equalsFlag;
//	}
//	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, studentCode);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 주소 비교
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass()) //instanceof와 같음
			return false;
		KoreaStudent other = (KoreaStudent) obj; //다운캐스팅
		return Objects.equals(name, other.name) && Objects.equals(studentCode, other.studentCode);
	}
	
	
	
	@Override
	public String toString() {
		return "KoreaStudent [studentCode=" + studentCode + ", name=" + name + "]";
	}

	public String getStudentCode() {
		return studentCode;
	}

	public String getName() {
		return name;
	}

	public void showInfo() {
		System.out.println("학번: " + studentCode);
		System.out.println("이름: " + name);
		System.out.println("=====================");
	}
}
