package com.tjoeun.service;

import java.sql.SQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.tjoeun.dao.GuestbookDAO;
import com.tjoeun.ibatis.MyAppSqlConfig;
import com.tjoeun.vo.GuestbookVO;

public class updateService {

		private static updateService instance = new updateService();
		private updateService() { }
		public static updateService getinstance() {
			return instance;
		}
		
		
		// updateOK.jsp에서 호출되는 수정할 정보가 저장된 객체를 넘겨받고 mapper를 얻어온 후 GuestbookDAO 클래스의 
		// 글 1건을 수정하는 update sql 명령을 실행하는 메소드를 호출하는 메소드
		public void update(GuestbookVO vo) {
			System.out.println("updateService의 update() 메소드 실행");
			SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
			
			try {
				GuestbookDAO.getinstance().update(mapper, vo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
}
