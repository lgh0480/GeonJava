package co.micol.tv.standard;
	//명령행 인수
public class MainApp {

	public static void main(String[] args) {
		//SamsungTV tv = new SamsungTV();
		//LgTv tv = new LgTV();
		//1.부모타입의 참조변수가 자식 객체를 참조 할수 있다는것!
		//2.다형성-(참조하는 대상의 메서드가 호출. (여러가지 형태로 실행이된다)
		//		   코드는 같아도 참조대상에 따라서 실행결과 다르게나옴.
		RemoteControl tv = (RemoteControl)BeanFactory.getBean(args[0]);
		
		
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
