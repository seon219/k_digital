package com.tjoeun.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.tjoeun.vo.CategoryVO;

public class CategoryDAO {

	private static CategoryDAO instance = new CategoryDAO();
	private CategoryDAO() { }
	public static CategoryDAO getInstance() {
		return instance;
	}
	
	
	// CategortService 클래스에서 호출되는 mapper와 테이블에 저장할 메인 카테고리가 저장된 객체를 넘겨받고
	// 테이블에 메인 카테고리를 저장하는 category.xml 파일의 insert sql 명령을 실행하는 메소드
	public void insert(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO의 insert() 메소드");
		mapper.insert("insert", vo);
		
	}
	
	
	// CategortService 클래스에서 호출되는 mapper를 넘겨받고 테이블에 저장된 전체 카테고리 목록을 얻어오는
	// category.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<CategoryVO> selectList(SqlSession mapper) {
		System.out.println("CategoryDAO의 selectList() 메소드");
		// selectOne() : ibatis의 queryForObject() 메소드와 같은 기능 실행
		// selectList() : ibatis의 queryForList() 메소드와 같은 기능 실행
		return (ArrayList<CategoryVO>) mapper.selectList("selectList");
	}
	
	
	
	// CategortService 클래스에서 호출되는 mapper와 gup와 seq가 저장된 HashMap 객체를 넘겨받고
	// 같은 카테고리 그룹(gup)에서 조건에 만족하는 카테고리 출력 순서를 조정하기 위해
	// seq를 1씩 증가시키는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void increment(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("CategoryDAO의 increment() 메소드");
		mapper.update("increment", hmap);
		
	}
	
	
	// CategortService 클래스에서 호출되는 mapper와 테이블에 저장할 서브 카테고리가 저장된 객체를 넘겨받고
	// 테이블에 서브 카테고리를 저장하는 category.xml 파일의 insert sql 명령을 실행하는 메소드
	public void reply(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO의 reply() 메소드");
		mapper.insert("reply", vo);
		
	}
	

	// CategoryService 클래스에서 호출되는 mapper와 카테고리 번호를 넘겨받고 카테고리 1건을 얻어오는
	// category.xml 파일의 select sql 명령을 실행하는 메소드
	public CategoryVO selectByIdx(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO의 selectByIdx() 메소드");
		return (CategoryVO) mapper.selectOne("selectByIdx", idx);
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 삭제할 카테고리 번호를 넘겨받고 
	// 카테고리 1건을 삭제하는 category.xml 파일의 delete sql 명령을 실행하는 메소드
	public void delete(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO의 delete() 메소드");
		mapper.delete("delete", idx);
		
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 삭제할 카테고리 번호를 넘겨받고 
	// 카테고리 1건을 "삭제된 카테고리입니다."로 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void deleteCategory(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO의 deleteCategory() 메소드");
		mapper.update("deleteCategory", idx);
		
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 삭제할 카테고리 번호를 넘겨받고 
	// 카테고리 1건의 deleteCheck를 "YES"로 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드	
	public void deleteCheck(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO의 deleteCheck() 메소드");
		mapper.update("deleteCheck", idx);
		
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 복구할 카테고리 번호를 넘겨받고 
	// 카테고리 1건의 deleteCheck를 "NO"로 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드	
	public void restoreCheck(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO의 restoreCheck() 메소드");
		mapper.update("restoreCheck", idx);
		
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 수정할 카테고리 정보가 저장된 객체를 넘겨받고 
	// 카테고리 1건을 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void update(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO의 update() 메소드");
		mapper.update("update", vo);
		
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 신고횟수를 1증가시킬 카테고리 번호를 넘겨받고 
	// 카테고리 1건의 deleteReport 필드를 1 증가시키는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void report(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO의 report() 메소드");
		mapper.update("report", idx);
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 삭제할 카테고리 정보가 저장된 객체를 넘겨받고 
	// 삭제할 카테고리 목록을 얻어오는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public ArrayList<CategoryVO> deleteList(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO의 deleteList() 메소드");
		return (ArrayList<CategoryVO>) mapper.selectList("deleteList", vo);
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 seq를 다시 부여할 카테고리 그룹을 넘겨받고
	// 삭제한 카테고리 그룹에 해당되는 카테고리 목록을 얻어오는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public ArrayList<CategoryVO> selectGup(SqlSession mapper, int gup) {
		System.out.println("CategoryDAO의 selectGup() 메소드");
		return (ArrayList<CategoryVO>) mapper.selectList("selectGup", gup);
	}
	
	
	// CategoryService 클래스에서 호출되는 mapper와 seq를 수정할 카테고리 일련번호와 수정할 데이터가 저장된
	// HashMap 객체를 넘겨받고 seq를 수정하는 category.xml 파일의 update sql 명령을 실행하는 메소드
	public void reSeq(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("CategoryDAO의 reSeq() 메소드");
		mapper.update("reSeq", hmap);
	}
	
}
