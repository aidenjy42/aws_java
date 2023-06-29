package ch03_연산자;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int score = 80;
		String grade = score < 0 || score > 100 ? "X"
						: score >= 90 ? "A" 
						: score >= 80 ? "B"
						: score >= 70 ? "C"
						: score >= 60 ? "D" 
						: "F";
						
		int a = 1 + 2 + 3 +
				4 + 5;

	}

}
