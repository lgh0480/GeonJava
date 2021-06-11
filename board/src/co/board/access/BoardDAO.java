package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.board.model.Board;

public class BoardDAO implements BoardAccess {
	static PreparedStatement psmt; // 스테틱으로 선언해야됨
	static ResultSet rs;
	static Connection conn;
	String sql;
	// 1)전체리스트, 2.글등록, 3.글수정 4.글삭제 5.한건조회(상세보기)

	// 전체리스트
	public ArrayList<Board> getBoardList() {
		ArrayList<Board> boardlist = new ArrayList<>(); // 담을 변수 선언
		connect(); // 객체 연결
		sql = "select * from board";
		try {
			psmt = conn.prepareStatement(sql); // 커넥션이 가지고 있음 sql실행하고 결과 도출
			rs = psmt.executeQuery();
			while (rs.next()) { // 건수 만큼 반복
				Board board = new Board(); // 선언된 값을 집어 넣기 위함
				board.setB_id(rs.getInt("b_id"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setB_writer(rs.getString("b_writer"));
				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardlist;
	}

	// 글 등록
	public void insertBoard(String b_title, String b_content,String b_writer) {
		connect();
		sql = "insert into board(b_title,b_content,b_writer) values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_title);
			psmt.setString(2, b_content);
			psmt.setString(3, b_writer);
			int r =psmt.executeUpdate();
			System.out.println(r+"건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	// 글 수정
	public void updateBoard(Board b) {
		connect();
		sql = "update board set b_content=? where b_id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b.getB_content());
			psmt.setInt(2, b.getB_id());
			int r = psmt.executeUpdate();
			System.out.println(r+ "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	// 글 삭제
	public void deleteBoard(int b_id) {
		connect();
	sql = "delete from board where b_id =?";
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, b_id);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력되었으!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	// 한건 조회
	// 글번호 -> 제목: 작성자:
	// 내용:
	public Board getBoard(int b_id) {
		connect();
		sql = "select * from board where b_id = ?"; // ? 값을
		Board b = null;
		try {
			psmt = conn.prepareStatement(sql); // PreparedStatment 객체 생성
			psmt.setInt(1, b_id); // 1의 매개변수는 ?이거를 뜻함 . 두번째는 메서드에 매개변수
			rs = psmt.executeQuery();
			if (rs.next()) {
				b = new Board();
				b.setB_id(rs.getInt("b_id"));
				b.setB_title(rs.getString("b_title"));
				b.setB_content(rs.getString("b_content"));
				b.setB_writer(rs.getString("b_writer"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	} //end of getBoard

	//로그인 구현
		public boolean getLogin(String u_id, String u_pass) {
			boolean result = false;
			connect();
			sql = "SELECT u_pass FROM member WHERE u_id = ?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, u_id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					if(rs.getString(1).contentEquals(u_pass)) {
						result = true; //로그인 성공
					}else {
						result = false;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return result;
					
		}
	
		//댓글 입력
		public void insertComment( String b_content ,String b_writer,int b_parent_id) {
			connect();
			sql  = "insert into board (b_title, b_content, b_writer, b_parent_id) valuse('댓글',?,?,?) ";
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, b_content);
					psmt.setString(2, b_writer);
					psmt.setInt(3, b_parent_id);
					int r =psmt.executeUpdate();
					System.out.println( "댓글"+ r+"건이 입력되었습니다.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	public static void connect() { // db 연결 하는것 까지만 하는것

		String url = "jdbc:sqlite:C:/sqlite/db/sample.db"; // db를 쓰기위한 작업
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	

}// end of class
