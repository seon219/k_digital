package com.tjoeun.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.tjoeun.vo.GuestbookVO;

public class GuestbookDAO {
	
	// singleton 패턴
	private static GuestbookDAO instance = new GuestbookDAO();
	private GuestbookDAO() {}
	public static GuestbookDAO getinstance() {
		return instance;
	}
	
	
	// InsertService 클래스에서 호출되는 mapper와 테이블에 저장할 데이터가 저장된 객체를 넘겨받고,
	// gueestbook.xml 파일의 insert sql 명령을 실행하는 메소드
	public void insert(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
		System.out.println("InsertService의 insert() 메소드 실행");
		System.out.println(vo);
		
		
		// mapper.insert("실행할 sql 명령의 id", sql 명령으로 전달할 데이터)
		mapper.insert("insert", vo);
	}
	
	
	// selectService 클래스에서 호출되는 mapper를 넘겨받고 guestbook.xml 파일의 테이블에 저장된
	// 전체 글을 개수를 얻어오는 select sql 명령을 실행한는 메소드
	public int selectCount(SqlMapClient mapper) throws SQLException {
		System.out.println("GuestbookDAO의 selectCount() 메소드 실행");
		
		// queryForObject(): select sql 명령의 실행 결과가 1건일 때 사용 => 결과를 object 타입으로 리턴
		// queryForList(): select sql 명령의 실행결과가 목록일 때 사용 => 결과를 list 인터페이스 타입으로 리턴
		return (int) mapper.queryForObject("selectCount");
	}
	
	
	// selectService 클래스에서 호출되는 mapper화면에 표시할 페이지의 시작 인덱스 번호와 끝 인덱스 번호가 저장된 HashMap 객체를 넘겨받고,
	// guestbook.xml 파일의 1페이지 분량의 글 목록을 얻어오는 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectList(SqlMapClient mapper, HashMap<String, Integer> hmap) throws SQLException {
		System.out.println("GuestbookDAO의 selectList() 메소드 실행");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectList", hmap);
	}
}
