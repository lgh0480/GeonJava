package 상속;

public class DmbCellPhone extends CellPhone{
	int channel;
	public DmbCellPhone() {
		System.out.println("DmbCellPhone 생성자");
	} //기본생성자도 만들어줘야함.
	public DmbCellPhone(String model,String color,int channel) {
		super(model,color); //부모호출 <-안적더라도 있는거임
//		this.model = model; //super있을경우 생략가능
//		this.color = color;	//super()는 항상 제일 위로 내려가면 오류.
		this.channel = channel;
	}
	void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다. ");
		}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	void changeChannelDmb(int channel) {
		System.out.println("채널" + channel + "번으로 바꿉니다.");
	}
	@Override  //오버라이딩 - 말 그대로 재정의 //오버로딩(중복정의)
	//상속받은 메서드를 고쳐쓰는것임 ㅇㅋ?
	void powerOn() {
		//super.powerOn();
		System.out.println("Dmb 전원 ON");
	}

}

