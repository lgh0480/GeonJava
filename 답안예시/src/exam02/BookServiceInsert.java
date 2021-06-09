package exam02;

import java.util.Scanner;

public class BookServiceInsert  implements BookService{
	Scanner scanner = new Scanner(System.in);
	@Override
	public void execute(BookList books) {
		System.out.print("ISBN>");
		String isbn = scanner.next();
		System.out.print("NAME>");
		String name = scanner.next();
		System.out.print("CONTENT>");
		String content = scanner.next();
		
		for (Book i : books.books) {
			if(i.getIsbn().equals(isbn)) { //일치
				System.out.println("이미 등록된 ISBN입니다.");
				return; //만약에 똑같은게 있으면 밑에 실행안하고 나가버림.
			}
		}
		books.insert(new Book(isbn, name, content));
	}

}
