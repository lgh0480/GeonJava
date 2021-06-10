package exam02;

import java.util.Scanner;

public class MemoApp2 {
	public static void main(String[] args) {
		MemoDate memos = new MemoDate();
		memos.insert(new Memo(1,"20210102","자바", "자바를 배우자"));
		memos.insert(new Memo(2,"20210102","모임" ,"1시에 모임"));
		MemoService[] service = {null, new MemoInsert(),
									   new MemoFindDate(), 
									   //new BookServiceFindIsbn(),
									   //new BookServiceFindAll(),
																	};
		int menu =0;	
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.등록   2.날짜로조회  0.종료");
			System.out.print("입력>");
			menu = scanner.nextInt();
			if(menu==0) break;
			service[menu].execute(memos);
		}while(true);
	}

}
