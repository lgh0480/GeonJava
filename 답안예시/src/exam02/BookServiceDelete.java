package exam02;

import java.util.List;
import java.util.Scanner;

public class BookServiceDelete implements BookService {

	@Override
	public void execute(BookList books) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하시오 > ");
		String name = scanner.next();
		
		for (Book b : books.books) {
			if(b.getName().equals(name)) {
				books.delete(b);
				break;
			}
		
			
		}

	}
}