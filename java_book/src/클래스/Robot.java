package 클래스;
//1.클래스 선언
public class Robot {
	// 필드
	// private : 접근제어자(클래스 내부에서만 접근 가능)
	private int arm;
	private int leg;
	private String name;
	//필드값을 읽고 싶으면 getter setter 입력.
	// setter : 필드값을 변경하는게 목적
	public void setArm(int arm) { // 필드명은 set<대문자>xx() {}
		this.arm = arm;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public void setName(String name) {
		this.name =name;
	}
	// getter : 필드값을 조회하는게 목적
	public int getArm() {
		return this.arm;
	}

	public int getLeg() {
		return this.leg;
	}
	public String setName() {
		return this.name;
	}
	// 생성자 오버로딩
	public Robot(int arm, int leg, String name) {
		this.arm = arm;
		this.leg = leg;
		this.name = name;
	}
	// 기본생성자
	// public Robot(){} //컴파일러가 기본으로 생성해주는 {생.성.자}
	public Robot(int arm, int leg
			) {
		this.arm = arm; // this 자기 자신을 가르키는 참조 변수.
		this.leg = leg;
		

	}
	//일반메서드
	
	public void print() { // public으로 접근 제어자를 설정해야됩니다.
		System.out.printf("arm:%d leg:%d name:%s",arm,leg,name);
	}
}
