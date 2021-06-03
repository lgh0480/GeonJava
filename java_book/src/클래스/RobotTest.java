package 클래스;

public class RobotTest {

	public static void change(int a) { // 기본타입
		a += 10;
	}

	public static void change(Robot robot) { // 참조변수
		robot.setArm(5);
	}

	public static void main(String[] args) {
		// 2.객체생성
//		Robot r = new Robot(2, 4); // 하나의 기본생성자를 만들려면 기본생성자를 만들어라.?
//		change(r);
//		System.out.println(r.getArm());

		int a = 1;
		change(a);
		System.out.println(a);

//		System.out.println(r.getArm());
//		System.out.println(r.getLeg());//
//		Robot r2 = new Robot(2, 2, "이준희");
//		// 3. 객체사용 (메서드호출)
//		r2.print();

	}

}
