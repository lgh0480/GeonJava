package co.Book.access;

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

		for (Book b : books) {
			if (b.getName().contains(name)) {
				ArrayList<Book> bookss = new ArrayList<Book>();
				return bookss;

			}
		}
		return null;
	}

}
