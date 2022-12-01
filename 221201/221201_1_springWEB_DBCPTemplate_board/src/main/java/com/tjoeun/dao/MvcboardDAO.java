package com.tjoeun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tjoeun.springWEB_DBCP_board.Constant;
import com.tjoeun.vo.MvcboardList;
import com.tjoeun.vo.MvcboardVO;

public class MvcboardDAO {

	private static final Logger logger = LoggerFactory.getLogger(MvcboardDAO.class);
	
	// JdbcTemplate 설정
	// DAO 클래스에서 JdbcTemplate을 사용하기 위해서 JdbcTemplate 클래스 타입의 객체를 선언한다
	private JdbcTemplate template;
	
	// DAO 클래스의 bean이 기본 생성자로 생성되는 순간 servlet-context.xml 파일에서 생성되서 
	// 컨트롤러가 전달받아 Constant 클래스의 JdbcTemplate 클래스 타입의 static 객체에 저장한 bean으로 초기화 시킨다.
	
	// 여기부터 =========================================================================================
	
	// DBCP에 사용할 DataSource 인터페이스 객체를 선언한다.
	private DataSource dataSource;
	
	public MvcboardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
			
			template = Constant.template;

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	// 여기까지 DBCP 방식을 사용하는 객체를 초기화시키는 부분이므로 DBCP Template으로 코드 변환이 완료되면 모두 주석으로 처리한다.
	// =========================================================================================
	
