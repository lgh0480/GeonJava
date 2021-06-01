package 상속;

public class CellPhone {
	//필드
	String model;
	String color;
	public CellPhone() {
		System.out.println("CellPhone 기본생성자");
	}
		
	//생성자
	public CellPhone(String model, String color){	
		this.model = model;
		this.color = color;
		}
	void powerOn() {
		System.out.println("전원을 켭니다. ");
	}
	void powerOff() {
		System.out.println("전원을 끕니다. ");
	}
	void bell() {
		System.out.println("벨이 울립니다. ");
	}
}
