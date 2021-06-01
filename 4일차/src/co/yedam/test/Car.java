package co.yedam.test;
/*
 *  자동차 정보 담기위한 클래스
 *  Car[]  
 */

public class Car {
	// 필드 (상태 , 속성..)
	String Company;
	String model;
	String color;
	int maxSpeed;
	int speed;

	// 생성자
	/*
	 * 객체 생성시에 호출되어서 필드 초기화를 하는 특수용도의 메서드 생성자 이름은 클래스명과 동일 리턴타임 XXXXXXXXXXX(절때 없음!)
	 * 생성자 여러개 중복선언은 가능하지만 매개변수의 타입과 갯수는 달라야함
	 */
	Car(String Company, String model, String color) {
		this(Company,model,color,0,0);

	}

	public Car(String model, int speed) {
		this("", model, "",0, speed);     	//다른 생성자를 호출할땐 this()
	}
	// 기본 생성자
	Car() {
	this("현대","그렌저","검정",350,0);
	}
	@Override
	public String toString() {
		return "Car [Company=" + Company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + "]";
	}

	public Car(String company, String model, String color, int maxSpeed, int speed) {
		super();
		Company = company;
		this.model = model;
		this.color = color;
		if (maxSpeed > 100) {

		} else {
			this.maxSpeed = speed;
		}
		if (speed > 50) {
			this.speed = speed;

		} else {
			this.speed = 50;
		}
		this.maxSpeed = maxSpeed;
		this.speed = speed;
	}

}
