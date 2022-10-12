package com.tjoeun.useBean;

// VO(Value Object) 클래스 => 데이터 1건과 데이터를 처리하기 위한 메소드를 기억하는 클래스
// 데이터를 저장해서 전송한다 해서 DTO(Data Transfer Object)라 부르기도 한다.
// bean =>  자바로 처리하는 최소한의 작업 단위로 데이터를 기억하는 필드(멤버 변수)와 
//			필드에 저장된 데이터를 입출력하는 getter & setter 메소드로만 구성된 클래스

public class MemberVO {

	// 필드선언
	// VO 클래스의 필드 이름은 VO클래스에 저장될 데이터가 입력되는 form을 구성하는 요소들의
	// name 속성에 지정한 속성값과 데이터베이스 테이블을 구성하는 필드 이름과 반드시 같은 이름으로 만들어야 한다.
	private String name;
	private String id;
	private String password;
	private int age;
	private boolean gender;
	private String ip;
	
	// 생성자 선언
	public MemberVO() {}
	public MemberVO(String name, String id, String password, int age, boolean gender, String ip) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.ip = ip;
	}



	// getter & setter 선언
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	// toString() 메소드 Override
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", ip=" + ip + "]";
	}
	
	
	
}
