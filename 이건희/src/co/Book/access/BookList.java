package co.Book.access;
//등록과 조회만 하는것
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.Book.model.Book;

public class BookList extends BookAccess {
	ArrayList<Book> books= new ArrayList<Book>();

	public BookList() {
	}

	@Override
	public void insert(Book b) {
		books.add(b);		
	}

	@Override
	public List<Book> findName(String name) {
		List<Book> bookss = new ArrayList<Book>();

		for (Book b : books) {
			if (b.getName().contains(name)) {
				

			}
		}
		return bookss;
	}

}
