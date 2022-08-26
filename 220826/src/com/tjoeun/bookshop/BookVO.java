package com.tjoeun.bookshop;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

//VO(Value Object) 클래스 : 1건의 데이터와 데이터를 처리하는 메소드를 모아놓은 클래스
// VO 클래스는 DTO(Data Transfer Object) 클래스라고도 부른다
// bean: 처리할 데이터를 기억하는 변수와 변수에 데이터를 입출력할 수 있는 getters & setters 메소드로만 구성된 클래스
	
	
// 도서 정보 1건을 기억하는 클래스
// 도서명, 저자, 출판사, 출판일, 가격
public class BookVO {
	
	// 데이터를 기억할 멤버 변수(필드) 선언 => 클래스 내부에 선언되는 모든 메소드에서 사용할 수 있음
	// 전역(멤버)변수보다 지역변수가 우선권을 가짐
	// 일반 변수를 선언하면 변수에는 어떤값이 들어있는지 모르지만 클래스에서 선언하는 필드는 별도로 초기회하지 않아도
	// 숫자는 0, 문자는 공백, boolean은 false, 클래스로 만든 객체(참조변수)는 null로 자동 초기화
	
	private String title; // 도서명
	private String author; // 저자
	private String publisher; // 출판사
	private Date writeDate; // 출판일
	private double price; // 가격
	
	// 생성자 메소드를 선언
	// 생성자 이름은 반드시 클래스 이름과 같아야 함
	// 생성자를 선언하지 않으면 컴파일러가 자동으로 아무런 일도 하지 않은 생성자(기본생성자)를 만들어주고
	// 사용자가 생성자를 선언하지 않으면 기본 생성자를 자동으로 만들어주지 않는다.
	// 생성자는 리턴타입을 사용하지 않고 생성자 내부에서 return도 사용하지 않는다.
	// 생성자는 객체가 생성될 때 자동으로 실행되고 필드에 데이터 초기화를 목적으로 사용
	

	public BookVO() {
		System.out.println("기본 생성자가 실행됩니다.");
	}

	public BookVO(String title, String author, String publisher, Date writeDate, double price) {
		// super()는 생략해도 자바 컴파일러가 자동으로 붙여줌
		// super(); // 부모 클래스의 기본 생성자
		// this(); // 현제 클래스의 기본 생성자
		// super()와 this()는 반드시 생성자의 첫 문장으로 적어야 함 => 동시에 사용 불가
		// super는 부모 클래스를 의미하고 this는 현재 클래스를 의미
		
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		
		// 인수로 넘어온 writeDate에 저장된 날짜 데이터에서 1900을 빼서 다시 정리
		writeDate.setYear(writeDate.getYear() - 1900);
		writeDate.setMonth(writeDate.getMonth() - 1);
		this.writeDate = writeDate;
		
		
		this.price = price;
	}
	
	
	// getters & setters 메소드 선언
	// getters & setters 메소드는 private 권한으로 선언된 필드를 클래스 외부에서 접근할 수 있도록 예외규정을 만듬
	
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

	
	// 클래스 객체에 저장된 데이터를 보고싶다면 toString()메소드를 override(재정의)해야 함
	// @Override 어노테이션 이 메소드가 부모 클래스에서 상속받은 메소드를 @Override한 메소드임을 의미
	// @Override 어노테이션이 붙어닜는 메소드는 이름을 수정해서 상속받은 메소드 이름과 다르면 에러 발생
	@Override
	// toString() 메소드는 객체의 필드에 저장된 데이터 출력에 사용
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
		
		
		// 숫자 데이터 출력 서식
		// 1. NumberFormat 클래스로 숫자 출력 서식 지정하기 => 미리 제작되어 제공되는 서식만 사용가능
		// NumberFormat 클래스는 singleton 패턴으로 제작되어 있어 객체를 생성하지 못하고(new x) 제작되어 있는 서식을 얻어오는 메소드를 사용해서
		// 클래스 내부에 미리 작성되어있는 서식을 얻어와 사용
		//NumberFormat nf = NumberFormat.getNumberInstance(); // 천 단위 구분 기호
		//NumberFormat nf = NumberFormat.getCurrencyInstance(); // 통화 표시와 천 단위 구분기호
		//NumberFormat nf = NumberFormat.getPercentInstance(); // 백분율 표시, 자동으로 100이 곱해진다;.
		
		// 2. DecimalFormat 클래스로 숫자 출력 서식 지정하기 => 만들어서 사용
		// DecimalFormat df = new DecimalFormat("출력서식");
		// 출력 서식에는 "#,##0"을 입력하고 앞, 뒤로 서식에 필요한 문자를 직접 입력해서 만듬
		//DecimalFormat df = new DecimalFormat("#,##0"); // NumberFormat.getNumberInstance()
		//DecimalFormat df = new DecimalFormat("￦#,##0"); // NumberFormat.getCurrencyInstance()
		//DecimalFormat df = new DecimalFormat("#,##0%"); // NumberFormat.getPercentInstance()
		
		// 소수점 아래 자리수는 "."을 입력하고 보고싶은 만큼 0을 입력
		//DecimalFormat df = new DecimalFormat("$#,##0.00"); // NumberFormat.getPercentInstance()
		DecimalFormat df = new DecimalFormat("$#,##0원"); // NumberFormat.getPercentInstance()
		
	
		return "BookVO [title=" + title + ", author=" + author + ", publisher=" + publisher + ", writeDate=" + sdf.format(writeDate)
				+ ", price=" + df.format(price) + "]";
	}


	// 클래스 객체에 저장된 내용을 비교하려면 hashcode() 메소드와 equals() 메소드를 override 시킨다 
	
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
