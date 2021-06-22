package co.yedam.back;

import java.util.Scanner;

public class Back_2839 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N == 4 || N == 7) {
			System.out.println(-1);
		} else if (N % 5 == 0) {
			System.out.println(N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) { // n이 5의 배수 +1 또는 3이라면<5로나눈 나머지가 1,3이면>
			System.out.println((N / 5) + 1); // n을 5로 나눈 몫 +1 (설탕 봉지의 최소 갯수)
		} else if (N % 5 == 2 || N % 5 == 4) { // 5로 나눈 나머지가 2 또는 4라면
			System.out.println((N / 5) + 2); // n을 5로 나눈 몫 +2 
		}

		

	} // end of Main

}// end of class
