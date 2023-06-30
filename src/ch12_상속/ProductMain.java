package ch12_상속;

public class ProductMain {

	public static void main(String[] args) {
		Computer computer = new Computer("삼성 컴퓨터", 1000, "데스크탑");
		//상품-> 컴퓨터 객체 생성
	
		Clothes clothes = new Clothes("상의", 2000, "L", "black");
		
		Product product = computer; //업캐스팅
//		System.out.println(product.getType()); //업캐스팅하면 computer 함수 못 씀
		
		Computer computer2 = (Computer) product; //다운캐스팅
		System.out.println(computer2.getType()); //computer 함수 쓸 수 있음
		
		
		
//		Product product = clothes; //런타임 에러. 캐스팅예외
	}

}
