package co.yedam.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_10871andere {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // readLine: 한 줄의 문자열을 읽음

		int N = Integer.parseInt(st.nextToken()); // 문자열을 숫자로 변환 시켜
		int X = Integer.parseInt(st.nextToken()); // 존재하는 토큰 리턴

		// String과 문자열을 더할때 새로운 객체를 생성하는 것이 아니라 기존 데이터를 더하는 방식 사용
		// 속도도 빠르고 상대적으로 부하가 적음
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " "); // ?? 이건 궁금하니깐 내일 물어보자

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken()); //다음 토큰을 반환해서 int value에 대입
			System.out.println("궁금하니깐?!"+value);
			
			if (value < X)
				sb.append(value).append(' ');
		}
		System.out.println(sb);
	}

}
