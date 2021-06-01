package co.yedam.test;

//클래스: 필드+ 메서드 +생성자

public class Calc {
	// on 1. 리턴 값도 없고 매개변수도 없음
	void turnOn() {
		System.out.println("계산기 ON");
	}

	// 덧셈(sum) 2. 리턴 없고 매개변수는 있음
//	void sum(int a, int b) {
//		System.out.println("int메서드");
//		System.out.println("두수의합: " + (a + b));
//	}
	int sum2(int a, int b) {
		return a+b;
	}
	// 3. 리턴도 있고 매개변수도 있음.
	void sum(double a, double b) {
		System.out.println("dounle메서드");
		System.out.println("두수의 합 : "+(a+b));
		
	}

	// 4. 가변인수
	int sum3(int... arr) {
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
			
		}
		return result;
	}

}
