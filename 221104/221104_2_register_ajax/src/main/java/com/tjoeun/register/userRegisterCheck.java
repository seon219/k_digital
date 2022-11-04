package com.tjoeun.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userRegisterCheck")
public class userRegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public userRegisterCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userRegister 서블릿 get 방식");
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userRegister 서블릿 post 방식");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("userRegister 서블릿 actionDo 방식");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userid = request.getParameter("userid").trim();
		// System.out.println(userid);
		
		// 가입하려는 아이디가 테이블에 존재하는가 판단하는 메소드를 실행한다.
		int result = new RegisterDAO().registerCheck(userid);
		response.getWriter().write(result + "");
		
	}
}
