package co.yedam.member;

import java.util.Scanner;

public class MemberServiceExample {
	
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		MemberService member = new MemberService();
			boolean run = true;
			Scanner scanner = new Scanner(System.in);
			int selectNo = 0;
			while(run) {
				System.out.println("1.등록 2.조회 3.번호로조회 4.로그인 5.id로조회");
				System.out.println("선택>");
				selectNo = scanner.nextInt();
				if(selectNo == 1 ) {
					member.insert();
				
				}else if(selectNo ==2) {
					member.printList();
				}else if(selectNo == 3) {
					member.search();
				
				}else if(selectNo == 4) {
					member.login("id","password");
				}else if(selectNo == 5) {
					break;
				}
			}
			System.out.println("프로그램 종료");
		
		}
			
	}