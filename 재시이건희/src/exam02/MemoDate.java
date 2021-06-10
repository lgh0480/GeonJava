package exam02;

import java.util.ArrayList;
import java.util.List;

/*
 * 여러건의 도서 정보를 저장하기 위한 클래스. -> DAO 
 */
public class MemoDate extends MemoAccess {
	// 전체도서 리스트
	ArrayList<Memo> memos = new ArrayList<Memo>();

	@Override
	//입력
	public void insert(Memo m) {
		memos.add(m);
	}

	@Override
	//날짜로 조회
	public List<Memo> findDate(String date) {
		List<Memo> list = new ArrayList<Memo>();
		for (Memo m : memos) {
			if(m.getDate().contains(date)) { //메모명이 포함된 메모만
				list.add(m);
			}
		}
		return null;
	}
	
	
//	@Override // 단건 책 찾기
//	public List<Memo> findName(String name) {
//		List<Memo> list = new ArrayList<Memo>();
//		for (Memo b : books) { // books:모든 도서 비교
//			if (b.getName().contains(name)) { // 도서명이 포함된 도서만
//				list.add(b);
//			}
//		}
//		return list;
//	}
//
//	@Override
//	public Memo findIsbn(String isbn) {
//		Memo book = null;
//		for (Memo b : books) {
//			if (b.getIsbn().equals(isbn)) {
//				book = b;
//				break;
//			}
//		}
//
//		return book;
//	}
//
//	@Override
//	// 전체출력
//	public List<Memo> findAll() {
//		List<Memo> list = new ArrayList<>();
//
//		return list;
//	}
//
//	@Override
//	public void delete(Memo book) {
//		books.remove(books.indexOf(book));
//
//	}


}
