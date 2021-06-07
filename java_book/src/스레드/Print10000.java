package 스레드;

public class Print10000 implements Runnable { //실행 가능한이지 구현 자체는 아님

	@Override
	public void run() {
		for (int i = 10000; i < 10100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
