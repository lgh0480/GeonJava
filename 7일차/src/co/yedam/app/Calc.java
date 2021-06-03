package co.yedam.app;

public class Calc {

	public static int add(int a, int b) {
		return a + b;
	}

	public static int div(int a, int b) throws Exception { //예외
		int c = 0;
//		try {
//			c= a / b;
//			return c;
//		}catch(Exception e) {
		c= a/b;
		return c;
		}
		
			
		
	}

}
