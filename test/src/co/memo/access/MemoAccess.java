package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo;

public interface MemoAccess {
	
	//// 1.추가 2. 수정 3. 삭제 4.조회 5.날짜로조회 6.내용으로 조회 
	
	//메모 추가
	public void write(String date, String title, String content);
	// 날짜 수정 ->날짜찾아서  내용 수정
	public void update(String date, String title, String content);
	// 메모 삭제
	public void delete(String title);
	// 날짜 전체조회
	public ArrayList<Memo> FindAll();
	// 날짜 단건 조회
	public Memo FindByDate(String dates);
	// 내용으로 조회
	public void FindByContent(String content);
}
