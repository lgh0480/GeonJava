package co.yedam.stern;

public class StarApp {
	
	//삼각형 출력 -return값 필요 x
	void draw(int b) {
		for (int i=1; i<b; i++) {
			System.out.println(pad('*', i));
			}
		
		}
		//역삼각형
	void drawInvert(int cnt) {
		for (int i=cnt; i>0; i--) { //i가 9고, i가 0보다 클때까지 -1씩 감소하면서 반복한다.
			System.out.println(pad('*',i));
		}
	}
		//이등변 정삼각형
	void drawEq(int cnt) {
		for(int i=1; i<=cnt; i++) {
			System.out.print(pad('_',cnt-i));
			System.out.println(pad('*', i*2-1));
		}
	}
	//이등변 역삼각형
	void drawEqInvert(int cnt) {
		for(int i=cnt; i>0; i--) {
			System.out.print(pad(' ',cnt-i));
			System.out.println(pad('*', i*2-1));
		}
	}
		
	//*,10번 넘겨주면  "***********" 이런 메서드를 제작할꺼임.

	String pad(char s, int cnt) { //char s=모양 cnt 갯수
		String result = "";
		for(int j=0; j <cnt; j++) 	{
			result += s;
			
		}
		return result;
	}
}
