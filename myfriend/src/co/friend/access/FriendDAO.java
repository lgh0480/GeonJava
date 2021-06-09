package co.friend.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.friend.model.Friend;
import co.friend.util.DAO;

/* FriendAccess,FriendList.java 
 * 
 */
public class FriendDAO extends DAO implements FriendAccess {

	PreparedStatement psmt; // 사전 컴파일 된 SQL 문을 나타내는 개체입니다.
	ResultSet rs; // 일반적으로 데이터베이스를 쿼리하는 명령문을 실행하여 생성되는 데이터베이스 결과 집합을 나타내는 데이터 테이블입니다.
	String sql;
	//name, tel값을 담아 주는 걸렉션
	public Map<String, String>getNmaeTel() {
		sql = "select name, tel from Friend";
		Map<String, String> map = new HashMap<>();
			try {
				psmt=conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					map.put(rs.getString("name"), rs.getString("tel"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return map;
	}
	
	@Override
	// 입력 기능
	public void insert(Friend friend) {
		sql = "insert into friend values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, friend.getGubun());
			psmt.setString(2, friend.getName());
			psmt.setString(3, friend.getTel());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 수정기능
	@Override
	public void update(Friend friend) {
		// 구분, 이름, 전화
		// 동일한 이름은 없다는 전제.
		// where name=??
		sql = "UPDATE friend set tel =? where name =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, friend.getTel());
			psmt.setString(2, friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 삭제기능
	@Override
	public void delete(String name) {
		sql = "delete from friend where name =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 전체조회
	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> fList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from friend");
			rs = psmt.executeQuery();
			while (rs.next()) {

				Friend friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
				fList.add(friend); // 데이터건수만큼 ArrayList담아서 반환

			} // end of while

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fList;
	} // end of selectAll

	// 이름 조회
	@Override
	public Friend selectOne(String name) {
		sql = "SELECT *from friend where name =?";
		Friend f = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				f = new Friend(); // instance를 생성
				f.setGubun(rs.getString("gubun"));
				f.setName(rs.getString("name"));
				f.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	} // end of selectOne

	@Override
	public Friend findTel(String Tel) {
		sql = "select * from friend where tel =?";
		Friend f = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Tel);
			rs = psmt.executeQuery();
			if (rs.next()) {
				f = new Friend();
				f.setGubun(rs.getString("gubun"));
				f.setName(rs.getString("name"));
				f.setTel(rs.getString("tel"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

} // end of class
