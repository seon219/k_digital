package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BookList {

	// 도서 정보를 기억할 ArratList를 만든다.
	private ArrayList<BookVO> booklist = new ArrayList<>();
	
	
	// 생성자를 선언하지 않았으므로 자바 컴파일러가 아무런 일도 하지 않는 기본 생성자를 만들어줌
	// 보이지는 않지만 기본생성자 생성됨
	
	
	// getter & setter 만들기
	public ArrayList<BookVO> getBooklist() {
		return booklist;
	}
	
	public void setBooklist(ArrayList<BookVO> booklist) {
		this.booklist = booklist;
	}
	

	
	@Override
	public String toString() {
		
		// 줄 바꾸기
		String str = "";
		str += "==================================================== \n";
		str += "도서명  저자     출판사        출판일         가격 \n";
		str += "==================================================== \n";
		
		double sum = 0.0;
		
/*		for (int i = 0; i < booklist.size(); i++) {
 * 			str += booklist.get(i) + "\n";
 * 			sum += booklist.get(i).getPrice();
 * 		}
 */

		for (BookVO vo : booklist) { // 향상된 for

			str += vo + "\n";
			sum += vo.getPrice();
		}
		
		DecimalFormat df = new DecimalFormat("#,##0원");
			
		
		str += "==================================================== \n";
		str += " 합계 금액: " + df.format(sum) + "\n" ;
		str += "==================================================== \n";
		return str;
	}


	
	// BookList 클래스의 booklist ArrayList에 인수로 넘겨받은 도서 정보를 저장하는 메소드
	public void addBook(BookVO book) {
		booklist.add(book);			
		
	}
	
	
	
	
	
	
	
	
	

}
