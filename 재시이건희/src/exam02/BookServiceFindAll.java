package exam02;

public class BookServiceFindAll implements MemoService{

	@Override
	public void execute(MemoDate books) {
		for(Memo b: books.books) {
			System.out.println("전체조회"+ b);
		}
	}

}
