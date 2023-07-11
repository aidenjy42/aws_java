package ch15_오브젝트;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class GetClassMain {

	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "김채원");

		//getClass : 무슨 클래스인지 클래스 타입 반환
		Method[] methods = koreaStudent.getClass().getDeclaredMethods();

		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
			System.out.println(methods[i].getReturnType());
			
		}

		Field[] fields = koreaStudent.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		//객체 주소 할당됐으면 getClass() 이용, 클래스명에서는 .class 이용
		System.out.println();
		//getClass와 instanceof 차이
//		System.out.println(Object.class == koreaStudent.getClass()); //상속 관계에서 안됨 - 다운캐스팅 불가
		System.out.println(koreaStudent instanceof Object);//위와 같다! 
		//가능 포함관계 허용, 다운캐스팅 가능 -> 정확하게 클래스타입 확인이 안돼서 모호하다는 이유로 신 버전에서 삭제됨
		
		System.out.println(koreaStudent instanceof KoreaStudent);
		System.out.println(koreaStudent.getClass().getSimpleName()); //클래스명만
		System.out.println(koreaStudent.getClass().getName()); //패키지까지 출력
	}

}
