<%@page import="org.apache.taglibs.standard.lang.jstl.test.beans.Factory"%>
<%@page import="com.tjoeun.service.CategortService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
	%>

	<jsp:useBean id="vo" class="com.tjoeun.vo.CategoryVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>
	<%-- ${vo} --%>
	
	
	<%
		// CategoryView.jsp에서 넘겨받은 메인 카테고리를 테이블에 저장하는 메소드 호출
		CategortService.getInstance().insert(vo);
		
	%>
	
	
		
</body>
</html>