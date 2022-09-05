package com.tjoeun.ThreadTerminate;

public class ThreadTerminate extends Thread {

	
	private boolean flag = true;
	
	public ThreadTerminate() { }
	public ThreadTerminate(String name) { 
		super(name);
	}
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	@Override
	public void run() {

		while(flag) {
			
			try {
//				Thread.sleep(1);
//				ThreadTerminate 클래스는 Thread 클래스를 상속받아서 Thread 클래스의 모든 가능을 갖추고 있으므로,
//				Thread 클래스의 매소드를 실행할 때 앞에 Thread 클래스를 쓰지 않아도 사용할 수 있다.
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " end");
		
	}

	
}
