package ch05_조건;

import java.util.Scanner;

public class IfScore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		String grade = "";
		
		System.out.print("점수 입력: ");
		score = scanner.nextInt();
		
		if(score < 0 || score > 100) {
			grade = "x";
			
		} else if(score >= 90) {
			grade = "A";
		} else if(score >= 80) {
			grade = "B";
		} else if(score >= 70) {
			grade = "C";
		} else if(score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.println("성적: " + grade);
	}

}
