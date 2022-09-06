package com.tjoeun.DBTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtill {

	//MySQl에 연결하는 Connection을 만들어 리턴하는 메소드
	public static Connection getMySQLConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //mysql 5.x 사용자

			String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; //mysql 5.x 사용자
//			String url = "jdbc:mysql://localhost:3306/javaam?serverTimezone=UTF"; //mysql 8.x 사용자
			conn = DriverManager.getConnection(url, "root", "1234");
			
			System.out.println("연결성공: " + conn);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 클래스를 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르기 않습니");
		}
		return conn;
	
	}
	
	public static void close(Connection conn) {
		if (conn != null) { try {conn.close(); } catch (SQLException e) { e.printStackTrace();} }
	}
	public static void close(Statement stmt) {
		if (stmt != null) { try {stmt.close(); } catch (SQLException e) { e.printStackTrace();} }
	}
	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) { try {pstmt.close(); } catch (SQLException e) { e.printStackTrace();} }
	}
	public static void close(ResultSet rs) {
		if (rs != null) { try {rs.close(); } catch (SQLException e) { e.printStackTrace();} }
	}
}
