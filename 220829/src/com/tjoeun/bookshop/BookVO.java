package com.tjoeun.bookshop; // 도서 정보 1권을 기억하는 클래스

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class BookVO {
	
	private String title; // 도서명
	private String author; // 저자
	private String publisher; // 출판사
	private Date writeDate; // 출판일
	private double price; // 가격
	
	

	public BookVO() { // 기본생성자 초기화
		this("없음", "누구", "글쎄", new Date(), 0);
		System.out.println("기본 생성자가 실행됩니다.");
	}

	public BookVO(String title, String author, String publisher, Date writeDate, double price) {
		
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		
		writeDate.setYear(writeDate.getYear() - 1900);
		writeDate.setMonth(writeDate.getMonth() - 1);
		this.writeDate = writeDate;
		
		
		this.price = price;
	}
	
	
	// getters & setters 메소드 선언
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)"); // 날짜서식
		DecimalFormat df = new DecimalFormat("$#,##0원"); // 숫자서식
		
		return String.format("%s, %s, %s, %s, %S", title, author, publisher, sdf.format(writeDate), df.format(price));
		
	}

	
	@Override
	// 저장된 데이터가 같으면 같은 hashcode를 만들어줌
	public int hashCode() {
		return Objects.hash(author, price, publisher, title, writeDate);
	}

	@Override
	// 객체의 필드에 저장된 실제 데이터끼리 비교할 수 있도록 만들어 준 것 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		return Objects.equals(author, other.author)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title)
				&& Objects.equals(writeDate, other.writeDate);
	}
	
}
