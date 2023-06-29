package ch06_반복;

public class For02 {

	public static void main(String[] args) {
		
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		for(int i = 0; i < 10; i++) { 
			//초기값은 무조건 0, 조건에 해당하는 값은 반복횟수 'n'.
			//=> 0 ~  n-1 => n번 반복
			System.out.println(i);
		}
		
		String str = "코리아아이티";
		System.out.println(str.substring(0, 3));
	}

}
