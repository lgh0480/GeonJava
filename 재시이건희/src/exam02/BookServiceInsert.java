package exam02;

import java.util.Scanner;

public class BookServiceInsert  implements MemoService{
	Scanner scanner = new Scanner(System.in);
	@Override
	public void execute(MemoDate memos) {
		System.out.print("No를 입력하세요 >");
		int no = scanner.nextInt();
		System.out.print("DATE 입력하세요 >");
		String date = scanner.next();
		System.out.println("TITLE을 입력하세요 >");
		String title = scanner.next();
		System.out.print("CONTENT을 입력하세요 >");
		String content = scanner.next();
		
		for (Memo i : memos.memos) {
			if(i.getNo()== no) { //일치
				System.out.println("이미 등록된 ISBN입니다.");
				return; //만약에 똑같은게 있으면 밑에 실행안하고 나가버림.
			}
		}
		memos.insert(new Memo(no, date, title,content));
	}

}
