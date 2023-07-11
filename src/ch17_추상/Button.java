package ch17_추상;

public interface Button {
	public int buttonCount = 4; //이탤릭체 + 볼드체 : 스태틱 상수
	
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}
