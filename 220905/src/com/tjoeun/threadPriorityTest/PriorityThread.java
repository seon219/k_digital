package com.tjoeun.threadPriorityTest;

public class PriorityThread extends Thread {

	public PriorityThread() { }
	public PriorityThread(String name) { 
		// 스레드 이름을 지정하려면 스레드 이름을 넘겨받는 생성자를 만들고 Thread(부모) 클래스의 생성자를 호출해서 넣어줘야 함
		super(name);
	}
	
	@Override
	public void run() {
		
		int sum = 0;
		
		Thread thread = Thread.currentThread();
		// setName() 메소드로 스레드 이름을 지정할 수 있다.
		//thread.setName("스래드 이름이 같아진다.);
//		System.out.println(thread + " start");
		

		for (int i = 1; i <= 1000000; i++) {
			sum += i;
		}
		
		
		// getName() 메서드로 스레드 이름을 얻어올 수 있다.
		// getPriority() 메소드로 스레드의 우선 순위를 얻어올 수 있다.
		System.out.println(thread.getName() + " 우선순위:" + thread.getPriority());
	}

	
	
	
}
