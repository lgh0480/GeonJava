package 클래스;

public class RobotTest {

	public static void main(String[] args) {
		Robot r = new Robot(2,4,"이건희"); // 하나의 기본생성자를 만들려면 기본생성자를 만들어라.?
		System.out.println(r.getArm());
		System.out.println(r.getLeg());//  
		Robot r2 = new Robot(2,2,"이준희");
		//3. 객체사용 (메서드호출)
		r2.print();
	
	}

}
