package exam02;

import java.util.List;

// 도서관리 개발 표준
public  abstract class BookAccess {
	//등록
	public abstract void insert(Book book);	
	//이름으로조회
	public abstract List<Book> findName(String name);
	//ISBN 조회
	public abstract Book findIsbn(String isbn);
	//전체출력
	public abstract List<Book> findAll();
	//삭제
	public abstract void delete(Book book);
		
}
