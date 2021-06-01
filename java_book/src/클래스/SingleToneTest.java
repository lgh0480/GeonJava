package 클래스;

public class SingleToneTest {

	public static void main(String[] args) {
		Calcurator c1 =  Calcurator.getInstance();
		c1.add(10, 20);
		 
		Calcurator c2 = Calcurator.getInstance();
		c2.add(10, 20);
		
		System.out.println(c1 == c2);
		//참조하는것이 다르므로 false;
		//Single 톤은 같은것을 참조하기때문에 결과값은 true;
	
	}

}
