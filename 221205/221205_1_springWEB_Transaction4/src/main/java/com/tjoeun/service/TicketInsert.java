package com.tjoeun.service;

import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.tjoeun.dao.TransactionDAO;
import com.tjoeun.vo.CardVO;

public class TicketInsert implements TransactionService {

	private TransactionDAO dao;
//	트랜잭션을 2개 사용해야 하므로 TransactionTemplate 객체를 만든다. 외부 트랜잭션
	private TransactionTemplate transactionTemplate2;
	
	public TransactionDAO getDao() {
		return dao;
	}
	public void setDao(TransactionDAO dao) {
		this.dao = dao;
	}

	public TransactionTemplate getTransactionTemplate2() {
		return transactionTemplate2;
	}
	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}

	@Override
	public void execute(final CardVO cardVO) {
		
//		ticket.jsp 입력과 상관없이 트랜잭션을 실행한다.
//		외부 트랜잭션이 있을 때와 없을 때를 구분해서 실행시켜 보자
		
//		REQUIRED(DEFAULT, 0) <=> REQUIRED_NEW(3)
//		외부 트랜잭션이 존재한다면 외부 트랜잭션으로 합류하고 외부 트랜잭션이 없다면 새로운 트랜잭션을 생성한다.
//		중간에 롤백이 발생한다면 모두 하나의 트랜잭션이기 때문에 진행 상황이 모두 롤백된다.
//		REQUIRED_NEW
//		무조건 새로운 트랜잭션을 생성하고 각각의 트랜잭션이 롤백되더라도 서로 영향을 주지 않는다.
		
//		SUPPORTS(1) <=> NOT_SUPPORTS(4)
//		외부 트랜잭션이 있다면 합류하고 진행중인 외부 트랜잭션이 없다면 트랜잭션을 생성하지 않는다.
//		NOT_SUPPORTS
//		외부 트랜잭션이 있다면 보류시키고 진행 중인 외부 트랜잭션이 없다면 트랜잭션을 생성하지 않는다.
		
//		MANDATORY(2) <=> NEVER(5)
//		외부 트랜잭션에 무조건 합류한다. 만약 외부 트랜잭션이 없다면 예외를 발생시킨다.
//		NEVER
//		트랜잭션을 생성하지 않고 외부 트랜잭션이 존재한다면 예외를 발생시킨다.
		
//		propagationBehavior 속성 지정에 따라 트랜잭션 처리가 달라진다.
//		외부 트랜잭션(transactionTemplate2) 0, 내부 트랜잭션(transactionTemplate) 0이면 모두 적용된다.
//		외부 트랜잭션이 없고, 내부 트랜잭션이 0이면 내부 트랜잭션이 정상 처리된다.
//		외부 트랜잭션이 있고(0), 내부 트랜잭션이 1이면 모두 적용된다.
//		외부 트랜잭션이 없고, 내부 트랜잭션이 1이면 모두 적용되지 않는다.
//		외부 트랜잭션이 있고(0), 내부 트랜잭션이 2면 모두 적용된다.
//		외부 트랜잭션이 없고, 내부 트랜잭션이 2이면 IllegalTransactionStateException 예외가 발생된다.
		
//		외부 트랜잭션이 없을 경우
//		cardVO.setAmount("1");
//		dao.buyTicket(cardVO);
//		cardVO.setAmount("5");
//		dao.buyTicket(cardVO);
		
//		외부 트랜잭션이 있을 경우
		try {
			
			transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
//					cardVO.setAmount("1");
//					dao.buyTicket(cardVO);
//					cardVO.setAmount("5");
//					dao.buyTicket(cardVO);
					
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}













