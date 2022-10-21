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
		// 복구한 카테고리 이름을 복구완료 메시지에 표시하기 위해서 복구하기 전에 복구할 카테고리를 얻어온다.
		CategoryVO original = service.selectByIdx(vo.getIdx());
		//out.println(original);
		
		// 1. 복구 버튼이 클릭되면 해당 카테고리를 테이블에서 완전히 복구
		//service.delete(vo.getIdx());
		
		// 2. 복구 버튼이 클릭되면 해당 카테고리 자체를 "복구된 카테고리 입니다."로 수정한다.
		//service.restoreCheck(vo.getIdx());
		
		// 3. 복구 버튼이 클릭되면 deleteCheck 필드의 값을 "YES"로 수정
		service.restoreCheck(vo.getIdx());
		
		// 복구 메시지를 출력하고 카테고리 목록을 얻어오는 페이지(list.jsp)를 호출한다.
		out.println("<script>");
		out.println("alert('" + original.getIdx() + "번 " + original.getCategory() + " 카테고리 복구 완료!')");		
		out.println("location.href='list.jsp'");
		out.println("</script>");
	%>

</body>
</html>