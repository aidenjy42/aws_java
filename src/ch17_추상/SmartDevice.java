package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
public abstract class SmartDevice {  //추상 메소드
	private String deviceName;
	private double displaySize;
	
	public abstract void connectedWiFi(); //추상 메소드. 이 클래스를 상속받은 클래스는 추상 메소드를 무조건 오버라이딩해야 함-> 필수 작업에 사용

	// SmartDevice 클래스는 추상화(공통적인 부분을 모아두기 위함)

}
