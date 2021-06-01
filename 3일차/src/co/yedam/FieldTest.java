package co.yedam;

public class FieldTest {
	int a = 10;
	int b = 10;
	
	public void method1() {
		//a++; //필드 a를 가르킴(10을 가져옴)
			int a = 0;
			a++;
		
	}
	public static void main(String[] args) {
		FieldTest fieldTest = new FieldTest();
		fieldTest.method1();
		System.out.println(fieldTest.a);
	}
}
