package co.yedam.app;

import java.util.Scanner;

/*
 * 계산게임 기능
 * 사칙연산, 진수 변환, 문자값 검사
 *
 */
public class CalcGame {
								// 정수값 두 수의 합을 구하는 메서드(함수)
	double a;
	double b;
	
	int sum(int cnt) {
		int result = 0;
		
		return result;
		
	}
	
	
	
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번쨰 수 입력:");
		String s1 = scanner.next();
		
		System.out.print("두번째 수 " + "입력:");
		String s2= scanner.next();
		
		 a = Double.parseDouble(s1);
		 b = Double.parseDouble(s2);
		// add(), share, div,rest
		
	}
	
	double add() { // 생성자
		return a + b;

	}

	// 두수의 몫을 계산 5/2 2
	double share() {
		return a / b;

	}

	double div() {// 두 수의 나눗셈 5/2 2.5
		return  a /  b;
	}

	double rest() { // 두 수의 나머지 연산
		return  a %  b;
	}

}
