package co.yedam.test;

public class CarExample {

	public static void main(String[] args) {
		// 객체 생성(인스턴스)
		Car myCar = new Car();
		myCar.Company = "르노";
		myCar.maxSpeed = 350;
		myCar.color = "Rot";

		// 생성자
		Car youCar = new Car("르노", "SM6", "흰색");
		System.out.println(youCar);

		// 필드값 읽기
		System.out.println("제작회사:" + myCar.Company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔:" + myCar.color);
		System.out.println("최고속도:" + myCar.maxSpeed + "Km");
		System.out.println("현재속도:" + myCar.speed + "Km");

		// 필드값 변경
		myCar.speed = 130;
		System.out.println("수정된 속도" + myCar.speed + "Km");
		
		//"코나,100"
		Car miniCar = new Car("코나",0);
		System.out.println(miniCar.toString());
	}
	
		
}
