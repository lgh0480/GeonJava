package 도형;

public class Circle extends Shape implements Drawable{
	
	@Override

	public Circle(int w){
		super(w);
		//this.w = w;
	}
	
	public void area() {
		result = w * w * 3.14;
	}

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("circle draw");
	}
	
}
