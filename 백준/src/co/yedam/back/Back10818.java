package co.yedam.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back10818 {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//BufferdReader은 Enter만 경계로 인식하고 받은 데이터사 String으로 고정되기 때문에 
	//입력받은 데이터를 가공하는 작업이 필요한 경우가 많다. 
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int index = 0;
		int[] arr = new int[N]; // new 연산자로 배열 객체생성 
		while(st.hasMoreTokens()) { //StringTokenizer 클래스 객체에서 다음에 읽어 들일 token이 있으면 true, 없으면 false를 return한다.
			arr[index] = Integer.parseInt(st.nextToken()); // nextToken StringTokenizer 클래스 객체에서 다음 토큰을 읽어 들인다.
			index++;
			
			
		}
		Arrays.sort(arr);
		System.out.print(arr[0]+" " + arr[N-1]);
	
	}

}
