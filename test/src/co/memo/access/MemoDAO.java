package co.memo.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.memo.model.Memo;

// MemoAccess를 구현하는 클래스입니다.
// 기능을 작성하세요.
public class MemoDAO implements MemoAccess {
	static PreparedStatement psmt; // 스테틱으로 선언해야됨
	static ResultSet rs;
	static Connection conn;
	String sql;

	// 메모 추가
	public void write(String date, String title, String content) {
		connect();
		sql = "insert into Memo(date,title,content) values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			psmt.setString(2, title);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 메모 수정
	public void update(String date, String title, String content) {
		connect();
		sql = "update Memo set title = ?, content =?  where date =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, date);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 메모 삭제
	public void delete(String title) {
		connect();
		sql = "delete from Memo where title =? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 날짜 전체조회
	public ArrayList<Memo> FindAll() {
		ArrayList<Memo> memoList = new ArrayList<>();
		connect(); // 객체 연결
		sql = "select * from Memo";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) { // 건수만큼 반복
				Memo memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				memoList.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memoList;
	}

	// 날짜 단건 조회
	public Memo FindByDate(String date) {
		connect();
		sql = "select * from Memo where date = ?"; // ? 값을
		Memo m = null;
		try {
			psmt = conn.prepareStatement(sql); // PreparedStatment 객체 생성
			psmt.setString(1, date); // 1의 매개변수는 ?이거를 뜻함 . 두번째는 메서드에 매개변수
			rs = psmt.executeQuery();
			if (rs.next()) {
				m = new Memo();
				m.setDate(rs.getString("date"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return m;
	}

	// 내용으로 조회
	public void FindByContent(String content) {
		connect();
		sql = "select * from Memo where content = ?"; // ? 값을
		Memo m = null;
		try {
			psmt = conn.prepareStatement(sql); // PreparedStatment 객체 생성
			psmt.setString(1, content); // 1의 매개변수는 ?이거를 뜻함 . 두번째는 메서드에 매개변수
			rs = psmt.executeQuery();
			while(rs.next()) {
				m = new Memo();
				m.setDate(rs.getString("date"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				m.print();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
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

} // end of class
