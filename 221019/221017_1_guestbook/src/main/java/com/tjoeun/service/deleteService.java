package com.tjoeun.service;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.tjoeun.dao.GuestbookDAO;
import com.tjoeun.ibatis.MyAppSqlConfig;

public class deleteService {

		private static deleteService instance = new deleteService();
		private deleteService() { }
		public static deleteService getinstance() {
			return instance;
		}
		
		
		// deleteOK.jsp에서 호출되는 삭제할 글번호를 넘겨받고 mapper를 얻어온 후 GuestbookDAO 클래스의 
		// 글 1건을 삭제하는 delete sql 명령을 실행하는 메소드를 호출하는 메소드
		public void delete(int idx) {
			System.out.println("deleteService의 delete() 메소드 실행");
			SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();
			
			try {
				GuestbookDAO.getinstance().delete(mapper, idx);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
}
