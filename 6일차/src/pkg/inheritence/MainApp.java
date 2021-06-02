package pkg.inheritence;

public class MainApp {
	public static void main(String[] args) {
	A a = new D();	//자동형변환
	int temp = ((D)a).sd; //강제형변환
			
	//A o = new A();
	//temp =  ((D)o).sd; //오류
	//B b = new D();
	//X x = new D();
	System.out.println(a instanceof A); //a가 D 맞냐?
	System.out.println(a instanceof B);
	System.out.println(a instanceof D);
	B b = new B();
	b = new D();
	//b = new C();
 	System.out.println(a instanceof A);
 	System.out.println(a instanceof B);
 	System.out.println(a instanceof D);
 	System.out.println(a instanceof X);
	}
}
