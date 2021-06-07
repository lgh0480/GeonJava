package co.yedam.back;
/*
 * InputStreamReader의 특징
 * 1.바이트 단위 데이터문자(char) 단위 데이터로 처리할수 있도록 변환해줌
 * 2.char 배열로 데이터를 받을수있다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back10430 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
												
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " "); //

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println((a + b) % c);
		System.out.println((a % c) + (b % c) % c);
		System.out.println((a * b) % c);
		System.out.println((a % c) * (b % c) % c);

	}

}
