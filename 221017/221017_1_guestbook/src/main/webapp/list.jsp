<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		currentPage를 넘겨받아 currentPage에 해당되는 1페이지 분량의 글 목록을 데이터베이스 테이블에서 얻어와서 
		request 영역에 저장한 후 1페이지 분량의 글을 출력하는 페이지(listView.jsp)로 넘겨준다.
	 -->

	<%
		request.setCharacterEncoding("UTF-8");
	
		// 이전 페이지에서 넘어오는 화면에 표시할 페이지 번호(currentPage)를 받는다.
		// 게시판이 최초로 실행될 때 또는 insertOK.jsp에서 호출될 때 list.jsp로 currentPage가 넘어오지 않는다. => null
		// null은 parseInt() 메소드를 실행했을 때 NumberFormatException이 발생되므로 반드시 예외 처리를 해야 한다.
		// 이전 페이지에서 넘어오는 currentPage가 없으면 currentPage를 1로 초기화시켜 사용하고,
		//  넘어오는 currentPage가 있으면 넘어온 currentPage 값으로 초기화시켜 사용
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (NumberFormatException e) {	}
		
		
		// 카테고리와 검색어를 받는다.
		
	%>

</body>
</html>