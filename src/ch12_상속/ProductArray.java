package ch12_상속;

public class ProductArray {

	public static void main(String[] args) {
		Product[] products = new Product[5];
		
		products[0] = new Computer("삼성컴퓨터", 1000, "데스크탑");
		products[1] = new Clothes("하의", 4000, "L", "red");
		products[2] = new Computer("맥북", 2000, "랩탑");
		products[3] = new Clothes("상의", 5000, "M", "black");
		products[4] = new Computer("그램", 3000, "랩탑");	
		
		for(int i = 0; i < products.length; i++) {
			System.out.println("모델명: " + products[i].getModel());
			System.out.println("가격: " + products[i].getPrice());
			//원래 자료형이 뭐인지 확인해서 그 타입에 맞게 다운캐스팅 후 원래 자료형에 있는 함수를 쓸 수 있음
			if(products[i] instanceof Computer) { //instanceof : 타입 비교
				System.out.println("컴퓨터임");
//				Computer c = (Computer) products[i];
				System.out.println("종류: " + ((Computer) products[i]).getType()); 
			} else if(products[i] instanceof Clothes) {
				System.out.println("옷임");
				Clothes cl = (Clothes) products[i];
				System.out.println("사이즈: " + cl.getSize());
				System.out.println("색상: " + cl.getColor());
			}
			System.out.println("========================");
			
		}
		
	}

}
