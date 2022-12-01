package com.tjoeun.springWEB_DBCPTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class DAO {

	private JdbcTemplate template;
	
	public DAO() {
		template = Constant.template;
		System.out.println("여기는 다오 연결성공: " + template);
	}
}
