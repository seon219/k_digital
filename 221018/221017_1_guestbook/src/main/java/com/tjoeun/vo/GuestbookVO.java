package com.tjoeun.vo;

import java.util.Date;

// BO(Value Object): 데이터 1건을 기억하는 클래스 => 게시글 1건 => DTO(Date Transfer Object)
public class GuestbookVO {
	
	// 필드 이름은 데이터베이스 필드 이름, html form을 구성하는 요소들의 name 속성값과 같게 만들어야 한다.
	private int idx;
	private String name;
	private String password;
	private String memo;
	private Date writeDate;
	private String ip;
	
	
	public GuestbookVO() {}	
	public GuestbookVO(int idx, String name, String password, String memo, Date writeDate, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.password = password;
		this.memo = memo;
		this.writeDate = writeDate;
		this.ip = ip;
	}
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@Override
	public String toString() {
		return "GuestbookVO [idx=" + idx + ", name=" + name + ", password=" + password + ", memo=" + memo
				+ ", writeDate=" + writeDate + ", ip=" + ip + "]";
	}
	
	
}
