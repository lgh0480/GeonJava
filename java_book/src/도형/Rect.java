package 도형;

public class Rect extends Shape implements Drawable, Movable {

	private int h;

	public Rect(int h, int w) {
		this.h = h;
		this.w = w;

	}

	public void area() {
		result = w * h;
	}

	// 무브 메서드 오버라이딩
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("moving");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rect draw");
	}
}
