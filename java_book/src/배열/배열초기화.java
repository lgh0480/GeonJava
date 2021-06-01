package 배열;

/*
 * 배열 : 크기가 고정
 * 순차적으로 데이터를 저장하고 읽는 용도로 쓰임
 * 추가/삭제 번거로움.
 * 
 */
public class 배열초기화 {
	public static void main(String[] args) {

		// 1차원배열
		// 배열선언
		int[] a; // 객체 -> new 힙 메모리 할당을 해야지만 사용할수 있음.
		a = new int[10]; // 배열 선언
		// 배열값 초기화
		a[0] = 10; // 0부터 9까지
		a[1] = 20; // 아무것도 설정 안하면 ***초기값은 0***
		a[2] = 30; // 배열은 항상 for랑 같이 사용함.
		a[3] = 40;
		a[4] = 50;
		a[9] = 100;
		// 배열출력
		// 삭제 (인덱스 다음부터 앞으로 한칸 이.동.시.키.는.것)
		for (int i = 2; i < a.length; i++) {
			a[i - 1] = a[i];
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		//배열 선언과 초기화를 한꺼번에
		int[] b= {100,200,300};  //new int[3]{100,200,300} 이랑 똑같음.
		System.out.println("배열크기: " +b.length);
		
		
		
	}

}
