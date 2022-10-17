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
		// lib 폴더에 tomcat-dbcp.jar 파일을 복사해 넣는다. => tomcatDBCP 드라이버
		// META-INF 폴도에 context.xml 파일을 만든다 => context.xml 파일을 복사해 넣는다. => 데이터 베이스 연결정보
		// web.xml 파일에 아래 내용을 코딩
		/* <!-- tomcatDBCP 사용 설정 -->
		  <resource-ref>
		  	<description>tomcat DBCP mysql Connection</description>
		  	<res-ref-name>jdbc/TestDB</res-ref-name>
		  	<res-type>javax.sql.DataSource</res-type>
		  	<res-auth>Container</res-auth>
		  </resource-ref> */
		  
		Connection conn = null;
		try {
			
			Context iniContext = new InitialContext();
			//Context envContext = (Context) iniContext.lookup("java:/comp/env");
			//DataSource dataSource = (DataSource) envContext.lookup("jdbc/TestDB");
			// 위의 주석으로 처리한 2줄을 tomcat server 7.0 부터는 아래와 같이 1줄로 줄여서 사용할 수 있다.
			DataSource dataSource = (DataSource) iniContext.lookup("java:/comp/env/jdbc/TestDB");
			
			conn = dataSource.getConnection();
			
			out.println("연결성공: " + conn + "<br/>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e){
					
				}
			}
		}
		
	%>

</body>
</html>