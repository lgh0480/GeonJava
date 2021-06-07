package 스레드;

/**
 * Thread상속
 *
 *
 */
public class ThreadTest {
	public static void main(String[] args) {

		Print100 print100 = new Print100();
		print100.setPriority(Thread.MAX_PRIORITY);
		System.out.println(print100.getName());
		print100.start();

		Thread thread1 = new Thread(new Print1000());
		thread1.start();

		Thread thread2 = new Thread(new Print10000());
		thread2.start();
		// 익명객체
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 2000; i < 2100; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}); // 부모의 이름 적고 객체생성 클래스 까지 같이생성
		thread3.start();

		// 람다식 : 익명객체 -> 반드시 구현클래스 구현메서드가 1개일때 람다식 쌉가능 ㅋ
		Thread thread4 = new Thread(() -> {
			for (int i = 3000; i < 3100; i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread4.start();
		
		
		
	}

}
