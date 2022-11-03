package com.tjoeun.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxInsert")
public class AjaxInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public AjaxInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		avtionDO(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		avtionDO(request, response);
	}

	protected void avtionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// index.jsp에서 입력한 데이터가 ajax를 통해서 넘어오는 데이터를 받는다.
		String name = request.getParameter("name").trim();
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email").trim();
		
		// 넘겨받은 데이터를 AjaxVO 클래스 객체에 저장
		AjaxVO vo = new AjaxVO(age, name, age, gender, email);
		
		// 넘겨받은 데이터를 테이블에 저장하는 메소드를 실행
		int result = new AjaxDAO().insert(vo);
		// write() 메소드는 인수로 문자열만 가질 수 있으므로 공백을 붙여서 문자열로 만들어 리턴
		response.getWriter().write(result + "");
	}
}
