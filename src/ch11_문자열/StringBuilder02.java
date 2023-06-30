package ch11_문자열;

public class StringBuilder02 {

	public static void main(String[] args) {
		//권한
		String[] roles = {
				"ROLE_USER",
				"ROLE_MANAGER",
				"ROLE_ADMIN"
		};
		
		String strRoles = "";
		//배열 원소들을 모두 붙인 문자열 형태로 
		for(int i = 0; i < roles.length; i++) {
			strRoles += roles[i];
			if(i != roles.length -1) {
				strRoles += ", ";
			}
		}
		System.out.println(strRoles);
		
		//StringBuilder로 문자열 만들기
		StringBuilder strRolesBuilder = new StringBuilder();
		
		//배열원소 마다 뒤에 ", "를 append()로 붙인다
		for(int i = 0; i< roles.length; i++) {
			strRolesBuilder.append(roles[i] + ", ");
		}
		//마지막에 붙은 ", "는 지운다
		strRolesBuilder.delete(strRolesBuilder.lastIndexOf(", "), strRolesBuilder.length());
		
		System.out.println(strRolesBuilder.toString());
		
	}

}
