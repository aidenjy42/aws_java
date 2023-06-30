package ch11_문자열;

public class StringBuilder01 {

	public static void main(String[] args) {

		StringBuilder builder = new StringBuilder();

		// append(추가)는 가장 뒤에 추가한단 의미
		builder.append("이름: ");
		builder.append("우주영");
		

		// delete : 삭제할 인덱스 범위
		int index = builder.indexOf(":"); // 콜론 지우기
		builder.delete(index, index + 1);

		//insert : 특정 인덱스에 문자 삽입
		builder.insert(2, ">>");
		
		String str = builder.toString();
		System.out.println(str);
		
		//String형일 경우 삭제 방법
		String name = "이름: 김준일";
		int index2 = name.indexOf(":");
		System.out.println(name
				.substring(0, index2)
				.concat(name.substring(index2 + 1)));
				//substring(index), substring(sindex, eindex) -> 메소드 오버로딩!
		
	}

}
