package 배열;

import java.awt.Point;

/*
 * 객체배열 : 배열의 요소 타입이 객체인 경우
 *  */
public class 객체배열 {
	public static void main(String[] args) {
		// 변수 선언
		Score[] a; // a는 지역변수(lv)
		a = new Score[10];
		a[0] = new Score("홍길동", 100, 90, 80);
		a[1] = new Score("이건희", 90, 80, 70);
		a[2] = new Score("남순탁", 90, 85, 70);
		a[3] = new Score("이준희", 90, 95, 80);

		for (int i = 0; i < a.length; i++) { // null point error는 객채배열이 10인데 4개밖에 입력이 안되있으면 오류!
			if (a[i] != null) { // 배열 수도 확인을 해야됨.
				System.out.println(a[i].name);
			}
		}
		// 선언과 동시에 초기화
		Score[] b = { new Score("홍길동", 100, 90, 80), new Score("이건희", 90, 80, 70), new Score("남순탁", 90, 85, 70),
				new Score("이준희", 90, 95, 80) };
		
		// 이름과 총점을 출력
		
		//확장 for문
		for(Score score :b) { // in :확장for문(파이썬 in이랑 같음) :->반복하라는 연산자
			System.out.println((score.name+":" + score.total));
		}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i].name + ":" + b[i].total);

		}

		//객체배열 - (x,y)좌표 값을 낼수 있는것
		Point[] c = {new Point(10,10),
					new Point(30,10),
					new Point(30,30),
					new Point(10,30)};
		for	(Point point :c) {  //for(Point(객체배열 point(참조변수) :  c(객체배열 참조변수)
			System.out.println(point.x+", "+ point.y);
		}
			
			 //*얕은복사- arraycopy 한쪽에서 수정되면 다른쪽에서도 영향을 줌.
			 //			  얕은 복사가 주소값을 복사하기 때문에 주소로 값을 참조해서 값이 바뀌면
			 //			  해당 값을 참조 하고 있는 배열들의 값이 변경된다.
		
			 //*깊은복사- 주소값을 참조하는것이 아닌,"새로운 메모리" 공간에 값을 복사하는 것 때문에
			 //			  원본 배열이 바껴도 복사된 배열에 전혀 상관x
		
			 	
 	}
}
