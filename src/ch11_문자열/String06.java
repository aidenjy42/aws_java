package ch11_문자열;

public class String06 {

	public static void main(String[] args) {
		String token = "Bearer aaabbbbb.ccccccdddd.eeeeeeffffff";//나중에 JWT 쓸 때
		
		//"Bearer로 시작하는지 알아보기
		//endsWith도 있음 (확장자명 확인할 때 씀)
		boolean flag = token.startsWith("Bearer");
		System.out.println(flag);
		
		String url = "/api/v1/user/1";
		
		boolean flag2 = url.startsWith("/api/v1");
		
		if(flag2) {
			System.out.println("api 버전1 사용");
		}
		
	}

}
