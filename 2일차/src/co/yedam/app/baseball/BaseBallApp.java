package co.yedam.app.baseball;

import java.util.Scanner;
import java.util.Random;
/*
 * 임의의 수 3개
 * 사용자 수 입력
 * 스트라이크, 볼 ,카운터
 */

public class BaseBallApp {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	int s; // 스트라이크
	int b; // 볼
	int[] com = new int[3]; // 컴퓨터
	int[] user = new int[3]; // 유저

	void makeRnd() {
		// c1 =___; 난수 발생 만들기

		for (int i = 0; i < com.length; i++) {
			com[i] = random.nextInt(9) + 1;

			for (int j = 0; j < i; j++) { // 중복 제거
				if (com[i] == com[j]) {
					i--;

				}
			}

			System.out.println("개발자 확인용:" + com[i]);
		}

	}

	void input() {
		for (int i = 0; i < user.length; i++) {
			System.out.print((i + 1 + "번째 수 :"));
			user[i] = sc.nextInt();

			while (user[i] >= 10 || user[i] <= 0) {
				System.out.println("error! 1~9까지 수를 입력하시오");
				System.out.print(i + 1 + "번째 수 : ");
				user[i] = sc.nextInt();
			}
		}

	}

	void count() {
		// s ,b 카운터
		for (int i = 0; i < com.length; i++) {
			if (com[i] == user[i]) {
				s += 1;
			} else {
				b += 1;
			}

		}

	}

	void start() { //순서 확인을 잘해야함 안그러면 코드 다 꼬여서 다 만든것도 제대로 안됨 ㅇㅋ?
		makeRnd();
		while (true) {
			
			input();
			count();
			if (s == 0 && b == 0) {
				System.out.println("아웃");
			} else if (s == 3) {
				System.out.println("스트라이크!!");
				System.exit(0);
			} else {
				System.out.println("\n" + s + "스트라이크" + b + "볼\n");
				s = b = 0;
			}
			if (s == 3) {
				break;
			}
		}
		

	}
}
