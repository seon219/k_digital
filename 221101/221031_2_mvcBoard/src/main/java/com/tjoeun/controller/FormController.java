package com.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjoeun.dao.MvcBoardDAO;
import com.tjoeun.service.MvcboardService;

@WebServlet("*.nhn")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// 컨트롤러에서 사용할 service 클래스 객체를 생성
	private MvcboardService service = MvcboardService.getInstance();
	
    
    public FormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		System.out.println("controller doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		System.out.println("controller doPost()");
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("controller actionDo()");
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8"); // post 방식으로 넘어오는 한글을 받을 때 깨짐 방지
		response.setContentType("text/html; charset=UTF-8"); // 한글을 보낼 때 깨짐 방지
		
		// 주소창에 입력된 컨텍스트 패스와 요청을 받아온다.
		String url = request.getRequestURI();
		
		
		// getContextPath(): 주소창에 요청된 컨텍스트 패스를 받아온다. 
		String contextPath = request.getContextPath();
		//System.out.println(contextPath);
		
		// 주소창에 입력된 컨텍스트 패스 뒤의 요청만 얻어온다.
		String context = url.substring(contextPath.length());
		System.out.println(context);
		
		// ====================================================================================
		// 요청에 따른 분기할 페이지를 결정
		String viewPage = "/WEB-INF/";
		switch(context) {
		case "/insert.nhn":
			viewPage += "insert"; 
			break;
			
		case "/insertOK.nhn":
			
			// insert.jsp에서 테이블에 저장할 데이터를 입력하고 submit 버튼을 클릭하면 폼에 입력한 정보가 
			// 컨트롤러의 doPost() 메소드의 HttpServletRequest 인터페이스 타입의 객체인 request에 저장된다.
			// doPost() 메소드는 request 객체에 저장된 데이터를 가지고 actionDo() 메소드를 실행하므로
			// insert.jsp에서 폼에 입력한 데이터는 actionDo() 메소드의 request 객체에 저장된다.
			service.insert(request, response);
			
			viewPage += "index"; 
			break;
			
		case "/list.nhn":
			
			// 브라우저에 출력할 1페이지 분량의 글과 페이징 작업에 사용할 8개의 변수가 저장된 
			// 클래스 객체를 얻어오는 메소드를 호출
			service.selectList(request, response);
			
			viewPage += "list"; 
			break;

		case "/increment.nhn":
			// 조회수를 증가시키는 메소드를 호출
			service.increment(request, response);
			
			viewPage += "increment"; 
			break;
			
		case "/contentView.nhn":
			
			// 조회수를 증가시킨 글 1건을 얻어오는 메소드를 호출
			service.selectByIdx(request, response);
			
			viewPage += "contentView"; 
			break;
			
		case "/update.nhn":
			
			// 글 1건을 수정하는 메소드를 호출
			service.update(request, response);
			
			viewPage += "goList"; 
			break;
			
		case "/delete.nhn":
			
			// 글 1건을 삭제하는 메소드를 호출
			service.delete(request, response);
			
			viewPage += "goList"; 
			break;
			
		case "/reply.nhn":
			
			// 답글을 입력하는 페이지에 질문글을 출력하기 위해서 질문글 1건을 얻어와서 답글을 입력하는 페이지로 넘겨준다.
			service.selectByIdx(request, response);
			
			viewPage += "reply"; 
			break;
		
		case "/replyInsert.nhn":
			
			// 답글이 브라우저에 표시될 위치를 정하기 위해서 조건에 만족하는 sql 값을 1씩 증가시킨 후
			// 답글을 저장하는 메소드를 호출
			service.replyInsert(request, response);
			
			viewPage += "goList"; 
			break;
		}
		
		viewPage += ".jsp";
		
		
		// ====================================================================================
		
		// 요청에 따른 페이지를 호출
		// request.getRequestDispatcher(viewpage): 브라우저에 표시할 페이지 이름을 넣어준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		// 브라우저에 표시할 페이지를 호출
		dispatcher.forward(request, response);
	}
}
