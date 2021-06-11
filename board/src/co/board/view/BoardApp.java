package co.board.view;

import java.util.List;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;
import co.board.model.User;

public class BoardApp {
	BoardAccess boardList = new BoardDAO();
	Scanner scanner = new Scanner(System.in);
	User user = new User();
	public void start() {
		int menu = 0;

		do {
			System.out.println("|=  메  모  장 ====|");
			System.out.println("|1. 전체조회=======|");
			System.out.println("|2. 글 등 록=======|");
			System.out.println("|3. 글 수 정=======|");
			System.out.println("|4. 글 삭 제=======|");
			System.out.println("|5. 한건조회   ====|");
			System.out.println("|6. 댓글    =======|");			
			System.out.println("|7. 로그인   ======|");			
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
			case 6:
				insertContent();
				break;
			case 7:
				getLogin();
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
		boardList.insertBoard(b_title, b_content, user.getU_id());

	}

	private void getBoardList() {
		List<Board> list = boardList.getBoardList();
		for (Board board : list) {
			System.out.printf("%d, %s ,%s\n", board.getB_id(),
											board.getB_title(),
											board.getB_writer());
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
		if(!b.getB_writer().equals(user.getU_id())) {
			System.out.println("ID와 게시글 작성자아이디가 다릅니다.");
			return;
		}
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
		Board b = boardList.getBoard(searchId); // 이미 존재하는걸 가져옴
		if(!b.getB_writer().equals(user.getU_id())) {
			System.out.println("ID와 게시글 작성자아이디가 다릅니다.");
			return;
		}
		
		boardList.deleteBoard(searchId);
	}
	private boolean getLogin() {
		boolean result = false;
		System.out.println("아뒤 > " );
		String u_id =scanner.next();
		System.out.println("비 번 > " );
		String u_pass = scanner.next();
		
		result = boardList.getLogin(u_id, u_pass);
		if(result) {
			user.setU_id(u_id);
			user.setU_pass(u_pass);
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		return result;
		
	}
	private void insertContent() {
		System.out.println("댓글을 입력 하실 글 아이디 입력 > ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Board b = boardList.getBoard(id);
		
		System.out.printf("글번호: %d, 글제목: %s ,작성자: %s , 내용:%s\n", b.getB_id(),
																			b.getB_title(),
																			b.getB_writer(),
																			b.getB_content());
		System.out.println("댓글 내용 > ");
		String content = scanner.next();
		String writer = user.getU_id();	
		
		boardList.insertComment(content, writer,b.getB_id() );
		
	}
	
}// end of class