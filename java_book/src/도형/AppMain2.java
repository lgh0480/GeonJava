package 도형;

public class AppMain2 {

	public static void main(String[] args) {
		Shape s = new Rect(4,5); //부모타입 자식객체 참조 가능 .자동형변환
		execute(s); // <-?이거 뭔데?
		
		Shape s2= new Circle(4);
		execute(s); // <-?이거 뭔데?
	}
	public static void execute(Shape s) {
		if(s instanceof Drawable) {
			((Drawable)s).draw();
		} if (s instanceof Movable) {
			((Movable)s).move();  //부모->자식 갈땐 강제형변환 
		}
		
		s.area(); //다형성 : 참조대상의 메서드호출, 메서드를 하나로 가지고 다쓰기 위해서.
	}					// ----> 실행결과가 다르게 나옴..

	}

