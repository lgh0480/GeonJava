package 클래스;

public class StringEqual {
	public static void main(String[] args) {
		String s1 = "Hello";				//상수 영역에 
		String s2 = "Hello";				

		String s3 = new String("Hello"); //힙 영역에 할당 
		String s4 = new String("Hello"); 

		System.out.println(s1 == s2); //문자열 true
		System.out.println(s3 == s4);	//객체가 다르기 때문에 false
		System.out.println(s1 == s3);	//  " "
		
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
	
		StringBuffer sb = new StringBuffer("hello world");
		// 삽입
		sb.insert(5,"!!!");
		System.out.println(sb.toString());
		//단어 고치기
		sb.replace(0, 5
				, "Hi");
		System.out.println(sb.toString());
	}
}
