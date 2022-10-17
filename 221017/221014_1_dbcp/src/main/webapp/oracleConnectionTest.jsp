<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>oracle 연결하기</title>
</head>
<body>
	
	<!--  
		오라클 연결
		시작버튼 - 오라클 - Run SQL Commend Line 실행 - 오라클계정생성.txt
	-->
	
	<%
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "tjoeun", "1234");
			out.println("연결 성공!");
		} catch (ClassNotFoundException e) {
			out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e){
			out.println("데이터베이스 접속 정보가 올바르지 않습니다.");			
		}
		
	%>

</body>
</html>