	// InsertService 클래스에서 호출되는 테이블에 저장할 메인글이 저장된 객체를 넘겨받고 insert sql 명령을 실행하는 메소드
	public void insert(MvcboardVO mvcboardVO) {
		logger.info("insert()");
		// logger.info("{}", mvcboardVO);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) " + 
					"values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvcboardVO.getName());
			pstmt.setString(2, mvcboardVO.getSubject());
			pstmt.setString(3, mvcboardVO.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
	}

	// SelectService 클래스에서 호출되는 테이블에 저장된 전체 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드
	public int selectCount() {
		logger.info("selectCount()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0; // 테이블에 저장된 전체 글의 개수를 저장해서 리턴시킬 변수를 선언한다.
		
		try {
			conn = dataSource.getConnection();
			String sql = "select count(*) from mvcboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 테이블에 저장된 글의 개수는 null이 나올리 없으므로 조건 비교는 필요없다.
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return result;
	}

	
	// SelectService 클래스에서 호출되는 브라우저에 표시할 1페이지 분량의 글 목럭을 얻어오기 위해서
	// 시작 인덱스, 끝 인덱스가 저장된 HashMap 객체를 넘겨받고 테이블에서 1페이지 분량의 글 목록을 얻어오는 select sql 명령 실행하는 메소드
	public ArrayList<MvcboardVO> selectList(HashMap<String, Integer> hmap) {
		logger.info("selectList()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MvcboardVO> list = null; // 1페이지 분량의 글 목록을 저장해 리턴시킬 ArrayList를 선언
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from (" +
						 "	select rownum rnum, AA.* from (" +
						 " 		select * from mvcboard order by gup desc, seq asc" +
						 "	) AA where rownum <= ?" +
						 ") where rnum >= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hmap.get("endNo"));
			pstmt.setInt(2, hmap.get("startNo"));
			rs = pstmt.executeQuery();
			
			
			// ResultSet 객체에 저장된 1페이지 분량의 글 목록을 저장할 ArrayList 객체를 생성한다.
			list = new ArrayList<MvcboardVO>();
			// ResulrSer 객체에 저장된 글의 개수만큼 반복하며 ArrayList에 저장한다.
			while (rs.next()) {
				AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
				MvcboardVO mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);
				mvcboardVO.setIdx(rs.getInt("idx"));
				mvcboardVO.setName(rs.getString("name"));
				mvcboardVO.setSubject(rs.getString("subject"));
				mvcboardVO.setContent(rs.getString("content"));
				mvcboardVO.setGup(rs.getInt("gup"));
				mvcboardVO.setLev(rs.getInt("lev"));
				mvcboardVO.setSeq(rs.getInt("seq"));
				mvcboardVO.setHit(rs.getInt("hit"));
				mvcboardVO.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(mvcboardVO);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return list;
	}

	
	//IncrementService 클래스에서 호출되는 조회수를 증가시킬 글번호를 넘겨받고 조회수를 증가시키는 update sql 명령을 실행
	public void increment(int idx) {
		logger.info("increment()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "update mvcboard set hit = hit + 1 where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
	}

	
	// ContentViewService 클래스에서 호출되는 조회수를 증가시킨 글 번호를 넘겨받고,
	// 조회수를 증가시킨 글 1건을 얻어오는 select sql 명령을 실행하는 메소드
	public MvcboardVO selectByIdx(int idx) {
		logger.info("selectList()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MvcboardVO mvcboardVO = null; // 조회수를 증가시킨 글 1건을 얻어와 저장시켜 리턴할 객체를 선언
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "select * from mvcboard where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			// ResultSet 객체에 저장된 글 1건을 리턴시키기 위해서 MvcbaordVO 클래스 객체에 저장
			if(rs.next()) {
				AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
				mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);
				mvcboardVO.setIdx(rs.getInt("idx"));
				mvcboardVO.setName(rs.getString("name"));
				mvcboardVO.setSubject(rs.getString("subject"));
				mvcboardVO.setContent(rs.getString("content"));
				mvcboardVO.setGup(rs.getInt("gup"));
				mvcboardVO.setLev(rs.getInt("lev"));
				mvcboardVO.setSeq(rs.getInt("seq"));
				mvcboardVO.setHit(rs.getInt("hit"));
				mvcboardVO.setWriteDate(rs.getTimestamp("writeDate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		return mvcboardVO;
	}
	
	
	// UpdateService 클래스에서 호출되는 수정할 글번호와 데이터를 넘겨받고 
	// 글 1건을 수정하는 update sql 명령을 실행하는 메소드
	public void update(int idx, String subject, String content) {
		logger.info("update(int idx, String subject, String content)");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "update mvcboard set subject = ?, content = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, idx);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
		
	}

	
	// UpdateService 클래스에서 호출되는 수정할 글번호와 데이터가 저장된 객체를 넘겨받고 
	// 글 1건을 수정하는 update sql 명령을 실행하는 메소드
	public void update(MvcboardVO mvcboardVO) {
		logger.info("update(MvcboardVO mvcboardVO)");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "update mvcboard set subject = ?, content = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvcboardVO.getSubject());
			pstmt.setString(2, mvcboardVO.getContent());
			pstmt.setInt(3, mvcboardVO.getIdx());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
	}

	
	// DeleteService 클래스에서 호출되는 삭제할 글 번호를 넘겨받고
	// 글 1건을 삭제하는 delete sql 명령을 실행하는 메소드
	public void delete(int idx) {
		logger.info("delete()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "delete from mvcboard where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
	}

	
	// ReplyService 클래스에서 호출되는 글그룹과 글이 출력되는 순서가 저장된 HashMap 객체를 넘겨받고 
	// 조건에 만족하는 레코드의 seq를 1씩 증가시키는 update sql 명령을 실행하는 메소드 
	public void replyInsert(HashMap<String, Integer> hmap) {
		logger.info("replyInsert()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "update mvcboard set seq = seq + 1 where gup = ? and seq >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hmap.get("gup"));
			pstmt.setInt(2, hmap.get("seq"));
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		
	}

	
	// ReplyService 클래스에서 호출되는 답글이 저장된 객체를 넘겨받고
	// 답글을 저장하는 insert sql 명령을 실행하는 메소드
	public void replyInsert(MvcboardVO mvcboardVO) {
		logger.info("replyInsert()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = dataSource.getConnection();
			String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq)" +
						 " values(mvcboard_idx_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvcboardVO.getName());
			pstmt.setString(2, mvcboardVO.getSubject());
			pstmt.setString(3, mvcboardVO.getContent());
			pstmt.setInt(4,  mvcboardVO.getGup());
			pstmt.setInt(5,  mvcboardVO.getLev());
			pstmt.setInt(6,  mvcboardVO.getSeq());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
	}

}






