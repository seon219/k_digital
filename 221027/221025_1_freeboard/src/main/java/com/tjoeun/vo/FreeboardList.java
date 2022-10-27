package com.tjoeun.vo;

import java.util.ArrayList;

// 1페이지 분량의 메인글 목록과 페이징 작업에 사용할 8개의 변수를 기억하는 클래스
public class FreeboardList {

	private ArrayList<FreeboardVO> list = new ArrayList<>();
	int pageSize = 10; // 1페이지에 표시할 글 개수
	int totalCount = 0; // 테이블에 저장된 전체 글 개수
	int totalPage = 0; // 전체 페이지 개수
	int currentPage = 1; // 현재 브라우저에 표시되는 페이지 번호
	int startNo = 0; // 현재 브라우저에 표시되는 글 목록의 시작 인덱스 번호
	int endNo = 0; // 현재 브라우저에 표시되는 글 목록의 마지막 인덱스 번호
	int startPage = 0; // 페이지 이동 버튼에 표시될 시작 페이지 번호
	int endPage = 0; // 페이지 이동 버튼에 표시될 마지막 페이지 번호
	
	
	public FreeboardList() { }
	public FreeboardList(int pageSize, int totalCount, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		
		calculator();
	}
	
	
	private void calculator() {
		totalPage = (totalCount - 1) / pageSize + 1;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
		
		// oracle은 select sql 명령 실행결과 인덱스 값이 1부터 시작되므로 1을 더해서 사용해야 한다. 
		startNo = (currentPage - 1) * pageSize + 1;
		endNo = startNo + pageSize - 1;
		endNo = endNo > totalCount ? totalCount : endNo;
		
		startPage = (currentPage - 1) / 10 * 10 + 1;
		endPage= startPage + 9;
		endPage = endPage > totalPage ? totalPage : endPage;
	}
	
	
	
	// ====================== getter & setter =====================================
	public ArrayList<FreeboardVO> getList() {return list;}
	public void setList(ArrayList<FreeboardVO> list) {this.list = list;}
	
	public int getPageSize() {return pageSize;}
	public void setPageSize(int pageSize) {this.pageSize = pageSize;}
	
	public int getTotalCount() {return totalCount;}
	public void setTotalCount(int totalCount) {this.totalCount = totalCount;}
	
	public int getTotalPage() {return totalPage;}
	public void setTotalPage(int totalPage) {this.totalPage = totalPage;}
	
	public int getCurrentPage() {return currentPage;}
	public void setCurrentPage(int currentPage) {this.currentPage = currentPage;}
	
	public int getStartNo() {return startNo;}
	public void setStartNo(int startNo) {this.startNo = startNo;}
	
	public int getEndNo() {return endNo;}
	public void setEndNo(int endNo) {this.endNo = endNo;}
	
	public int getStartPage() {return startPage;}
	public void setStartPage(int startPage) {this.startPage = startPage;}
	
	public int getEndPage() {return endPage;}
	public void setEndPage(int endPage) {this.endPage = endPage;}
	
	
	
	@Override
	public String toString() {
		return "FreeboardList [list=" + list + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
			
	
}
