package co.friend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public Connection conn; // 연결 개체의 데이터베이스는 테이블, 지원되는 SQL 문법

	protected DAO() { // dao 생성자
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}// end of class
