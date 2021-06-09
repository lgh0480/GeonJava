package exam02;

public class BookServiceFindAll implements BookService{

	@Override
	public void execute(BookList books) {
		for(Book b: books.books) {
			System.out.println("전체조회"+ b);
		}
	}

}
