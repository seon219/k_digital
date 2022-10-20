<%@page import="com.tjoeun.service.updateService"%>
<%@page import="com.tjoeun.service.selectService"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@page import="com.tjoeun.dao.GuestbookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하겠다고 알려준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 --> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<fmt:requestEncoding value="UTF-8"/>
	
	<% 
		// update.jsp에서 넘어온 데이터를 받는다.
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	%>
	
	<jsp:useBean id="vo" class="com.tjoeun.vo.GuestbookVO">
		<jsp:setProperty property="*" name="vo"/> 
	</jsp:useBean>
	<%-- ${vo}<br/> --%>
	
	<% 
		//수정할 글의 비밀번호와 수정하기 위해 입력한 비밀번호를 비교하기 위해 수정할 글을 얻어온다.
		GuestbookVO original = selectService.getinstance().selectByIdx(vo.getIdx());
		
		
		//oracle을 필드 선언시 데이터 타입을 char로 선언하면 필드의 크기보다 입력된 문자의 크기가 적을 때 남는 자리가 모두 공백으로 리턴된다.
		//out.println("수정하기 위해 입력한 비밀번호의 글자수" + vo.getPassword().length() + "<br/>");
		//out.println("수정할 글의 비밀번호의 글자수" + original.getPassword().length() + "<br/>");
		// 1. 테이블을 설계할 때 char 대신 varchar2로 선언
		// 2. 이미 테이블이 char로 설계된 상태라면 trim() 메소드로 불필요한 칸을 제거해서 사용
		
		out.println("<script>");
		if (original.getPassword().trim().equals(vo.getPassword())) {
			
			// 비밀번호가 일치하면 글을 수정하는 메소드를 실행
			updateService.getinstance().update(vo);
			
			out.println("alert('" + original.getIdx() + "번 글 수정완료')");
		} else {
			// 비밀번호가 일치하지 않으면 오류 메시지 출력
			out.println("alert('비밀번호가 일치하지 않습니다.')");
		}
		out.println("location.href='list.jsp?currentPage=" + currentPage + "'");
		out.println("</script>");
	%>
	
	
	
</body>
</html>