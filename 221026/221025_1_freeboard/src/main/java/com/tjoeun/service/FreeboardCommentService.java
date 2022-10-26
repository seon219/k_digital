package com.tjoeun.service;

import java.awt.print.Printable;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.dao.FreeboardCommentDAO;
import com.tjoeun.mybatis.MySession;
import com.tjoeun.vo.FreeboardCommentVO;

public class FreeboardCommentService {

	private static FreeboardCommentService instance = new FreeboardCommentService();
	private FreeboardCommentService() { }
	public static FreeboardCommentService getinstance() {
		return instance;
	} 
	
	
	// commentOK.jsp에서 호출되는 댓글로 저장할 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후 
	//FreeboardCommentDAO 클래스의 댓글을 저장하는 insert sql 명령을 실행하는 메소드를 호출하는 메소드
	public boolean insertComment(FreeboardCommentVO co) {
		System.out.println("FreeboardCommentService의 insertComment()");
		SqlSession mapper = MySession.getSession();
		int result = FreeboardCommentDAO.getInstance().insertComment(mapper,co);
		System.out.println("result: " + result);			
		if (result == 1) {
			mapper.commit();
			mapper.close();
			return true;
		} else {
			mapper.close();
			return false;			
		}
	}
	
	
	// list.jsp에서 호출되는 메인글의 글번호를 넘겨받고 mapper를 얻어온 후 
	//FreeboardCommentDAO 클래스의 댓글의 개수를 얻어오는 select sql 명령을 실행하는 메소드를 호출하는 메소드
	public int commentCount(int idx) {
		System.out.println("FreeboardCommentService의 commentCount()");
		SqlSession mapper = MySession.getSession();
		
		int commentCount =  FreeboardCommentDAO.getInstance().commentCount(mapper, idx);
		
		mapper.commit();
		mapper.close();
		return commentCount;
	}
	
	
}
