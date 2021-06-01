package co.yedam.score2;

public class ScoreArr2App {
						// k e m
	int[][] arr = { { 100, 90, 80 }, // 2차원 배열 0번
			{ 10, 20, 30 }, // 1번
			{ 50, 50, 50 }, // 2번
			{ 100, 90, 80 } }; // 3번

	void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	//해당 학생의 과목수 갯수
	int getSbjCnt(int no) {
		return arr[no].length;
	}
	
	// 입력한 번호의 한 학생의 총점을 계산.
	int stdTotal(int no) {
		int result = 0;
		for (int i = 0; i < arr[no].length; i++) {
			result += arr[no][i];
		}
		return result;
	}

}
