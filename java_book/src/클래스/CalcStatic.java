package 클래스;

public class CalcStatic {
	// final :(상수) 변경불가 상수의 의미로 대문자로 지정
	// static : 모든 객체가 공유하는 필드 
	final static double PI = 3.14; // PI=상수(대문자)

	@Override
	public String toString() {
		return "CalcStatic [pi=" + PI + "]";
	}
	public static int add(int inNum1, int inNum2) { //객체 생성하지않고 바로 호출가능.
		return inNum1 + inNum2;
		
	}


}
