package com.tjoeun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.tjoeun.vo.CardVO;

public class TransactionDAO {

	private static final Logger logger = LoggerFactory.getLogger(TransactionDAO.class);
	
//	JdbcTemplate 객체 선언
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void buyTicket(final CardVO cardVO) {
		logger.info("TransactionDAO 클래스의 ticketCard() 메소드 실행");
		logger.info("consumerId: {}", cardVO.getConsumerId());
		logger.info("amount: {}", cardVO.getAmount());

		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into card (consumerid, amount) values (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cardVO.getConsumerId());
				pstmt.setString(2, cardVO.getAmount());
				return pstmt;
			}
		});
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into ticket (consumerid, countnum) values (?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cardVO.getConsumerId());
				pstmt.setString(2, cardVO.getAmount());
				return pstmt;
			}
		});
		
	}
	
}












