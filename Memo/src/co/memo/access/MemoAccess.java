package co.memo.access;

import java.util.ArrayList;

import co.memo.model.Memo;

//인터페이스
public interface MemoAccess {
	
	//등록
	public void insert(Memo memo);
	//수정
	public void update(Memo memo);
	//삭제
	public void delete(String content);
	//메모전체조회
	public ArrayList<Memo> selectAll();
	//날짜검색
	public Memo selectOne(String date);
	//내용검색
	public Memo findContent(String content);
	
}
