package co.yedam.fly;

//다중상속 안된다 짜슥아! ㅏㅡㅑ!
public class SuperMan extends Human implements Flyer{

	public SuperMan() {}
	@Override
	public void takeOff() {}
	@Override
	public void fly() {}
	@Override
	public void land() {}
	
}
