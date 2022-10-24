<%@page import="com.tjoeun.vo.CategoryVO"%>
<%@page import="com.tjoeun.service.CategoryService"%>
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
		CategoryService service = CategoryService.getInstance();
		// 신고한 카테고리 이름을 신고완료 메시지에 표시하기 위해서 신고하기 전에 신고할 카테고리를 얻어온다.
		CategoryVO original = service.selectByIdx(vo.getIdx());
		//out.println(original);
		
		// 신고 버튼이 클릭되면 deleteReport 필드의 값을 1 증가시킨다.
		service.report(vo.getIdx());
		
		// 신고 메시지를 출력하고 카테고리 목록을 얻어오는 페이지(list.jsp)를 호출한다.
		out.println("<script>");
		out.println("alert('" + original.getIdx() + "번 " + original.getCategory() + " 카테고리가 신고됨')");		
		out.println("location.href='list.jsp'");
		out.println("</script>");
	%>

</body>
</html>