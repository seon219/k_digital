<%@page import="com.tjoeun.MemoList.DBUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mysql 연결하기</title>
</head>
<body>

	<%  
		Connection conn = DBUtil.getMysqlConnection();
		out.println("연결 성공: " + conn);
		DBUtil.close(conn);
	%>

</body>
</html>