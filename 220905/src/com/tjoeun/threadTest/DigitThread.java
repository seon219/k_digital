package com.tjoeun.threadTest;


// Thread 클래스를 상속받고 run() 메소드를 Override 해서 멀티 스레드를 구현
public class DigitThread extends Thread {

	@Override
	public void run() {
		// 1 ~ 26 을 0.2초 간격으로 출력
		for (int i = 1; i <= 26; i++) {
			System.out.print(i);                                                                                                                                             
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
