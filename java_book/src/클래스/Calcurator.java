package 클래스;

public class Calcurator {
	
	//싱글톤 -메모리 관리를 위해서 
	private static Calcurator instance = new Calcurator();
	public static Calcurator getInstance() {
		return instance;
	}
	private Calcurator() {} //객체를 생성 못하도록 막아버리는것 c1 = new Calcurator();<생성안됨
	public int add(int a, int b) {
		return a + b;
	}
	
}
