package 단위평가.단위1;


abstract class Program {
	public abstract void develop();
}

class Java extends Program {

	@Override
	public void develop() {
		System.out.println("자바 프로그램을 개발합니다.");
	}
	
	public void garbageCollection() {
		System.out.println("메모리를 정리합니다.");
	}
	
}

class C extends Program {

	@Override
	public void develop() {
		System.out.println("C 프로그램을 개발합니다.");
	}
	
	public void defineStructure() {
		System.out.println("구조체를 정의합니다.");
	}
	
}


public class Casting {

	public static void main(String[] args) {
		Program[] programs = new Program[2];
		
		programs[0] = new Java();
		programs[1] = new C();
		
		for(int i = 0; i < programs.length; i++) {
			
			if(programs[i].getClass() == Java.class) {
				Java j = (Java) programs[i];
				j.develop();
				j.garbageCollection();
			}
			if(programs[i] instanceof C) { //programs[i].getClass() == C.class
				C c = (C) programs[i];
				c.develop();
				c.defineStructure();
			}
		}
		
	}

}
