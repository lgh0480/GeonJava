package 열거타입;

public enum MENU {
	등록(1), 수정(2), 삭제(3), 조회(4), 종료(0); //열거형 상수 : 상수값들을 모아놓은 배열같은거 처럼사용.

	private int value;
	
	public int getValue() {
		return value;
	}
	
	private MENU(int value) {
		this.value = value;
	}
	
	public static void print() {
		MENU[] arr = MENU.values(); // enum에 있는 모든 값들을 받아옴
		for(MENU m : arr) {
			System.out.println(m.value+" : "+ m);
			
		}
	}
	public static MENU getMenu(int v) {
		MENU[] arr = MENU.values();
		for(MENU m : arr) {
			if(m.getValue() == v) {
				return m;
			}
		}
		return null;
	}
}
