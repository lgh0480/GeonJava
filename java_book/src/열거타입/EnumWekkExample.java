package 열거타입;

import java.util.Scanner;


public class EnumWekkExample {

	public static void main(String[] args) {

		//요일명
		//String week = "SUA";
		
		
		//2.배열
		//String[] week = {"MON" , "TUE" , "WED", "THU", "FRI", "SAT", "SUN"};
		
		//String today = week[6];
		
		//3eum
		Week today = Week.SUN;
		Scanner scanner = new Scanner(System.in);
		MENU menu = null;
		
		do {
			MENU.print();
			int menuno = scanner.nextInt();
			menu = MENU.getMenu(menuno);
//			switch(menuno) {
//			case 1 : menu = MENU.등록; break;
//			case 2 : menu = MENU.수정; break;
//			case 3 : menu = MENU.삭제; break;
//			case 0 : menu = MENU.종료; break;
//		}
			switch(menu) {
			case 등록: System.out.println("등록"); break;
			case 수정: System.out.println("수정"); break;
			case 삭제: System.out.println("삭제"); break;
			case 조회: System.out.println("조회"); break;			
			}
		}while(menu != MENU.종료);
		System.out.println("종료");
		
	}	
}
