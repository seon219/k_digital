package com.tjoeun.synchronizedMethodTest;

import java.util.ArrayList;

import com.tjoeun.syncronizedBlockTest.synchronizedBlockTest;

public class Library {

	ArrayList<String> booklist = new ArrayList<>();
	
	public Library() {
		booklist.add("다빈치 코드");
		booklist.add("천사와 악마");
		booklist.add("디지털 포트리스");
//		booklist.add("라스트 심볼");
//		booklist.add("다나토노트");
//		booklist.add("개미");	
	}

	
	// 도서 대여 메소드
	// 동기화 메소드 synchronized 예약어를 사용해서 선언
	// 메소드가 실행하는 모든 내용이 종료될 때까지 다른 스레드가 실행되지 않도록 함
	public synchronized String lendBook() {
		
		//currentThread() 메소드로 현재 스레드 정보를 얻어온다.
		Thread thread = Thread.currentThread();
		
		// 대여할 책이 없으면 책이 반납될 때 까지 스레드를 일시적으로 멈춘다.
		if (booklist.size() == 0) {
			try {
				System.out.println(thread.getName() + " 대기 시작");
				// returnBook() 메소드에서 notify()를 실행해서 스레드를 깨울 때까지 멈춘다.
				wait();
				System.out.println(thread.getName() + " 대기 종료");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 여기까지 왔으면 도서관에 대여할 책이 있다는 의미이므로 도서를 대여
		String book = booklist.remove(0);
		System.out.println(thread.getName() + ": " + book + " 대여");
		return book;
	}


	
	// 도서 반납 메소드
	public synchronized void returnBook(String book) {
		
		Thread thread = Thread.currentThread();
		
		// 반납된 도서를 도서관에 넣는다.
		booklist.add(book);
		// 도서관에 책이 없어서 일시적으로 멈춰있던 스레드를 깨운다.
		notify();
		//notifyAll();
		System.out.println(thread.getName() + ": " + book + " 반납");
		
	}

	
}
