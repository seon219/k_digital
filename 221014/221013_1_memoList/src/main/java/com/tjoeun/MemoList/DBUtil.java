package com.tjoeun.MemoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	// mysql에 연결하는 connection을 리턴하는 메소드
	public static Connection getMysqlConnection() {
		
		Connection conn = null;
		
		try{
			// mysql 드라이버 클래스를 읽어온다.
			Class.forName("com.mysql.jdbc.Driver");
			
			// mysql에 연결
			String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			// 데이터베이스와 연결이 되었으므로 데이터베이스를 사용
			System.out.println("연결 성공: " + conn);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");			
		}
		return conn;
	}
	
	// Connection 객체를 닫는 메소드
	public static void close(Connection conn) {
		if (conn != null){
			try{
				conn.close();					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
