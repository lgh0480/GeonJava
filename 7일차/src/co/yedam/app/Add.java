package co.yedam.app;

public class Add {

	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;

		try {
			data1 = args[0];
			data2 = args[1];

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			System.out.println(value1 / value2);
		} catch (NumberFormatException e) {
			System.out.println("숫자 입력하셈! 제발! 좀!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자 2개 입력하셈! ㅇㅋ?");
		} catch (Exception e) { // (넘버,배열 오류)가 아니면 나머리 오류를 Exception에서 다 받아버림
			System.out.println(e.getMessage()); //Exception이 위로 올리면 다른쪽이 오류가 난다.
		}

	}

}
