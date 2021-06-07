package co.Book.access;

import java.util.ArrayList;
import java.util.List;

import co.Book.model.Book;

public  abstract class BookAccess {
	
	public BookAccess() {}
	
	public abstract void insert(Book book);
	
	public abstract List<Book> findName(String s);
	
}
