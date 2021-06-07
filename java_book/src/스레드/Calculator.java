package 스레드;

public class Calculator {
	private int memory;

	public int getMemory() {
		
		return memory;
	}

	public synchronized void setMemory(int memory) { //synchronized <- 동기화 메서드 , 인스턴스 정적메서드에 어디든 붙일수 있음.
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " : "+ this.memory); //현재 쓰레드의
	}
}
