package com.tjoeun.syncronizedBlockTest;

// 입출금을 실행하는 스레드와 잔액을 출력하는 스레드가 공유해서 사용할 클래스
public class ShareArea {
	
	Account lee = new Account("1111-11-11111", "이몽룡", 10000000);
	Account hong = new Account("2222-22-22222", "홍길동", 10000000);

}
