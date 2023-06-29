package ch10_배열;

public class CustomerArrayMain {

	public static void main(String[] args) {
//		Customer customer1 = new Customer("김준일", "Gold");
//		Customer customer2 = new Customer("이동헌", "Silver");
//		Customer customer3 = new Customer("문근해", "Vip");
//		
//		customer1.showInfo();
//		customer2.showInfo();
//		customer3.showInfo();
		
		//모든 자료형은 배열로 만들 수 있다
		
		Customer[] customers = new Customer[10]; 
		//객체 10개를 담을 수 있는 배열 
		//객체 생성할 수 있는 공간만 생성한거지 객체가 생성된 것이 아님
		
		customers[0] = new Customer("김준일", "Gold");
		customers[1] = new Customer("이동헌", "Silver");
		customers[2] = new Customer("문근해", "Vip");
		
		for(int i = 0; i < customers.length; i++) {
//			customers[i].showInfo(); 
			//nullpointer 에러.
			//4~9번 인덱스는 null이므로 
			//참조할 '주소'가 없어 showinfo()라는 메소드가 존재하지 않음
			
			if(customers[i] == null) { //예외 처리
				continue;
			}
			customers[i].showInfo();
		}

	}

}
