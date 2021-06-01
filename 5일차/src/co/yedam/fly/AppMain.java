package co.yedam.fly;

public class AppMain {

	public static void main(String[] args) {
		Human human = new Human();
		human.sleep();
		human.eat();
		
		Bird bird = new Bird();
		bird.layEggs();
		bird.eat();
		bird.fly();
		
		SuperMan superMan = new SuperMan();
		
	}

}
