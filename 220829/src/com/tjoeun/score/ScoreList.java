package com.tjoeun.score;

import java.util.ArrayList;

public class ScoreList { // 여러 학생의 성적을 기억하는 클래스

	private ArrayList<ScoreVO> scorelist = new ArrayList<>();

	
	public ArrayList<ScoreVO> getScorelist() {
		return scorelist;
	}

	public void setScorelist(ArrayList<ScoreVO> scorelist) {
		this.scorelist = scorelist;
	}

	@Override
	public String toString() {
		String str = "";
		str += "==================================================== \n";
		str += "번호 이름  java  jsp spring 총점  평균 석차 \n";
		str += "==================================================== \n";
		
	
		for (int i = 0; i < scorelist.size()-1; i++) {
			for (int j = i + 1; j < scorelist.size(); j++) {
				if (scorelist.get(i).getTotal() < scorelist.get(j).getTotal()) {
					scorelist.get(i).setRank(scorelist.get(i).getRank() + 1);
				} else if (scorelist.get(i).getTotal() > scorelist.get(j).getTotal()) {
					scorelist.get(j).setRank(scorelist.get(j).getRank() + 1);
				}
			}
			
		}
		
		for (ScoreVO vo : scorelist ) { // 향상된 for
			str += vo + "\n";
		}
		str += "==================================================== \n";
		return str;
	}
	
	
	public void addScore(ScoreVO score) {
		scorelist.add(score);
	}
	
}
