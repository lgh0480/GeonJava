package exam02;

import java.util.List;
import java.util.Scanner;

public class BookServiceDelete implements MemoService {

	@Override
	public void execute(MemoDate books) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하시오 > ");
		String name = scanner.next();
		
		for (Memo b : books.books) {
			if(b.getName().equals(name)) {
				books.delete(b);
				break;
			}
		
			
		}

	}
}