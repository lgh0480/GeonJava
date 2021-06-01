package co.yedam.app.score;

public class SwitchTest {
	public static void main(String[] args) {

		float avg = 85.5f;
		char grade;

		switch ((int) avg / 10) { // 10으로 나눴을때 87.5, 89 ->8 //80 상 60 중 40하
		case 10:
		case 9:
		case 8:
			grade = '상';
			break; // '상'에서 빠져나감
		case 7:			
		case 6:
			grade = '중';
			break;	// '중'에서 빠져나감
		default:
			grade = '중';
			break;
		
		}
		System.out.println(grade);
	}
}
