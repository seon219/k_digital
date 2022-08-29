package com.tjoeun.score;

public class ScoreMain {

	
	public static void main(String[] args) {
/*		
		ScoreVO score1 = new ScoreVO();
		ScoreVO score2 = new ScoreVO();
		ScoreVO score3 = new ScoreVO();

		System.out.println("score1.count: " + score1.count); // 0
		score2.count = 100; 
		System.out.println("score2.count: " + score2.count); // 100
		
		// static 변수는 현재 클래스로 생성하는 모든 객체에서 공유하므로 score3과 score1의 count도 수정됨
		System.out.println("score3.count: " + score3.count); // 100
		System.out.println("score1.count: " + score1.count); // 100
		System.out.println("ScoreVO.count: " + ScoreVO.count); // 100
 */
		
		
		ScoreVO score1 = new ScoreVO("홍길동", 100, 100, 90);
		ScoreVO score2 = new ScoreVO("임꺽정", 70, 100, 90);
		ScoreVO score3 = new ScoreVO("장길산", 90, 100, 100);
		ScoreVO score4 = new ScoreVO("일지매", 100, 100, 100);
		ScoreVO score5 = new ScoreVO("손오공", 100, 85, 90);
	

//		System.out.println(score1);
//		System.out.println(score2);
//		System.out.println(score3);
//		System.out.println(score4);
//		System.out.println(score5);
		
		
		ScoreList scorelist = new ScoreList();
		
		scorelist.addScore(score1);
		scorelist.addScore(score2);
		scorelist.addScore(score3);
		scorelist.addScore(score4);
		scorelist.addScore(score5);
		
		System.out.println(scorelist);
	}

}
