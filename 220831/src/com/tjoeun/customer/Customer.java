package com.tjoeun.customer;

// 일반고객 정보를 기억하는 클래스
public class Customer {

	private int id;
	private String name;
	private String grade;
	private int point;
	private double ratio; // 포인트 적립 비율
	
	public Customer() {
		grade = "SILVER";
		ratio = 0.01;
		
	}

	public Customer(int id, String name, String grade, int point, double ratio) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.point = point;
		this.ratio = ratio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	
	// 고객 정보를 출력하는 메소드
	public String showCustomerInfo() {
		return name + "님의 등급은 " + grade + "이며, 보너스 포인트는 " + point +"점 입니다.";
	}
	
	
	// 구매 금액을 인수로 넘겨받아 보너스 포인트를 계산해서 리턴하는 메소드
	public int calcBonus(int price) {
		return (int) (price * ratio);
	}
	
	
	// 구매 금액을 인수로 넘겨받아 누적 보너스 포인트를 계산해서 리턴하는 메소드
	public int calcPrice(int price) {
		//point += price * ratio;
		point += calcBonus(price);
		return point;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", grade=" + grade + ", point=" + point + ", ratio=" + ratio
				+ "]";
	}
	
	
	
}
