package com.tjoeun.bookshop.copy;

import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JOptionPane;

// 여러권의 책 정보(BookVO 클래스)를 기억하는 클래스
public class BookList {
	
//	1. 필드선언
	private BookVO[] booklist; // 여러권의 책 정보를 기억할 배열 선언. null로 초기화된다.
	// BookVO가 자료형
	private int size; // 배열의 크기
	private int index; // 배열의 인덱스, 배열에 저장된 데이터의 개수를 기억하는 역할	
	
	
	
//	2. 생성자 선언
	// 기본 생성자로 객체를 생성하면 10권의 책 정보를 기억할 수 있는 배열 만들고
	// 배열의 크기를 넘겨받는 생성자가 실행되면 인수로 넘겨받은 크기만큼 크기를 가지는 배열
	
	public BookList() { // 기본 생성자
		// 10권의 책 정보를 기억할 수 있는 배열 만들기
//		size = 10;
//		booklist = new BookVO[size];
		// = 같음
		this(10); //BookList(int size) 생성자를 호출
	}


	public BookList(int size) { // 배열의 사이즈를 넘겨받는 생성자
		// 생성자의 인수로 넘겨받은 size개 만큼의 책 정보를 기억할 수 있는 배열을 만든다.
		super();
		
		this.size = size;
		booklist = new BookVO[size];
	}


	
//	3. getters & setters 선언
	public BookVO[] getBooklist() {
		return booklist;
	}


	public void setBooklist(BookVO[] booklist) {
		this.booklist = booklist;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	
//	4. toStirg() 메소드 override
	@Override
	public String toString() {
		//return "BookList [booklist=" + Arrays.toString(booklist) + "]";
		
		// 줄 바꾸기
		String str = "";
		str += "==================================================== \n";
		str += "도서명  저자     출판사         출판일         가격 \n";
		str += "==================================================== \n";
		
		double sum = 0.0;
		
/*		// 일반 for
		for(int i = 0; i < booklist.length; i++) { 
			
			if (booklist[i] == null) {
				break;
			}
			
			str += booklist[i] + "\n";
			sum += booklist[i].getPrice();
		}	
*/
		
		// 향상된 for : 전체 대상으로 (자료형 변수명 : 배열이름)
		for (BookVO vo : booklist) {
			if (vo == null) {
				break;
			}
			str += vo + "\n";
			sum += vo.getPrice();
		}
		
		DecimalFormat df = new DecimalFormat("#,##0원");
		
		
		
		
		
		
		str += "==================================================== \n";
		str += " 합계 금액: " + df.format(sum) + "\n" ;
		str += "==================================================== \n";
		return str;
	}


	
	
//	책 정보를 BookList 클래스의 booklist 배열에 저장하는 메소드 생성
	// BookList 클래스의 booklist 배열에 인수로 넘겨받은 도서 정보를 저장하는 메소드
	public void addBook(BookVO book) {
/*
		// if를 사용하는 전통적인 예외 처리 => 배열의 인덱스는 배열의 크기보다 작아야 함
		if (index < size) {
			booklist[index++] = book;			
		} else {
			System.out.println("배열이 가득차서 도서 정보를 저장할 수 없습니다.");
			JOptionPane.showMessageDialog(null, "배열이 가득차서 도서 정보를 저장할 수 없습니다.");
		}
*/
		
		// 책 ch.11 예외처리
		// 자바의 예외(Exception)처리 => try ~ catch (~ finally)
		// 예외가 발생될 것으로 예상되는 문장을 try블록에 코딩
		// 예외가 발생되면 처리할 문장을 catch(처리할예외이름 변수이름) 블록에 코딩
		// try 블록의 문장을 실행하다가 예외가 발생되면 더 이상 try 블록의 문장을 실행하지 않고 해당 예외의 catch 블록의 문장을 실행
		
		// 예외 발생여부와 상관없이 실행해야 할 문장이 있다면 finally 사용
		
		try {
			booklist[index++] = book;
			int i = 10 / 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열이 가득차서 도서 정보를 저장할 수 없습니다.");
			
			// getMessage(): 예외 메시지를 얻어옴
			// System.out.println(e.getMessage());
			// printStackTrace(): 예외 메시지를 출력하고 예외가 발생된 문장을 실행된 역순으로 추적
			// e.printStackTrace();
			
		} catch (ArithmeticException e) {
			// System.out.println("나눗셈은 0으로 할 수 없습니다."); 
			// 비어 있으면 예외 무시
			
		} catch (Exception e) { 
			
			// 예외를 처리하는 클래스는 모두 Exception 클래스를 상속받아 만들어졌기 때문에
			// catch 블록에 Exception 클래스를 사용하면 모든 예외 처리 가능
			// Exception 클래스를 사용하려면 반드시 맨 마지막 catch 블록으로 사용해야 함
			System.out.println("무언가 예외가 발생했습니다.");
			
		} finally {
			// System.out.println(":>");
		}
		
		
	}
	
	
	
	
	
	
	
	
	

}
