package co.yedam.app.gugudan;

public class GugudanApp {

	// 입력 받은 단 만 출력
	public void printDan(int dan) {
		// 2*1=2 ~ 2*9=18
		for (int i = 1; i <= 9; i++) { //i는 1이고 i는 9보다 같거나 작을때까지 i씩 증가시킨다.
			System.out.println(dan + "*" + i + " = " + (dan * i));

		}
		System.out.println();
	}

	public void printRange(int s, int e) {
		for(int i = s; i <=e; i++) { //i는 s이고 i는 e보다 같거나 작을때까지 i씩 증가시킨다.
			for(int j=1; j<=9; j++) {
				System.out.println(i+" * "+ j +" = "+ (i*j) );
			}
		}
		// s단부터 e단까지 출력

	}

	public void printAll() { // 9단까지 모두 출력
		for (int i = 1; i < 10; i++) { //i가 1이고 i가 10보다 작을때까지 i를 증가시킨다.
			
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " x " + j + " = " + i * j);
			}
		}
	}

	public void printAllReverse() {
		for (int i = 9; i > 0; i--) { //i가 9고, i가 0보다 클때까지 -1씩 감소하면서 반복한다.
			for (int j = 9; j > 0; j--) {
				System.out.println(i + " x " + j + " = " + i * j);
			}

			// 9단부터 거꾸로 출력
		}
	}
}