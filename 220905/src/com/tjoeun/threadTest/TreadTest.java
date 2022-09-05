package com.tjoeun.threadTest;

public class TreadTest {

	public static void main(String[] args) {
		
//		<< Thread 클래스를 상속받아 작성된 멀티 스레드 실행 방법>>
//		1. Thread 클래스를 상속방아 멀티 스레드를 작성한 클래스 객체를 만든다.
		DigitThread digit = new DigitThread();
//		2. Thread 클래스를 상속받아 작성된 클래스 객체에서 start() 메소드로 멀티 스레드를 실행
		// digit.run(); // run() 메소드를 Override 했다고 해서 run() 메소드를 실행하면 run()이라는 일반 메소드가 실행
		// 멀티 스레드로 실행하려면 반드시 start() 메소드를 사용해서 실행
		digit.start();
		
//		위의 주석으로 처리하지 않은 2개의 문장은 아래와 같이 1문장으로 사용할 수 있다.
//		new DigitThread().start();	
		
		
//		<< Runnable 인터페이스를 구현받아 작성된 멀티 스레드 실행 방법>>
//		1. Runnable 인터페이스를 구현받아 멀티 스레드를 작성한 클래스 객체를 만든다.
		AlphaThread alpha = new AlphaThread();
//		2. Runnable 인터페이스는 스레드를 실제로 실행하는 기능이 없으므로 스레드를 실행하기 위해서 Thread 크래스를 이용
		// Thread 클래스의 객체를 생성할 때 생성자의 인수로 Runnable 인터페이스를 구현받아 멀티 스레드를 작성한 클래스의 객체를 넘겨준다.
		Thread thread = new Thread();
//		3. Thread 클래스 객체에서 start() 메소드로 멀티 스레드 실행
		thread.start();
			
//		주석으로 처리하지 않은 3개의 문장을 아래와같이 1문장으로 줄여서 사용할 수 있다.
//		new Thread(new AlphaThread()).start();
		
		
		// 'A' == 'Z'를 0.2초 간격으로 
//		for (int i = 0; i < 26; i++) {
//			System.out.print((char) (i + 65));                                                                                                                                             
//		}
		
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);  
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
