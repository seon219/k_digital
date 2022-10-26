package com.tjoeun.dao;


import org.apache.ibatis.session.SqlSession;

import com.tjoeun.vo.FreeboardCommentVO;

public class FreeboardCommentDAO {

	private static FreeboardCommentDAO instance= new FreeboardCommentDAO();
	private FreeboardCommentDAO() { }
	public static FreeboardCommentDAO getInstance() {
		return instance;
	}
	
	
	
	// FreeboardCommentService 클래스에서 호출되는 mapper와 댓글 데이터가 저장된 객체를 넘겨받고
	// 댓글을 저장하는 freeboardcomment.xml 파일의 insert sql 명령을 실행하는 메소드
	public int insertComment(SqlSession mapper, FreeboardCommentVO co) {
		System.out.println("FreeboardCommentDAO의 insertComment()");
		// insert, delete, update sql 명령의 실행 결과를 리턴시키면 sql 명령이 성공적으로 실행된 횟수가 리턴된다.
		return mapper.insert("insertComment", co);
		
	}
	
	
	
	// FreeboardCommentService 클래스에서 호출되는 mapper와 메인글의 글번호를 넘겨받고
	// 댓글의 개수를 얻어오는 freeboardcomment.xml 파일의 select sql 명령을 실행하는 메소드
	public int commentCount(SqlSession mapper, int idx) {
		System.out.println("FreeboardCommentDAO의 commentCount()");
		return (int) mapper.selectOne("commentCount", idx);
	}

	
	
	
}
