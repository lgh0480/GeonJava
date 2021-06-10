package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO {
	// 필드로 선언
	static PreparedStatement psmt; // 스테틱으로 선언해야됨
	static ResultSet rs;
	static Connection conn;
	// 1.조회, 2.입력, 3.수정 4.삭제 5.전체리스트(각각 기능을 분리) => 메서드로 기능 분리.

	// 전체리스트 //항상 커넥션 객체가 있어야됨.
	public ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>(); // 담을 변수를 선언해야됨.
		connect(); // Connection 객체 연결.
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql); // Connection가지고있는 sql실행하고 결과를 받아내는것
			rs = psmt.executeQuery(); // 쿼리실행결과를 가져오는 부분 // select만 사용함
			while (rs.next()) { // 건수 만큼 반복
				// System.out.println(rs.getInt("id")+"," + rs.getString("name")); // rs. 가지고있는
				// id를 가져옴
				Person person = new Person(); // 데이터 베이스에서 선언된 4개의 값을 person에 담기위해서
				person.setId(rs.getInt("id")); // db에 있는 id 컬럼 값을 가져 오는게 rs.getInt("id")이다.
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("Phone"));
				personList.add(person); // 최종적으로 리스트에 입력한 값을 한건씩 담는 것이 add();이다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 실행이 잘되고 안되고 간에 무조껀 close
		}
		return personList;
	}

	public static void connect() { // db 연결 하는것 까지만 하는것
//		Connection conn = null; // 자바 프로그램이랑 sql이랑 연결해주는 통로
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db"; // db를 쓰기위한 작업
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

}
