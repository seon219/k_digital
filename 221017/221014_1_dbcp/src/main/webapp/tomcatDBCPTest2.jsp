<%@page import="com.tjoeun.dbcpTest.DBUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat dbcp 연결하기</title>
</head>
<body>

	<%
		Connection conn = DBUtil.getTomcatDBCPConnection();
		out.println("연결성공: " + conn + "<br/>");
		DBUtil.close(conn);
		
	%>

</body>
</html>