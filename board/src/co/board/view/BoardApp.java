package co.board.view;

import java.util.List;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;

public class BoardApp {
	BoardAccess boardList = new BoardDAO();
	Scanner scanner = new Scanner(System.in);

	public void start() {
		int menu = 0;

		do {
			System.out.println("|=  메  모  장 ====|");
			System.out.println("|1. 전체조회=======|");
			System.out.println("|2. 글 등 록=======|");
			System.out.println("|3. 글 수 정=======|");
			System.out.println("|4. 글 삭 제=======|");
			System.out.println("|5. 한건조회   ====|");
			System.out.println("|0. 종료===========|");
			menu = scanner.nextInt();
			switch (menu) {
			case 1:
				getBoardList();
				break;
			case 2:
				insertBoard();
				break;
			case 3:
				updateBoard();
				break;
			case 4:
				deleteBoard();
				break;
			case 5:
				getBoard();
				break;

			}
		} while (menu != 0);
	}

	private void insertBoard() {
		System.out.println("제목을 입력하세요 > ");
		String b_title = scanner.nextLine();
		scanner.nextLine();
		System.out.println("내용을 입력하세요 > ");
		String b_content = scanner.nextLine();
		System.out.println("작성자 이름은? > ");
		String b_writer = scanner.nextLine();
		boardList.insertBoard(b_title, b_content, b_writer);

	}

	private void getBoardList() {
		List<Board> list = boardList.getBoardList();
		for (Board board : list) {
			System.out.println(board);
		}
	}

	private void getBoard() {
		System.out.print("조회할 아이디를 입력하세요 >");
		int b_id = scanner.nextInt();
		Board b = boardList.getBoard(b_id);
		System.out.println(b);
	}

	private void updateBoard() {
		System.out.println("조회할 글 번호를 입력하세요.");
		int b_id = scanner.nextInt();
		scanner.nextLine();
		Board b = boardList.getBoard(b_id);

//		if (b == null) { // 조회아이디가 존재 x.
//			System.out.println("존재하지 않는 아이디입니다 다시 입력하세요.");
//			
//		}
		System.out.print("변경할 내용을 입력하세요 >");
		String changecontent = scanner.nextLine();
		if (!changecontent.equals("")) {
			b.setB_content(changecontent);
		}
		boardList.updateBoard(b);
	}

	private void deleteBoard() {
		System.out.println("삭제할 아뒤 입력하셈 >");
		int searchId = scanner.nextInt();
		scanner.nextLine();
		boardList.deleteBoard(searchId);
	}

}// end of class