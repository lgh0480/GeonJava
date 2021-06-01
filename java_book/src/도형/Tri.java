package 도형;

public class Tri extends Shape implements Drawable {

	private int h;

	public Tri(int h, int w) {
		this.h = h;
		this.w = w;

	}

	public void area() {
		result = w * h / 2;
	}

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("tri draw");
	}
}