package co.yedam.back;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Back_1931 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] time = new int[N][2];

		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt(); // 시작시간
			time[i][1] = sc.nextInt(); // 종료시간
			System.out.println("0,0:" + time[i][0]);
			System.out.println("0,1:" + time[i][1]);
		}

		// 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
		Arrays.sort(time, new Comparator<int[]>() {

			// 종료시간이 같을 경우 시작 시작이 빠른순으로 정렬
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}

		});
		
		int count = 0;
		int endtime = 0;
		
		for (int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
			if(endtime <= time[i][0]) { 
				endtime = time[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
