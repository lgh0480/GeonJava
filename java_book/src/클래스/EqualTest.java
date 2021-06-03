package 클래스;

public class EqualTest {

	public static void main(String[] args) {
		Robot r1 = new Robot(2,4);
		Robot r2 = new Robot(1,4);
		
		//Robot r2 = r1; // 이럴땐 true
	
		System.out.println(r1 == r2); // 주소 비교를 하기 때문에 false
		System.out.println(r1.equals(r2));
		System.out.println(r1);
		
		String a = new String("hello");
		String b = new String("hello");
		System.out.println(a.equals(b)); //equals는 

	}

}
