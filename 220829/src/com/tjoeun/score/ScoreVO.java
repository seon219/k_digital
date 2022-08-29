package com.tjoeun.score; // 학생 1명의 성적을 기억하는 클래스

public class ScoreVO {

	// 일련번호 => 자동증가
	// 이름, java점수, jsp점수, spring점수, 총점, 평균, 석차
	
	
	// 정적(static) 멤버 변수(필드)는 현재 클래스로 생성되는 모든 객체에서 공유해서 사용
	// static을 붙여서 선언한 변수는 현재 클래스의 객체가 생성될 때 최초 1번만 메모리에 만들어짐
	// 현재 클래스의 객체가 또 생성되더라도 다시 생성하지 않음
	// static을 붙여서 선언한 변수나 메소드는 클래스 객체를 생성하지 않고 클래스 이름에 .을 찍어서 바로 접근 가능
	public static int count;
	
	// 인스턴스 멤버 변수(필드)
	// 인스턴스 필드는 현재 클래스로 생성되는 모든 객체에서 독립된 기억 공간을 가짐
	private int idx;
	private String name;
	private int java;
	private int jsp;
	private int spring;
	private int total;
	private double avg;
	private int rank = 1;
	
	
	public ScoreVO() { // 기본생성자
		// 이름의 null값 방지를 위해 ScoreVO(String name, int java, int jsp, int spring) 생성자 호출
		this("무명", 0, 0, 0);
	}


	// 이름과 3과목 점수를 넘겨받아 총점, 평균을 계산한 후 필드를 초기화 시키는 생성자
	public ScoreVO(String name, int java, int jsp, int spring) {
		super();
		idx = ++count;
		this.name = name;
		this.java = java;
		this.jsp = jsp;
		this.spring = spring;
		
		// 총점과 평균 계산
		total = java + jsp + spring;
		avg = (double) total / 3;
	}


	
	// getters & setters
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getJsp() {
		return jsp;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return String.format(" %d  %s  %3d  %3d  %3d   %3d %6.2f  %d", idx, name, java, jsp, spring, total, avg, rank);
	}
	
}
