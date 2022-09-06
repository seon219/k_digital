package com.tjoeun.DBTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) throws SQLException {

		// 테이블에 저장할 데이터를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine().trim();
		System.out.print("메모 : ");
		String memo = scanner.nextLine().trim();
		
		
		// 데이터 베이스 작업에 사용할 객체 선언
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		
		// mysql에 연결
		conn = DBUtill.getMySQLConnection();
		if (conn != null) {
			
			// mysql에 연결이 되었으므로 데이터를 테이블에 저장
			
			
/*			// statement를 사용해서 입력받은 데이터를 테이블에 저장
			// sql 명령을 만든다. 문자열은 반드시 작은따옴표로 묶고, 문장 끝에 ; 사용하지 않는다.
//			String sql = "insert into memo(name, password, memo) values ('" + name + "', '" + password + "', '" + memo + "')" ;
			String sql = String.format("insert into memo(name, password, memo) values ('%s', '%s', '%s')", name, password, memo);
			//System.out.println(sql);
			// sql 명령을 실행할 준비
			stmt = conn.createStatement();
			// sql 명령 실행
			// executeQuery(): 테이블에 저장된 데이터가 변경되지 않는 sql 명령을 실행 => select
			// executeUpdate(): 테이블에 저장된 데이터가 변경되는 sql 명령 실행 => insert, delete, update
			// executeUpdate() 메소드는 정상적으로 실행한 sql 명령의 개수를 리턴
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
*/			
			
			
			// PreParedStatement를 사용해서 입력받은 데이터를 테이블에 저정
			// sql 명령을 만든다
			// 변수에 저장된 데이터가 대입될 자리에 "?"를 입력하고 나중에 "?"에 데이터를 대입한다.
			// 문자열 데이터일 경우 Statement처럼 작은따옴표를 사용할 필요가 없다.
			String sql = "insert into memo(name, password, memo) values (?, ?, ?)" ;
			// sql 명령을 임시로 실행
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 넣어준다.
			pstmt.setString(1, name);			
			pstmt.setString(2, password);			
			pstmt.setString(3, memo);	
			// ?가 채워진 sql 명령을 최종적으로 실행
			pstmt.executeUpdate();
			
		} else {
			System.out.println("mysql에 연결 실패");
		}
		
		DBUtill.close(conn);
		

	}

}
