package co.yedam.app;

import java.util.Scanner;

public class MemberInfo {
	String name;
	String id;
	String tel;

	double height; // 키
	double weight; // 몸무게
	double result = 0; // bmi 결과

	String s = "";
	Scanner scanner = new Scanner(System.in);

	void heightWeightInput() {
		// 코드 추가

		System.out.print("당신의 키는?:");
		height = scanner.nextDouble();
		System.out.print("당신의 몸무게는?:");
		weight = scanner.nextDouble();
		// scanner.close(); scanner
	}

	String bmi() {

		result = weight / (height / 100 * height / 100);

		if (result < 18.5) {
			System.out.println("저체중");
		} else if (result < 23) {
			System.out.println("정상");
		} else if (result < 25) {
			System.out.println("과체중");
		} else
			System.out.println("비만");

		return s; // MemberInfoMain쪽에서 s.member로 통해 출력됨
	}

	void input() {

		// 코드 작성
		System.out.print("1. 이름:");
		name = scanner.next();
		System.out.print("2. 주민번호 앞 6자리:");
		id = scanner.next();
		System.out.print("3. 전화번호:");
		tel = scanner.next();

	}

	void print() {

		System.out.println("[입력한 내용]");
		System.out.println(name);
		System.out.println(id);
		System.out.println(tel);

	}

}
