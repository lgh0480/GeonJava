package co.Book.access;
//추상클래스
import java.util.ArrayList;
import java.util.List;

import co.Book.model.Book;

public  abstract class BookAccess {
	
	public BookAccess() {}
	
	public abstract void insert(Book book);
	
	public abstract List<Book> findName(String s);
	
}
