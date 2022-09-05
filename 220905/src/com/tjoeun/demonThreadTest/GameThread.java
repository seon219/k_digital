package com.tjoeun.demonThreadTest;

public class GameThread {

	public static void main(String[] args) {
		
		BGMThread bgmThread = new BGMThread();
		
		// demon 스레드는 다른 스레드가 모두 종료되면 같이 종료되는 스래드를 말한다.
		bgmThread.setDaemon(true);
			
				
		bgmThread.start();
				
		for(int i = 0; i < 10; i ++) {
			System.out.println("신나게 게임을하는 중....");
			
			if (i == 7) {
				System.out.println("앗... 엄마다...");
				System.out.println("엄마가  오셔서 게임을 중료합니다.");
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
