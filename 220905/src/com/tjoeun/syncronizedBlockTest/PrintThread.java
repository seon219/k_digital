package com.tjoeun.syncronizedBlockTest;

// 잔액 출력 스레드
public class PrintThread extends Thread{

	ShareArea shareArea;
	
	public PrintThread() { }
	public PrintThread(ShareArea shareArea) {
		super();
		this.shareArea = shareArea;
	}
	
	
	public ShareArea getShareArea() {
		return shareArea;
	}
	public void setShareArea(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	
	@Override
	public void run() {
		
		synchronized (shareArea) {
			
			for (int i = 0; i < 3; i++) {
				int sum = shareArea.lee.money + shareArea.hong.money;
				System.out.println("예금 합계: " + sum);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	
	
}
