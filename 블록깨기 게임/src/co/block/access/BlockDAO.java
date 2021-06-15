package co.block.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.block.model.Block;

public class BlockDAO implements BlockAccess {
	static PreparedStatement psmt; // 스테틱으로 선언해야됨
	static ResultSet rs;
	static Connection conn;
	String sql;
	
	
	@Override //플레이어 명예의 전당 입력
	public void write(Block block) {
		connect();
		sql = "insert into Block(player, score) valuse(?,?)";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, block.getPlayer());
				psmt.setInt(2, block.getScore());
				int r = psmt.executeUpdate();
				System.out.println(r + "건 입력.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}				
	}
	@Override   //명예의 전당 전체 조회
	public ArrayList<Block> playerAll() {
		ArrayList<Block> blockList = new ArrayList<>();
		connect();
		sql = "select * from Block";
			try {
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				while(rs.next()) {
					Block block = new Block();
					block.setPlayer(rs.getString("player"));
					block.setScore(rs.getInt("score"));
					blockList.add(block);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return blockList;
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


}
