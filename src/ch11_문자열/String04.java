package ch11_문자열;

public class String04 {

	public static void main(String[] args) {
		String phone = "    010-7130.4791     "; 
		
		//기존 문자를 다른 문자로 대체
		String replacePhone = phone
				.replaceAll("-","")
				.replaceAll(" ", "")
				.replaceAll("[.]","");
				//'.'은 문자열로 판단하지 않아서 [] 안에 써줘야함 
		//replaceAll: 반환형이 String=> 또 문자열 관련함수 쓸 수 있다
		System.out.println(phone);
		
		String phone2 = phone.trim(); //앞뒤에 공백 존재 시 공백 제외
		System.out.println(phone2);
	}

}
