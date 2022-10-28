<%@page import="com.tjoeun.fileupload.FileDAO"%>
<%@page import="com.tjoeun.fileupload.FileVO"%>
<%@page import="java.util.ArrayList"%>
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

	<h1>업로드된 파일목록</h1>

	<%
	/*
		String[] files = new File("D:/upload/").list();
		for (int i= 0; i < files.length; i++) {
			out.println(i + 1 + ". " + files[i] + "<br/>");
		}
	*/
		
		
		// 테이블에 저장된 전체 업로드 파일 정보를 얻어온다
		ArrayList<FileVO> files = new FileDAO().getUploadList();
		
		for (FileVO file : files) {
			//out.println(++i + ". " + file + "<br/>");
	%>
			<%=file.getIdx()%>.
			<a href="<%=request.getContextPath()%>/downloadAction?file=<%=URLEncoder.encode(file.getFilename(), "UTF-8")%>&realfile=<%=URLEncoder.encode(file.getFilerealname(), "UTF-8")%>">
				<%=file.getFilename()%>
			</a>
			(다운로드 횟수: <%=file.getDownloadcount()%>번)
			<br/>
		
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