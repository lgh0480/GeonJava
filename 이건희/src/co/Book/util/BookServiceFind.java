package co.Book.util;

import java.util.List;
import java.util.Scanner;

import co.Book.access.BookList;
import co.Book.model.Book;

public class BookServiceFind implements BookService {


	public void execute(BookList list) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		List<Book> li = list.findName(name);
		
		System.out.println(li);
	}

}
