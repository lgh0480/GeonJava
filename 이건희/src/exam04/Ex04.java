package exam04;

public class Ex04 {

	public static void main(String[] args) {

		String[] arr = { "010102-2", "991012-1", "960304-1", "881012-2", "040403-1" };

		int men = 0;
		int women = 0;
		int zehn = 0, zwanzig = 0, dreizig = 0, vierzig = 0;

		for (String a : arr) {
			if (a.substring(a.length() - 1).equals("1")) {
				men++;
			} else if (a.substring(a.length() - 1).equals("2")) {
				women++;
			}
		} // end of for

		for (String a : arr) {
			int x = Integer.parseInt(a.substring(0, 2));
			int y = 21 - x;
			if (y < 0) {
				y = 21 + (100 - x);
			}
			if (10 <= y && y < 20) {
				zehn++;
			} else if (y < 30) {
				zwanzig++;
			} else if (y < 40) {
				dreizig++;
			} else {
				vierzig++;
			}
		}
		System.out.println("남" +men + "여 " + women );
		System.out.println("10대 " + zehn + "명");
		System.out.println("20대 "+ zwanzig + "명");
		System.out.println("30대 "+ dreizig + "명");
		System.out.println("40대 "+ vierzig + "명");
	}// end of main

}// end of class
