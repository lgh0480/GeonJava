package co.board.access;

import java.util.ArrayList;

import co.board.model.Board;

//* 1) 전체리스트 2) 글등록 3)글수정 4)글삭제 5)한건조회

public interface BoardAccess {

	// 전체조회
	public ArrayList<Board> getBoardList();

	// 등록
	public void insertBoard(String b_title, String b_content,String b_writer);

	// 수정
	public void updateBoard(Board b);

	// 삭제
	public void deleteBoard(int b_id);

	//한건 조회
	public Board getBoard(int b_id);


}
