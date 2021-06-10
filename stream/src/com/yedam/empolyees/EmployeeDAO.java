package com.yedam.empolyees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	// 필드 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	public ArrayList<Employees> getEmployeeList() {
		ArrayList<Employees> employList = new ArrayList<>();
		connect();
		String sql = "SELECT lastname, firstname, title, birthdate from employees";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 쿼리 실행결과를 가져오는 부분
			while (rs.next()) { // 건수만큼 반복
				Employees employees = new Employees(); // DB에 담겨있는 값을 employees에 담음
				employees.setLastname(rs.getString("lastname"));
				employees.setFirstname(rs.getString("firstname"));
				employees.setTitle(rs.getString("title"));
				employees.setBirthdate(rs.getString("birthdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return employList;
	}

	public static void connect() { // db 연결 하는것 까지만 하는것
//		Connection conn = null; // 자바 프로그램이랑 sql이랑 연결해주는 통로
		String url = "jdbc:sqlite:C:/sqlite/db/chinook.db"; // db를 쓰기위한 작업
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 리소스를 반환하는 부분
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
