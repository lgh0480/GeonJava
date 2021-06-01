package co.yedam.app;

import java.util.Scanner;

/*
 * 형변환에 대해서 테스트를 진행 
 * 형변환 : 캐스트연산자 ( 타입 )
 * 정수형: byte < short < int  <long
 * 실수형: 			    float < double
 * 
 * 스트링 ----> byte 	Byte.parseByte(변수) parse(변환한다)
 * 			   short	Short.parseShort()
 * 				int		Integer.parseInt()
 * 				float	float.parse
 * 				double	double.parse()
 * 				char
 * 				boolean	
 *		<-----	
 *String.valueOf(basicType) 
 */

public class CastTest {   

	public static void main(String[] args) {
		//자동형 변환
		int a= 10;
		long b = a;
		
		//강제형 변환
		a =(int)b; // 큰값을 작을 값을 넣을때에는 ()를 넣어줘야한다.
		System.out.println(a);
		//char(문자) <-> int(코드의 값을 보여주는것)
		char c = 'Z';
		System.out.println((int)c);
		int d = 97;
		System.out.println((char)d);
		
		// 실수(double) - > 정수(int)
		double e = 10.5;
		int f = (int)e;
		long g = (long)e;//이렇게는 가능	//int f = (long)e; :큰값은 작은 값에는 못넣음 
		System.out.println(e);

		double h = 5+ 10.5;
		String i = "hi" + 5;
		System.out.println(h);
		System.out.println(i);
		
		System.out.println(5/(double)2); //  정수끼리 나누면 정수로 계산 됨 ex)2 실수로 계산하면 2.5로 나옴
		
		//정수 끼리의 연산결과는 정수
		double j= 5 /(double)2;
		System.out.println(j);
		
		// 수식내에서 자동으로 형변환
		double g1 = 5+ 10.5;
		String h1 = "hi" + 5;
		System.out.println(h);
		System.out.println("hi"+5+10);
		System.out.println(5+ 10 +"hi"); // 결과는 15hi 
		
		// 스트링 -> int
		String s1 ="123";
		int j1 =Integer.parseInt(s1);
		System.out.println(j1);
		// int -> 스트링
		String s2 = String.valueOf(10.5);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력:");
		String greet = scanner.next(); //
		
		System.out.println(greet);
		
		
		
	}

}
