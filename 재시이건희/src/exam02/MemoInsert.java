package exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoInsert  implements MemoService{
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute(MemoDate m) {
		
		//System.out.print("No를 입력하세요 >");
		int no = m.memos.size()+1;
		System.out.print("DATE 입력하세요 >");
		String date = scanner.next();
		System.out.println("TITLE을 입력하세요 >");
		String title = scanner.next();
		System.out.print("CONTENT을 입력하세요 >");
		String content = scanner.next();
		
		for (Memo i : m.memos) {
			if(i.getNo()== no) { //일치
				System.out.println("이미 등록된 번호입니다.");
				return; //만약에 똑같은게 있으면 밑에 실행안하고 나가버림.
			}
		}
		m.insert(new Memo(no, date, title,content));
	}

}
