package com.tjoeun.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userRegister")
public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public userRegister() {
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
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userid = request.getParameter("userid").trim();
		String userpassword1 = request.getParameter("userpassword1").trim();
		String userpassword2 = request.getParameter("userpassword2").trim();
		String username = request.getParameter("username").trim();
		String userage = request.getParameter("userage").trim();
		String usergender = request.getParameter("usergender").trim();
		String useremail = request.getParameter("useremail").trim();
		
		// 입력 체크
		if (userid == null || userid.equals("") || 
			userpassword1 == null || userpassword1.equals("")||
			userpassword2 == null || userpassword2.equals("")||
			username == null || username.equals("")||
			userage == null || userage.equals("")||
			usergender == null || usergender.equals("")||
			useremail == null || useremail.equals("")) {
			
			// 입력 체크 실패시 메시지를 session에 저장
			// getsessoin(): 서블릿에서 session을 얻어온다.
			request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요"); // ①
			response.sendRedirect("index.jsp"); // ①
			return; // 입력 데이터에 오류가 있으므로 서블릿을 종료
		}
		
		// 비밀번호 체크
		if (!userpassword1.equals(userpassword2)) {
			// 비밀번호 불일치 메시지를 session에 저장
			request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			request.getSession().setAttribute("messageContent", "비밀번호가 일치하지 않습니다."); // ①
			response.sendRedirect("index.jsp"); // ①
			
			return; // 비밀번호가 일치하지 않으므로 서블릿을 종료
		}
		
		
		// 넘어온 데이터가 정상이므로 RegisterVO 클래스 객체를 만들어 저장
		RegisterVO vo = new RegisterVO(userid, userpassword2, username, Integer.parseInt(userage), usergender, useremail);
		//System.out.println(vo);
		
		
		// 테이블에 회원 정보를 저장하는 메소드 실행
		int result = new ReigsterDAO().insert(vo);
		System.out.println(result);
		
		// 저장 체크
		if (result == 1) {
			// insert sql 명령이 정상적으로 실행되었을 때 메시지를 session에 저장
			request.getSession().setAttribute("messageType", "성공 메시지"); // ①
			request.getSession().setAttribute("messageContent", "회원가입에 성공했습니다."); // ①
		} else {
			// insert sql 명령이 정상적으로 실행되지 않았을 때 메시지를 session에 저장
			request.getSession().setAttribute("messageType", "오류 메시지"); // ①
			request.getSession().setAttribute("messageContent", "이미 존재하는 아이디입니다."); // ①
		}
		response.sendRedirect("index.jsp"); // ①
		
	}
	

}
