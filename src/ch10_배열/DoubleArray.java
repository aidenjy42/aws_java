package ch10_배열;

public class DoubleArray {
	public static void main(String[] args) {
		String[][] students = new String[2][2];

		//0행 : 이름
		//1행 : 주소

		//0열 : 김준일에 대한 정보
		//1열 : 김해원에 대한 정보
		students[0][0] = "김준일";
		students[0][1] = "김해원";
		students[1][0] = "부산";
		students[1][1] = "서울";

		//students.length : 행의 개수!
		//students[i].length: 열의 개수 -> 즉 이차원 배열은 배열 안에 배열이 들어있는 상태
		for(int i = 0; i< students.length; i++){
			for(int j = 0; i < students[i].length; j++){
				System.out.println(students[i][j]);
			}
		}


	}
}
