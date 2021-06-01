package co.yedam.test;

public class CalcExample {

	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.turnOn();
		
		calc.sum(10, 20);
		calc.sum(20.3, 30.3);
		//int r = calc.sum(100, 200); // 리턴이 있으면 결과를 받으면 됨
		//System.out.println(r);
		//System.out.println(calc.sum3(1,2,3));
		//System.out.println(calc.sum3(1,2,3,4));
	}

}
