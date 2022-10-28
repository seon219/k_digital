<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 실제로 파일이 업로드된 경로를 얻어온다. => realpath
		String uploadDirectory = application.getRealPath("/upload");
		
		// 실제로 파일이 업로드된 경로의 파일을 얻어온다.
		// list(): 지정된 디렉토리(폴더)에 저장된 파일 목록을 얻어오는 메소드
		String[] files = new File(uploadDirectory).list();
		//out.println(Arrays.toString(files));
		
		
		int i = 0;
		for (String file : files) {
			//out.println(++i + ". " + file + "<br/>");
	%>
			<%=++i%>. 													<%-- <%=URLEncoder.encode(file, "UTF-8")%> --%>
			<a href="<%=request.getContextPath()%>/downloadAction?file=<%=file%>">
				<%= file %>
			</a><br/>
		
	<%		
		}
	%>
	
		<a href="index.jsp">돌아가기</a>
		
		<form action="downloadAction" method="post">
			<input type="text" value="홍길동" name="name">
			<input type="submit" value="눌러봐">
		</form>

</body>
</html>