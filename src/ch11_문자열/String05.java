package ch11_문자열;

public class String05 {

	public static void main(String[] args) {
		String name = ""; 
		boolean flag = name.isBlank();
		System.out.println(flag);
		
		boolean flag2 = name.isEmpty();
		System.out.println(flag2);
		//""일때 true, true
		//" "일때 true,false
		
		//Empty는 띄어쓰기는 문자열로 판단해서 false로 뜸
	}

}
