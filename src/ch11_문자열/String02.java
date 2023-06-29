package ch11_문자열;

public class String02 {

	public static void main(String[] args) {
		String phone = "010-9988-1916";
		
		int index = phone.indexOf("-"); //해당 문자열이 시작되는 인덱스를 반환
		int lastIndex = phone.lastIndexOf("-"); ///뒤에서 부터 탐색해서 처음 발견하는 인덱스
		System.out.println(index);
		System.out.println(lastIndex);
		
		String midNumber = phone.substring(index + 1 , lastIndex); 
		System.out.println(midNumber);
		
		boolean findFlag = phone.contains("010");
		System.out.println(findFlag);

		
	}

}
