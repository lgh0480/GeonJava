package co.yedam.fly;

public abstract class Animal {
//추상클래스는 
	public Animal() {}
	public void run() {
	 System.out.println("상위객체가 가지고 있는 행동");	
	}
	public abstract void eat();
	
	public void sleep() {
		
	}
}


