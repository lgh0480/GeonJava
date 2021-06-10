package exam02;

import java.util.ArrayList;
import java.util.List;

public class BookList extends BookAccess  {
	
	ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public void insert(Book friend) {
		books.add(friend);
	}

	@Override
	public List<Book> findName(String name) {
		List<Book> list = new ArrayList<Book>(); 
		for (Book b : books) {
			if(b.getName().contains(name)) {
				list.add(b); 
			}
		}
		return list; 
	}

}
