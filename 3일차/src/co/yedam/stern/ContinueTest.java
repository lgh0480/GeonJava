package co.yedam.stern;

public class ContinueTest {

	public static void main(String[] args) {
		for(int i = 1; i <=10; i++) { //i=i+2 홀수로 계산
			if(i %2 ==1 ) { // i 2로 나눈 수가 1이라면 
				continue;   //다음 for문 실행한다. 
			}
			System.out.println(i);
			if(i == 5) { 
				break;
			}
			
		}
		
	}

}
