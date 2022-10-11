<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 쓰기</title>
</head>
<body>

	<% 
		// 쿠키는 서버가 클라이언트에 남기는(보내는) 작은 정보 조각을 말한다.
		// 쿠키는 만들 때는 1번에 1개씩 만들고 읽어올 때는 한꺼번에 읽어서 처리한다.
		// new Cookie("쿠키 이름", "쿠키 내용");
		Cookie cookie = new Cookie("id", "hong"); // 쿠키를 만든다.
		response.addCookie(cookie); // 서버에서 클라이언트로 쿠키를 보낸다.
		
		// tomcat server 8.5 버전부터는 내용이 한글인 쿠키도 별도의 인코딩 과정 없이 잘 처리된다.
		Cookie cookie2 = new Cookie("name", "아롱이"); // 쿠키를 만든다.
		//response.addCookie(cookie2);
		
		// tomcat server 8.0 이하 버전에서는 한글 인코딩 문제로 인해서 쿠키 내용에 한글일 입력하고
		// addCookie() 메소드를 실행하면 에러가 발생
		// 8.0 버전 이하에서는 쿠키 내용으로 한글을 사용하려면 반드시 "UTF-8"로 인코딩 해줘야 한다.
		// 8.5 버전부터는 인코딩 과정을 거치지 않아도 한글로 작성된 쿠키가 정상적으로 전달된다.
		// Cookie cookie2 = new Cookie("name", URLEncoder.encode("아롱이")); // 쿠키를 만든다.
		
		
		// setMaxAge(): 인수로 지정한 시간(단위는 초)만큼 클라이언트에 쿠키를 유지시킨다. => 시간이 경과되면 쿠키가 자동으로 삭제된다.
		cookie2.setMaxAge(10);
		response.addCookie(cookie2);
		
	%>
	
	쿠키 저장 완료!

</body>
</html>