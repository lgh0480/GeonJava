package exam02;

import java.util.Scanner;

public class BookServiceFindIsbn implements BookService {
	
	Scanner scanner = new Scanner(System.in);
	@Override
	public void execute(BookList books) {
		//isbn 입력
		String isbn = scanner.next();
		//리스트에서 출력
		Book book =books.findIsbn(isbn);
		//결과출력
		System.out.println("검색결과"+book);
	}
	
	
}
