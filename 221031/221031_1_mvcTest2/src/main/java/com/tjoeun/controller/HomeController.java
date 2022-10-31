package com.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet 어노테이션에 특정 요청을 써주면 그 용청이 들어왔을 때 컨트롤러의 메소드가 실행
// @WebServlet 어노테이션에 특정 요청이 들어왔을 때 해당 컨트롤러의 메소드가 실행되므로
//  요청마다 컨트롤러를 일일히 만들어야하는 문제점이 발생된다.

// @WebServlet 어노테이션에 와일드 카드 문자(*)를 사용하는 확장명 패턴의 요청을 받을 수 있다.
// 확장명 패턴 방식으로 요청을 받을 때 맨 앞에 "/"를 붙이지 않는다.
// 확장명 패턴 방식으로 요청을 받으면 파일명은 상관없이 동일한 확장명으로 요청되면 컨트롤러의 메소드가 실행
// 확장명을 ".jsp"가 아닌 다른 이름을 사용하면 어떤 페이지가 호출되나 숨길 수 있다. => 보안성 향상

@WebServlet("*.nhn")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식의 요청이 들어올 떄 할 작업이 있으면 이곳에 코딩
		actionDo(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식의 요청이 들어올 떄 할 작업이 있으면 이곳에 코딩
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8"); // post 방식으로 넘어오는 한글을 받을 때 깨짐 방지
		response.setContentType("text/html; charset=UTF-8"); // 한글을 보낼 때 깨짐 방지
		
		// 주소창에 입력된 컨텍스트 패스와 요청을 받아온다.
		String url = request.getRequestURI();
		System.out.println(url);
		
		// getContextPath(): 주소창에 요청된 컨텍스트 패스를 받아온다. 
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		// 주소창에 입력된 컨텍스트 패스 뒤의 요청만 얻어온다.
		String context = url.substring(contextPath.length());
		System.out.println(context);
		
		// ====================================================================================
		// 요청에 따른 분기할 페이지를 결정
		String viewPage = "/WEB-INF/";
		switch(context) {
		case "/hello.nhn":
			viewPage += "hello"; // "/WEB-INF/" + "hello" => "/WEB-INF/hello"
			break;
		case "/index.nhn":
			viewPage += "index";
			break;
		}
		
		viewPage += ".jsp"; // "/WEB-INF/hello" + ".jsp" => "/WEB-INF/hello.jsp"
		
		
		
		// ====================================================================================
		
		// 요청에 따른 페이지를 호출
		// request.getRequestDispatcher(viewpage): 브라우저에 표시할 페이지 이름을 넣어준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		// 브라우저에 표시할 페이지를 호출
		dispatcher.forward(request, response);
	}
}
