package co.yedam.back;

import java.util.Scanner;

public class Back_1924 {
	public static void main(String[] args) {

		 Scanner sc = new Scanner(System.in);
	        int month = sc.nextInt();
	        int day = sc.nextInt();
	        sc.close();
	         
	        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        String[] dayOfTheWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	         
	        int totalDays = day;
	        System.out.println(totalDays);
	        for (int i = 0; i < month - 1; i++) {
	            totalDays += daysInMonth[i];
	           
	        }
	        System.out.println(dayOfTheWeeks[totalDays % 7]);
//		Scanner sc = new Scanner(System.in);
//		int month = sc.nextInt(); //월
//		int day = sc.nextInt();   //일
//
//		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//		String[] tags = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
//		
//		int days = day;
//		for(int i=0; i<month -1; i++) {
//			days += months[i];  //1월 1일부터 입력받은 날짜 사이의 일수를 모두 더함
//			System.out.println("i의 값 " + months[i]);
//			System.out.println("days의 값"+days);
//			System.out.println(days += months[i]);
//		}
//		System.out.println(tags[days % 7]);
//	
//		sc.close();
	}
	
}// end of class
