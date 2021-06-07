package 연산자;
/*
 *  ^ : xor - 서로 다르면 1 (암호화)
 *	& : and - 마스크
 *  | : or or연산자
 */

public class 비트연산 {
	public static void main(String[] args) {
		// 암호와/복호화
		int a = 04474;
		int key = 01111;
		System.out.println("원문 : " + a);
		int b = a ^ key;
		System.out.println("암호화 : " + b);

		int c = b ^ key;
		System.out.println("복호화 :" + c);

		int d = 0b10101111; // 2진수 표현
		int e = 0b00000100; // 마스크를 씌운다는 의미
		System.out.println(Integer.toBinaryString(d & e));

	}
}
