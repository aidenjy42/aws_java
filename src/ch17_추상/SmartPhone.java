package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@ToString(callSuper = true) //부모 정보도 toString으로 출력
public class SmartPhone extends SmartDevice implements Button {
	
	private String phoneNumber; //lombok은 부모의 생성자를 생성해주지 않음-> 직접 작성

	public SmartPhone(String deviceName, double deviceSize, String phoneNumber) {
		super(deviceName, deviceSize);
		this.phoneNumber = phoneNumber;
	}

	@Override //smartDevice 클래스를 상속받았기 때문에 sD클래스 메소드를 오버라이딩 가능
	public void connectedWiFi() {
		System.out.println("스마트폰의 와이파이를 연결합니다.");
	}

	//in
	@Override
	public void powerOn() {
		
	}

	@Override
	public void powerOff() {
		
	}

	@Override
	public void volumeUp() {
		
	}

	@Override
	public void volumeDown() {
		
	}
}
