package 단위평가.단위1;

class Calculator {
	
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	int sub(int num1, int num2) {
		return num1 - num2;
	}
}

public class Main0 {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.add(10, 20));
		System.out.println(calculator.sub(200, 100));
	}
}