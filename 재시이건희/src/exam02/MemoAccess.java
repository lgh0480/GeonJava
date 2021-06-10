package exam02;

import java.util.List;

// 도서관리 개발 표준
public  abstract class MemoAccess {
	
	//등록
	public abstract void insert(Memo m);	
	//이름으로조회
	public abstract List<Memo> findDate(String date);
	//ISBN 조회

	
	//	public abstract Memo findIsbn(String isbn);
//	//전체출력
//	public abstract List<Memo> findAll();
//	//삭제
//	public abstract void delete(Memo book);
//		
}
