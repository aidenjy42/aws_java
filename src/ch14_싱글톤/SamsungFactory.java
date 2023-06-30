package ch14_싱글톤;

public class SamsungFactory {
	
	public Galaxy produce(String model) {
		System.out.println(Samsung.getInstance().getCompanyName() + "번 공장에서 스마트폰을 생산합니다.");
		
		int newSerialNumber = Samsung.getInstance().getAutoIncrementSerialNumber() + 1; //기존의 일련번호 가져와서 1 더함
		Samsung.getInstance().setAutoIncrementSerialNumber(newSerialNumber);
		
		return new Galaxy(newSerialNumber, model);
	}
	
	public void getCompanyName() {
		System.out.println("회사명: " + Samsung.getInstance().getCompanyName());
	}
}
