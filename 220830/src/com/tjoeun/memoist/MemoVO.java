package com.tjoeun.memoist;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO { // 메모 1건을 기억하는 클래스
	
	// 자동증가를 위한 정적필드
	// 글번호 => 자동증가
	// 작성자 이름, 비밀번호, 메모, 작성일(컴퓨터 시스템의 날짜/시간으로 자동 설정)
	
	public static int count;
	private int idx;
	private String name;
	private String password;
	private String memo;
	private Date writeDate;
	
	public MemoVO() {
		
	}

	public MemoVO(String name, String password, String memo) {
		super();
		idx = ++count;
		this.name = name;
		this.password = password;
		this.memo = memo;
		writeDate = new Date();
		
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
	

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)"); // 날짜서식
		return String.format("%d. %s(%s)님이 %s에 남긴 글 \n%s", idx, name, password, sdf.format(writeDate), memo);
	}
	
	
	

	

}
