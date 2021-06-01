package co.yedam.stern;

public class StarTreeApp {

	void draw(int a) {
		for (int i = 1; i < a; i++) {
			System.out.println(pad('*', a));
		}

	}

	void drawEq(int cnt) {
		for (int i = 1; i < cnt; i++) {
			System.out.print(pad('-', cnt - i + 4));
			System.out.println(pad('*', i * 2 - 1));
		}
	}

	void drawEq(int b, int cnt) {
		for (; b < cnt; b++) {
			if (cnt > 6)
				System.out.print(pad('-', cnt - b));
			else
				System.out.print(pad('-', cnt - b + 2));
			System.out.println(pad('*', b * 2 - 1));
		}

	}
	void drawRect(int cnt) {
		for(int i=1; i< cnt; i++) {
			System.out.print(pad('-',cnt+1));
			System.out.println(pad('*',cnt));
		}
	}
	String pad(char s, int cnt) {
		String result = "";
		for (int j = 0; j < cnt; j++) {
			result += s;
		}
		return result;
	}

}
