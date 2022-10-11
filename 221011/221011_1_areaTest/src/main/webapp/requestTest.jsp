<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 시스템 영역</title>
</head>
<body>

	requestTest.jsp 입니다. <br/>
	
	<% 
	
		// var라는 일반 변수를 선언하지 않았으므로 에러가 발생됨
		//out.println("일반 변수: " + var + "<br/>"); // 에러발생
		out.println("pageContext 영역 변수: " + pageContext.getAttribute("pageContextVar") + "<br/>");
		out.println("request 영역 변수: " + request.getAttribute("requestVar") + "<br/>");
		out.println("session 영역 변수: " + session.getAttribute("sessionVar") + "<br/>");
		out.println("application 영역 변수: " + application.getAttribute("applicationVar") + "<br/>");
	%>
	
	<hr/>
	
	
	<%-- 
		EL(Expression Language, 표현 언어) 내장 객체 => jsp에 표현식(<%=  %>)을 대신해서 간단한 데이터 출력에 사용 
		EL 사용법 => ${영역변수이름} 또는 ${객체이름Scope.변수이름} => getter 메소드를 사용한 것과 같은 효과
		
		영역 객체 이름은 영역 이름 뒤에 Scope가 붙는다.
		
		jsp의 println() 메소드를 사용해서 영역 변수에 저장된 내용을 출력할 때 영역 변수에 저장된 데이터가 없으면 null 출력하지만,
		EL은 아무것도 출력하지 않는다.
	--%>
	requestTest.jsp 파일의 pageContext 영역 변수(println() 메소드 사용): <% out.println( pageContext.getAttribute("pageContextVar")); %><br/>
	requestTest.jsp 파일의 pageContext 영역 변수(jsp 표현식 사용): <% pageContext.getAttribute("pageContextVar");%><br/>
	requestTest.jsp 파일의 pageContext 영역 변수(EL 표현식 사용): ${pageContextScope.pageContextVar}<br/>
	requestTest.jsp 파일의 pageContext 영역 변수(EL 표현식 사용): ${pageContextVar}<br/>
	
	
	
</body>
</html>