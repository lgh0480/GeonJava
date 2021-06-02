package 도형;

public class AppMain {

	public static void main(String[] args) {

		// Shape s = new Rect(4,5); //부모가 자식객체를 참조할수있다
		// 참조 하는 대상에 메소드를 호출
		// s.area();
		// s.print();

		// s = new Tri(4,5);
		// s.area();
		// s.print();
//		Shape[] s = new Shape[3];
//		s[0] = new Rect(4,5);
//		s[1] = new Circle(5);
//		s[2] = new Tri(4,5);

//		for(Shape temp: s) {
//			temp.area();
//			temp.print();
//		}
		Drawable[] s = new Drawable[3];
		s[0] = new Rect(4, 5); // 자식타입 부모타입으로 자동 형변환
		s[1] = new Circle(5);
		s[2] = new Tri(4, 5); //

		for (Drawable temp : s) {
			temp.draw(); // temp - Rect Circle ,Tir라고 생각하셈.
			if (temp instanceof Rect) { //instanceof가 타입인지 검사하는것
			((Rect) temp).area(); // 부모타입을 자식타입으로 강제형변환
			((Rect) temp).print();
		} else if (temp instanceof Circle) {
			((Circle) temp).area();
		}
			if (temp instanceof Movable) {
				((Movable) temp).move();
			}
			if(temp instanceof Shape) {
				((Shape)temp).area();
			}
		}
	}

}
