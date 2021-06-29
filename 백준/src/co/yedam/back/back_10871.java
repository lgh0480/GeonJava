package co.yedam.back;

import java.util.Scanner;

public class back_10871 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정수 n개 값 입력
		int x = sc.nextInt(); // 정할 x의 값을 입력
		int arr[] = new int[n]; //new 연산자로 배열 생성
		
		for(int i=0; i<n ;i++) { // 
			arr[i] = sc.nextInt();
			//System.out.println(arr[i]);
		}
		for(int i=0; i< n ; i++) {
			if(arr[i] < x) {
				System.out.println(arr[i]+ " ");
			}
		}
	}

}
