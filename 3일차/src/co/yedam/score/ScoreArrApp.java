package co.yedam.score;
//1. 클래스 설계도(UML)

//2.클래스 선언
public class ScoreArrApp {

	//int[] a; //값을 여러개 담겠다라는 뜻 
	int a =10;
	int[] arr = {90,90,50};
	
	void print( ) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			
		}
	}
	int total() {
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			result += arr[i];
					
		}
		return result;
	}
	//평균 점수 계산
	double avg() { 
		double result = 0;
		result = total() / (double)arr.length;
				 //total 나누기 배열 길이만큼.
		return result;
	}
	void printH() {
		System.out.printf("%s\n국어:%-6d\t 영어:%-6d\t 수학:%-6d\n",
						  "홍길동성적", arr[0],arr[1],arr[2]
						 );
	}
}
