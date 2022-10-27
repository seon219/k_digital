package com.tjoeun.fileDownload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 브라우저 주소창에 contextPath 뒤에 @WebServlet 어노테이션의 인수로 지정된 요청이 들어오면,
// 즉 "/221027_2_fileDownload" 뒤에 "/downloadAction"가 붙어서 "/221027_2_fileDownload/downloadAction" 처럼 요청되면
//  @WebServlet 어노테이션이 붙어있는 클래스의 doGet() 또는 doPost() 메소드가 자동으로 실행된다.
@WebServlet("/downloadAction")
public class downloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public downloadAction() {
        super();
    }

    
    // 서블릿이 get 방식으로 요청될 때 자동으로 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식으로 요청될 때 자동으로 실행");
		System.out.println(request.getParameter("file"));
	}

	// 서블릿이 post 방식으로 요청될 때 자동으로 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 방식으로 요청될 때 자동으로 실행");
	}

}
