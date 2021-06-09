package exam02;

import java.util.List;
import java.util.Scanner;

public class BookServiceFind implements BookService {

	public BookServiceFind() {}
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute(BookList books) {
		//검색할 이름
		System.out.print("검색할 이름>");
		String content = scanner.next();
		//리스트에서 검색
		List<Book> list = books.findName(content); 
		//결과출력
		for(Book l : list) {
			System.out.println(l);
		}
		
		
	}

}
