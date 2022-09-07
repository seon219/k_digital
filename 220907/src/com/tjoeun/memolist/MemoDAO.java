package com.tjoeun.memolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// MemoService 클래스에서 전처리 작업이 완료되서 넘어온 데어터로 sql 명령을 실행하는 클래스
public class MemoDAO {
	
	
	// 테이블에 저장할 데이터가 저장된 MemoVO클래스 객체를 넘겨받아 테이블에 데이터를 저장하는 메소드
	public static boolean insert(MemoVO vo) {
		
		boolean result = true;
		
		
		// 데이터 베이스 작업에 사용할 객체 선언
		Connection conn = null;	
		PreparedStatement pstmt = null;
	
		try {
			// mysql에 연결
			conn = DBUtill.getMySQLConnection();
			
			// sql 명령 만들기
			String sql = "insert into memo(name, password, memo) values (?, ?, ?)" ;
			// sql 명령 임시 실행
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터를 넣어준다.
			pstmt.setString(1, vo.getName());			
			pstmt.setString(2, vo.getPassword());			
			pstmt.setString(3, vo.getMemo());
			// ?가 채워진 sql 명령 최종적으로 실행
			pstmt.executeUpdate();
			//System.out.println(vo.getName() + "님 글 저장완료!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql 명령이 올바르게 실행되지 않았습니다.");
			result = false;
		} finally {
			DBUtill.close(conn);
			DBUtill.close(pstmt);
		}
		
		return result;
		
		
	}

	
//	 ==============
	
	
	// 테이블에 저장된 메모 목록을 최신글 순으로 얻어오는 메소드
	public static ArrayList<MemoVO> select() {
		
		// 데이터 베이스 작업에 사용할 객체 선언
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 얻어온 글 저장
		ArrayList<MemoVO> list = null; // 결과(글 목록)를 저장해서 리턴시킬 ArrayList
				
		try {
			// mysql에 연결
			conn = DBUtill.getMySQLConnection();
			// sql 명령 만들기
			String sql = "SELECT * FROM MEMO ORDER BY IDX DESC";
			//String sql = "SELECT idx, name 'n', password, memo, writeDate FROM MEMO ORDER BY IDX DESC";
			// 임시 실행
			pstmt = conn.prepareStatement(sql);
			// 실행 결과를 ResultSet 객체에 저장
			rs = pstmt.executeQuery();
			// 테이블에서 성공적으로 데이터를 얻어왔으므로 결과를 저장해서 리턴시킬 ArrayList 객체를 만든다.
			list = new ArrayList<>();
			
			// ResultSet 객체에 데이터가 있는동안 반복하여 ResultSet 객체에 저장된 데이터를 MemoVO객체로 만들어서 ArrayList에 저장
			// next() 메소드는 ResultSet 객체에 저장된 다음 데이터로 접근해서 다음 데이터가 있으면 true, 없으면 false 리턴
			while(rs.next()) {
				// ResultSet 객체의 데이터를 읽어서 MemoVO클래스 객체에 저장
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				// vo.setName(rs.getString("n"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate")); // 서식을 바꾸지 않을 때
//				rs.getTimestamp("writeDate"); // 서식을 바꿀 때, 날짜(date), 시간(time), 날짜시간(timestamp)
//				System.out.println(vo);
				
				// MemoVO 클래스 객체를 Arraylist에 저장
				list.add(vo);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql 명령이 올바르게 실행되지 않았습니다.");
			
			} finally {
				DBUtill.close(conn);
				DBUtill.close(pstmt);
				DBUtill.close(rs);
				
			}
	
		return list;
	}


	
	// 테이블에서 글 1건을 얻어오는 메소드 
	public static MemoVO selectByIdx(int idx) {
		
		// 데이터 베이스 작업에 사용할 객체 선언
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 얻어온 글 저장
		MemoVO vo = null; // 글 1건을 저장해서 리턴시킬 객체 선언
				
		try {
			
			conn = DBUtill.getMySQLConnection();
			String sql = "select * from memo where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				// 테이블에서 글 1건을 얻어왔으므로 결과를 저장해서 리턴시킬 MemoVO 클래스 객체를 만든다.
				vo = new MemoVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setWriteDate(rs.getTimestamp("writeDate"));
				//System.out.println(vo);
				
			}
			
		} catch(SQLException e) {
			System.out.println("sql 명령이 올바르게 실행되지 않았습니다.");
			
		} finally {
			DBUtill.close(conn);
		}
		return vo;
	}


	public static void delete(int idx) {
		
		Connection conn = null;	
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBUtill.getMySQLConnection();
			String sql = "delete from memo where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("sql 명령이 올바르게 실행되지 않았습니다.");
			
		} finally {
			DBUtill.close(conn);
		}
		
	}

	

	public static void update(int idx, String memo) {
		Connection conn = null;	
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBUtill.getMySQLConnection();
			String sql = "update memo set memo = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("sql 명령이 올바르게 실행되지 않았습니다.");
			
		} finally {
			DBUtill.close(conn);
		}
		
	}


}
