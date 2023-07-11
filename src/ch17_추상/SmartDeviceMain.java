package ch17_추상;

public class SmartDeviceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartPhone phone = new SmartPhone("아이폰", 6.1, "010-9988-1916");
		Pad pad = new Pad("아이패드3", 10.1, false);
//		SmartDevice device = new SmartDevice(null, 0); //추상 클래스는 객체 생성이 안됨 상속되어 구체화된 클래스만 객체생성 가능
		
		System.out.println(phone);
		System.out.println(pad);
		
		phone.connectedWiFi();
		pad.connectedWiFi();
		
	}

}
