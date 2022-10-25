package com.tjoeun.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.vo.FreeboardVO;

public class FreeboardDAO {

	private static FreeboardDAO instance= new FreeboardDAO();
	private FreeboardDAO() { }
	public static FreeboardDAO getInstance() {
		return instance;
	}
	
	
	
	// FreeboardService 클래스에서 호출되는 mapper와 메인글이 저장된 객체를 넘겨받고
	// freeboard.xml 파일의 insert sql 명령을 실행하는 메소드
	public void insert(SqlSession mapper, FreeboardVO vo) {
		System.out.println("FreeboardDAO의 insert() 메소드 실행");
		mapper.insert("insert", vo);	
	}
	
	
	// FreeboardService 클래스에서 호출되는 mapper를 넘겨받고 전체 메인글의 개수를 얻어오는
	// freeboard.xml 파일의 insert sql 명령을 실행하는 메소드
	public int selectCount(SqlSession mapper) {
		System.out.println("FreeboardDAO의 selectCount() 메소드 실행");
		return (int) mapper.selectOne("selectCount");	
	}
	
	
	public ArrayList<FreeboardVO> selectList(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("FreeboardDAO의 selectList() 메소드 실행");
		return (ArrayList<FreeboardVO>) mapper.selectList("selectList", hmap);
	}
	
	
	// FreeboardService 클래스에서 호출되는 mapper와 조회수를 증가시킬 글번호를 넘겨받고 
	// 조회수를 증가시키는 freeboard.xml 파일의 insert sql 명령을 실행하는 메소드
	public void increment(SqlSession mapper, int idx) {
		System.out.println("FreeboardDAO의 increment() 메소드 실행");
		mapper.insert("increment", idx);
	}
	
	
	// FreeboardService 클래스에서 호출되는 mapper와 조회수를 증가시킨 메인글의 글번호를 넘겨받고 
	// 조회수를 증가시키긴 글 1건을 얻어오는 freeboard.xml 파일의 insert sql 명령을 실행하는 메소드
	public FreeboardVO selectByIdx(SqlSession mapper, int idx) {
		System.out.println("FreeboardDAO의 selectByIdx() 메소드 실행");
		return (FreeboardVO) mapper.selectOne("selectByIdx", idx);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
