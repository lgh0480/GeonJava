package 클래스;

public class CalcStaticTest {

	public static void main(String[] args) {
		
		//정적맴버는 클래스이름으로 접근 가능하다는거~ 아시겠나욘?!
		//CalcStatic.PI = 3.141592; 
			System.out.println(CalcStatic.PI); //객체 생성 안하고도 가능하다는거 하지만 권장하진 않다는거~
			System.out.println(CalcStatic.add(10, 20));//static이면 클래스 이름으로 바로 생성 가능함.
			
		CalcStatic c1 = new CalcStatic();
		CalcStatic c2 = new CalcStatic();
	
		System.out.println(c1);
		System.out.println(c2);
	}

}

