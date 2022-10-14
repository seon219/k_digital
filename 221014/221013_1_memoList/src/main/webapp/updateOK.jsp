<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.tjoeun.MemoList.DBUtil"%>
<%@page import="java.sql.Connection"%>
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
		// memoDelet.jsp에서 넘어오는 수정할 글번호(idx)와 수정 후 돌아갈 페이지 번호(currentPage),
		// 수정하기 위해 입력한 비밀번호(password)를 받는다.
		String idx = request.getParameter("idx");
		String currentPage = request.getParameter("currentPage");
		String password = request.getParameter("password");
		String memo = request.getParameter("memo");
		
		// 수정하기 위해 입력한 비밀번호와 수정할 글의 비밀번호를 비교하기 위해 수정할 글을 얻어온다.
		Connection conn = DBUtil.getMysqlConnection();
		String sql = "SELECT * FROM memolist WHERE idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(idx));
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		
		// 수정하기 위해 입력한 비밀번호(password)와 수정할 글의 비밀번호(rs.getString("password"))를 비교해서 일치하면 글을 수정한다.
		out.println("<script>");
		if(password.equals(rs.getString("password"))) {
			// 비밀번호가 일치하므로 글을 수정한다.
			// UPDATE 테이블이름 SET 수정할내용[, 수정할내용, ....] [WHERE 조건식];
			sql = "update memolist set memo = ? where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo);
			pstmt.setInt(2, Integer.parseInt(idx));
			pstmt.executeUpdate();
			
			// 글을 수정했다는 메시지를 출력
			out.println("alert('" + idx + "번 글 수정 완료!')");
		} else {
			// 비밀번호가 일치하지 않으면 에러 메시지를 출력
			out.println("alert('비밀번호가 일치하지 않습니다.')");
		}
		DBUtil.close(conn);
		
		//memolist4.jsp로 돌아간다.
		out.println("location.href='memolist4.jsp?currentPage=" + currentPage + "'");
		
		out.println("</script>");
		
		
	%>

</body>
</html>