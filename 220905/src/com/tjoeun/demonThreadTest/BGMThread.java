package com.tjoeun.demonThreadTest;

public class BGMThread extends Thread {

		@Override
		public void run() {
			while(true) {
				System.out.println("배경 음악이 연주되는 중...");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
}
