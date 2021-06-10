package com.yedam.common;

interface Run { // 인터페이스인데 함수로
	void run();
}

class RunCls implements Run {

	@Override
	public void run() {
		System.out.println("달립니다.");
	}

}

public class FunctionalEx1 {
	public static void main(String[] args) {
		RunCls cls = new RunCls();
		cls.run();

		// Run r = new Run() { //익명객체

		Run r = () -> System.out.println("빨리달립니다.");
		r.run();

	} // end of main

} // end of class
