package 연산자;

public class 관계연산 {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		// 첫번째 관계식이 false면 뒤에것이 뭐가되든 2번째 관계식은 계산안함.
		if (y++ > 10 && x++ > 10) { 
			System.out.println("A");
		} else {
			System.out.println("B");

		}
		System.out.println(x);
		System.out.println(y);
	
		//쉬프트연산
		int f = 8;
		System.out.println(f >> 1);  // 1000 -> 0100  나누기 2 한거랑 같음 속도가 더 빠름.
		System.out.println(f << 1);  // 1000 -> 10000	 곱하기 2 한거랑 같음  "   ".
	}

}
