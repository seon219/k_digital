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
		Connection conn = null;
		
		try{
			// mysql 드라이버 클래스를 읽어온다.
			Class.forName("com.mysql.jdbc.Driver"); // 5.x 사용자
			
			// mysql에 연결
			// DriverManager 클래스의 getConnection(url, user, password) 메소드로 mysql에 연결
			// url은 mysql이 설치된 경로와 데이터베이스 이름을 적는다.
			String url = "jdbc:mysql://localhost:3306/javaam?useUnicode=true&characterEncoding=UTF-8"; // 5.x 사용자
			// String url = "jdbc:mysql://localhost:3306/javaam?serverTimeZone=UTC"; // 8.x 사용자
			conn = DriverManager.getConnection(url, "root", "1234");
			
			// 데이터베이스와 연결이 되었으므로 데이터베이스를 사용
			out.println("연결 성공: " + conn);
			
		} catch (ClassNotFoundException e) {
			out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			out.println("데이터베이스 접속 정보가 올바르지 않습니다.");			
		} finally {
			if (conn != null){
				try{
					conn.close();					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
	%>

</body>
</html>