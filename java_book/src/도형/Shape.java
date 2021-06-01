package 도형;

public abstract class Shape {
	protected int w;
	protected double result;

	public Shape() {}

	public Shape(int w) {
		this.w = w;
		
		 
	}

	public void print() {
		System.out.println("면적= "+ result);
	
	}

	public abstract void area(); //추메는 몸이 없음.

	
}
