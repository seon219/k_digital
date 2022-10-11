<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 읽기</title>
</head>
<body>

	<% 
		// 쿠키를 읽어올 떄는 여러개를 한번에 읽어와야 하기 때문에 배열로 받는다.
		Cookie[] cookies = request.getCookies();
		//out.print(cookies + "<br/>");
		//out.print(Arrays.toString(cookies) + "<br/>");
		
		for (Cookie cookie : cookies) {
			// getName(): 쿠키 이름을 얻어온다
			// getValue(): 쿠키 내용을 얻어온다
			// JSESSIONID는 jsp가 사용하는 시스템 쿠키로 접속한 컴퓨터를 식별하는 용도로 사용
			out.println("쿠키 이름:" + cookie.getName() + ", 쿠키 내용: " + cookie.getValue() + "<br/>");
			
			// 8.0 이하 버전에서는 내용이 한글인 쿠키를 저장할 때 에러가 발생되기 때문에 인코딩 과정을 거쳐서 쿠키를 저장해야 했지만,
			// 읽어올 때는 그냥 읽어와도 에러가 발생되지 않는다.
			// 다만, 인코딩 된 유니코드 자체를 가져오기 때문에 읽을 수 없다.
			// 8.0 이하 버전에서 인코딩되서 저장된 쿠키 내용을 읽으려면 디코딩 과정을 거쳐야 읽을 수 있다.
			// 8.5 버전도 한글이 깨져서 보이므로 디코딩 과정을 거쳐야 한다.
			// out.println("쿠키 이름:" + cookie.getName() + ", 쿠키 내용: " + URLDecoder.decode(cookie.getValue()) + "<br/>");
			
		}
		
	%>

</body>
</html>