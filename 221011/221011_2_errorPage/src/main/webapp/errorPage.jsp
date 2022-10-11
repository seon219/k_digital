<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>

	<a href="pageOK.jsp">선택</a> <!-- 페이지가 없거나 이동되었거나 삭제되었습니다. -->

	<% 
		//int i = 10 /0; /* 나눗셈은 0으로 할 수 없습니다. */
		int j = Integer.parseInt("꺄아"); /* 정수로 변환할 수 없는 문자열이 지정되었습니다. */
		ArrayList<String> list = null;
		out.println(list.get(0)); /* 서버에 문제가 발생했습니다. */
	%>
	
</body>
</html>