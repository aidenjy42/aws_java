package ch14_싱글톤;

import java.time.LocalDate;

public class Samsung {
	private static Samsung instance; //삼성 객체를 담을 수 있음
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000; //now()도 Static 
	//getYear() : 2023, 2023 * 1000 -> 20230000
	
	private Samsung() {
		companyName = "SAMSUNG";
	}

	//Singleton: 최초에 한번만 하나의 삼성 객체를 생성함
	//static으로 선언
	public static Samsung getInstance() { 
		if(instance == null) { 
			instance = new Samsung();
		}
		return instance; //getter
	}
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	
}
