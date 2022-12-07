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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.tjoeun.springWEB_DBCP_board.Constant;
import com.tjoeun.vo.MvcboardList;
import com.tjoeun.vo.MvcboardVO;

public class MvcboardDAO {

	private static final Logger logger = LoggerFactory.getLogger(MvcboardDAO.class);
	
	// JdbcTemplate 설정
	private JdbcTemplate template;
	
	public MvcboardDAO() {
		template = Constant.template;
	}
	
	// InsertService 클래스에서 호출되는 테이블에 저장할 메인글이 저장된 객체를 넘겨받고 insert sql 명령을 실행하는 메소드
	public void insert(final MvcboardVO mvcboardVO) {
		logger.info("insert()");
		String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) " + 
				"values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
		
		// update(): 테이블의 내용이 갱신되는 sql 명령 => insert, delete, update
		// query(): 테이블의 내용이 갱신되지 않는 sql 명령 => select => 실행 결과가 여러건일 경우 사용
		// queryForInt(): 테이블의 내용이 갱신되지 않는 sql 명령 => select => 실행 결과가 정수일 경우 사용
		// queryForObject(): 테이블의 내용이 갱신되지 않는 sql 명령 => select => 실행 결과가 1건일 때 사용
		
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mvcboardVO.getName());
				ps.setString(2, mvcboardVO.getSubject());
				ps.setString(3, mvcboardVO.getContent());
				
			}
		});
	
	}
	

	// SelectService 클래스에서 호출되는 테이블에 저장된 전체 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드
	public int selectCount() {
		logger.info("selectCount()");
		
		String sql = "select count(*) from mvcboard";
		return template.queryForObject(sql, Integer.class);
		
	}

	
	// SelectService 클래스에서 호출되는 브라우저에 표시할 1페이지 분량의 글 목럭을 얻어오기 위해서
	// 시작 인덱스, 끝 인덱스가 저장된 HashMap 객체를 넘겨받고 테이블에서 1페이지 분량의 글 목록을 얻어오는 select sql 명령 실행하는 메소드
	public ArrayList<MvcboardVO> selectList(HashMap<String, Integer> hmap) {
		logger.info("selectList()");
		
		// JdbcTemplate을 사용하는 경우 select sql 명령에만 "?"를 사용할 수 없다. => ? 자리에 데이터가 저장된 변수를 직접 사용해야 한다.
		String sql = "select * from (" +
				 "	select rownum rnum, AA.* from (" +
				 " 		select * from mvcboard order by gup desc, seq asc" +
				 "	) AA where rownum <= " + hmap.get("endNo") +
				 ") where rnum >= " + hmap.get("startNo");
		
		// query(sql 명령, new BeanPropertyRowMapper(리턴할 클래스.class))
		// select sql 명령 실행 결과를 BeanPropertyRowMapper 클래스 생성자의 인수로 MvcboardVO 클래스를 넘겨서 sql 명령 실행 결과를 저장시켜 리턴
		// query() 메소드의 실행 결과가 List 인터페이스 타입으로 리턴되기 때문에 메소드의 리턴 타입인 ArrayList<MvcboardVO>로 형변환이 필요하다.
		// 데이터 베이스 테이블의 필드 이름과 BeanPropertyRowMapper 클래스 생성자의 인수로 전달되는 클래스의 필드 이름이 같아야 정상적으로 처리된다.
		return (ArrayList<MvcboardVO>) template.query(sql, new BeanPropertyRowMapper(MvcboardVO.class));
		
	}

	
	//IncrementService 클래스에서 호출되는 조회수를 증가시킬 글번호를 넘겨받고 조회수를 증가시키는 update sql 명령을 실행
	public void increment(final int idx) {
		logger.info("increment()");
		
		// "?"가 많지 않을 때 사용하면 편리
		String sql = "update mvcboard set hit = hit + 1 where idx = " + idx;
		template.update(sql);
	}

	
	// ContentViewService 클래스에서 호출되는 조회수를 증가시킨 글 번호를 넘겨받고,
	// 조회수를 증가시킨 글 1건을 얻어오는 select sql 명령을 실행하는 메소드
	public MvcboardVO selectByIdx(int idx) {
		logger.info("selectList()");
		
		String sql = "select * from mvcboard where idx = " + idx;
		return template.queryForObject(sql, new BeanPropertyRowMapper (MvcboardVO.class));
		
	}
	
	
	// UpdateService 클래스에서 호출되는 수정할 글번호와 데이터를 넘겨받고 
	// 글 1건을 수정하는 update sql 명령을 실행하는 메소드
	public void update(final int idx, final String subject, final String content) {
		logger.info("update(int idx, String subject, String content)");
		
		// String sql = "update mvcboard set subject = '" + subject + "', content = '" + content + "', where idx = " + idx;
		String sql = String.format("update mvcboard set subject = '%s', content = '%s', where idx = %d", subject, content, idx);
		template.update(sql);
		
	}

	
	// UpdateService 클래스에서 호출되는 수정할 글번호와 데이터가 저장된 객체를 넘겨받고 
	// 글 1건을 수정하는 update sql 명령을 실행하는 메소드
	public void update(final MvcboardVO mvcboardVO) {
		logger.info("update(MvcboardVO mvcboardVO)");
		
		// String sql = "update mvcboard set subject = '" + mvcboardVO.getSubject() + "', content = '" + mvcboardVO.getContent() + "', where idx = " + mvcboardVO.getIdx();
		String sql = String.format("update mvcboard set subject = '%s', content = '%s', where idx = %d", mvcboardVO.getSubject(), mvcboardVO.getContent(), mvcboardVO.getIdx());
		template.update(sql);
		
	}

	
	// DeleteService 클래스에서 호출되는 삭제할 글 번호를 넘겨받고
	// 글 1건을 삭제하는 delete sql 명령을 실행하는 메소드
	public void delete(int idx) {
		logger.info("delete()");
		
		String sql = "delete from mvcboard where idx = " + idx;
		template.update(sql);
	}

	
	// ReplyService 클래스에서 호출되는 글그룹과 글이 출력되는 순서가 저장된 HashMap 객체를 넘겨받고 
	// 조건에 만족하는 레코드의 seq를 1씩 증가시키는 update sql 명령을 실행하는 메소드 
	public void replyInsert(final HashMap<String, Integer> hmap) {
		logger.info("replyInsert()");
		
		//String sql = "update mvcboard set seq = seq + 1 where gup = " + hmap.get("gup") + " and seq >= " + hmap.get("seq");
		String sql = String.format("update mvcboard set seq = seq + 1 where gup = %d and seq >= %d", hmap.get("gup"), hmap.get("seq"));
		template.update(sql);
	}

	
	// ReplyService 클래스에서 호출되는 답글이 저장된 객체를 넘겨받고
	// 답글을 저장하는 insert sql 명령을 실행하는 메소드
	public void replyInsert(final MvcboardVO mvcboardVO) {
		logger.info("replyInsert()");
		
		String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) values(mvcboard_idx_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mvcboardVO.getName());
				ps.setString(2, mvcboardVO.getSubject());
				ps.setString(3, mvcboardVO.getContent());
				ps.setInt(4, mvcboardVO.getGup());
				ps.setInt(5, mvcboardVO.getLev());
				ps.setInt(6, mvcboardVO.getSeq());
				
			}
		});
	}

}

