package exam02;

import java.util.ArrayList;
import java.util.List;
/*
 * 여러건의 도서 정보를 저장하기 위한 클래스. -> DAO 
 */
public class BookList extends BookAccess  {
	//전체도서 리스트 
	ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public void insert(Book book) {
		books.add(book);
	}

	@Override //단건 책 찾기
	public List<Book> findName(String name) {
		List<Book> list = new ArrayList<Book>(); 
		for (Book b : books) { //books:모든 도서 비교 
			if(b.getName().contains(name)) { //도서명이 포함된 도서만 
				list.add(b); 
			}
		}
		return list; 
	}

	@Override
	public Book findIsbn(String isbn) {
		Book book = null;
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				book =b;
				break;
			}
		}
		
		return book;
	}

	@Override 
	//전체출력
	public List<Book> findAll() {
		List<Book> list = new ArrayList<>();
		
		return list;
	}

	@Override
	public List<Book> delete(String name) {
		List<Book> list = new ArrayList<>();
			for(Book b: books)	{
				if(b.getName().contains(name)) {
					list.remove(b);
				}
			}
		
		return list;
	}

}
