package exam02;

import java.util.List;
import java.util.Scanner;

public class MemoFindDate implements MemoService {

	public MemoFindDate() {}
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute(MemoDate books) {
		//검색할 이름
		System.out.print("검색할 날짜>");
		String date = scanner.next();
		//리스트에서 검색
		List<Memo> list = books.findDate(date); 
		//결과출력
		for(Memo l : list) {
			System.out.println(l);
		}
		
		
	}

}
