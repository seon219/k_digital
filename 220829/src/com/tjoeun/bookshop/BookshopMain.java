package com.tjoeun.bookshop;

import java.util.Date;

public class BookshopMain {

	public static void main(String[] args) {
 
		BookVO book1 = new BookVO("java", "홍길동", "더조은출판사", new Date(2022, 7, 25), 1029.99);
		BookVO book2 = new BookVO("java", "홍길자", "더조은출판사", new Date(2022, 7, 25), 1029.99);
		BookVO book3 = new BookVO("java", "홍길숙", "더조은출판사", new Date(2022, 7, 25), 1029.99);
		BookVO book4 = new BookVO("java", "홍길희", "더조은출판사", new Date(2022, 7, 25), 1029.99);
		BookVO book5 = new BookVO("java", "홍길도", "더조은출판사", new Date(2022, 7, 25), 1029.99);
		BookVO book6 = new BookVO("java", "홍길자", "더조은출판사", new Date(2022, 7, 25), 1029.99);
		
		
		BookList booklist = new BookList();

		booklist.addBook(book1);
		booklist.addBook(book2);
		booklist.addBook(book3);
		booklist.addBook(book4);
		booklist.addBook(book5);
		booklist.addBook(book6);
		
		System.out.println(booklist);
	}

}
