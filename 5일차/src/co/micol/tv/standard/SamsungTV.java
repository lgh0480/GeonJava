package co.micol.tv.standard;

public class SamsungTV implements RemoteControl {

	public SamsungTV() {
		System.out.println("SamsungTV 객체생성");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV 전원 on");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 off");		
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV -- 볼륨 on");		
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV -- 볼륨 down");		
	}
	
	
}
