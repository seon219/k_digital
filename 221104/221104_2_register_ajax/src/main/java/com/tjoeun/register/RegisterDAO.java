package com.tjoeun.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public RegisterDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "tjoeun", "1234");
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보가 올바르지 않습니다.");
		}
	}
	
	// index.jsp에서 입력한 데이터를 테이블에 저장하는 메소드
	public int insert(RegisterVO vo) {
		System.out.println("ReigsterDAO 클래스의 insert() 메소드");
		
		try {
			String sql = "insert into register (userid, userpassword, username, userage, usergender, useremail) "
					+ "values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpassword());
			pstmt.setString(3, vo.getUsername());
			pstmt.setInt(4, vo.getUserage());
			pstmt.setString(5, vo.getUsergender());
			pstmt.setString(6, vo.getUseremail());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// sql 명령에 오류가 있어서 catch 블록이 실행되면 -1을 리턴
		return -1;
	}

	
	// 가입하려는 아이디가 테이블에 존재하는가 확인하는 메소드
	public int registerCheck(String userid) {
		System.out.println("RegisterDAO 클래스의 registerCheck() 메소드");
		try {
			String sql = "select * from register where trim(userid) = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (userid.trim().equals("")) {
				// 중복 검사할 아이디를 입력하지 않고 중복 체크 버튼을 클릭했을 경우
				return 1;
			} else if (rs.next()) {
				// 사용중인 아이디일 경우
				return 2;
			} else {
				// 사용가능한 아이디일 경우
				return 3;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
