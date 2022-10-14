<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.tjoeun.MemoList.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정할 글 보기</title>
</head>
<body>

	<% 
		request.setCharacterEncoding("UTF-8");
		// memolist4.jsp에서 넘어오는 수정할 글번호(idx)와 수정 후 돌아갈 페이지 번호(currentPage)를 받는다.
		String tempIdx = request.getParameter("idx");
		String tempCurrentPage = request.getParameter("currentPage");
		//out.println(tempIdx + ", " + tempCurrentPage);
		
		// 수정할 글 번호와 수정후 돌아갈 페이지 번호가 모두 넘어왔나 검사
		if(tempIdx != null && tempCurrentPage != null && tempIdx.trim().length() != 0 && tempCurrentPage.trim().length() != 0) {
			
			// 수정할 글 번호와 돌아갈 페이지 번호가 모두 숫자인가 검사
			try {
				int idx = Integer.parseInt(tempIdx);
				int currentPage = Integer.parseInt(tempCurrentPage);
				
				// 수정할 글번호에 해당되는 글이 테이블에 존재하는가 확인하기 위해서 글번호에 해당되는 글을 얻어온다.
				Connection conn = DBUtil.getMysqlConnection();
				String sql = "SELECT * FROM memolist WHERE idx = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				ResultSet rs = pstmt.executeQuery();
				
				// 수정할 글이 테이블에 존재하는가 검사
				if (rs.next()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) a hh:mm:ss");
					
	%>				
					<!-- 수정할 글이 테이블에 존재하므로 수정할 글을 화면에 보여주고 수정할 내용과 비밀번호를 입력받는다. -->
					<form action="updateOK.jsp" method="post">
						<table width="700" align="center" border="1" cellpadding="5" cellspacing="0">
							<tr>
								<td colspan="2">수정할 글 확인</td>
							</tr>
							<tr>
								<td width="100">글 번호</td>
								<td width="600"><%=rs.getInt("idx")%></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><%= rs.getString("name").replace("<", "&lt;") %></td>
							</tr>
							<tr>
								<td>작성일</td>
								<td><%= sdf.format(rs.getTimestamp("writeDate")) %></td>
							</tr>
							<tr>
								<td>메모</td>
								<td><input type="text" name="memo" style="width: 98%; height: 50px;" value="<%=rs.getString("memo")%>"></td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<label>
										비밀번호
										<input type="password" name="password"/>
										<input type="submit" value="수정하기"/>
										<input type="reset" value="다시쓰기"/>
										<input type="button" value="돌아가기1" onclick="history.back()"/> <!-- 뒤로가기 -->
										<input type="button" value="돌아가기2" onclick="history.go(-1)"/> <!-- 뒤로가기 -->
										<input type="button" value="돌아가기3" onclick="location.href='memolist4.jsp?currentPage=<%=currentPage%>'"/> <!-- 페이지 다시열기 -->
									</label>
								</td>
							</tr>
						</table>
						
						<!-- 수정할 글번호와 수정 후 돌아갈 페이지번호도 deleteOK.jsp로 넘겨줘야 한다. -->
						<input type="hidden" name="idx" value="<%=rs.getInt("idx")%>"/>
						<input type="hidden" name="currentPage" value="<%=currentPage%>"/>
						
					</form>
					
	<%				
					DBUtil.close(conn);
	
				} else {
					// 수정할 글이 테이블에 존재하지 않으므로 에러 메시지를 출력하고 memolist4.jsp로 돌려보낸다.
					out.println("<script>");
					out.println("alert('수정할 글이 테이블에 존재하지 않습니다.')");			
					out.println("location.href='memolist4.jsp'");
					out.println("</script>");
				}
				
			} catch (NumberFormatException e) {
				// 수정할 글번호와 돌아갈 페이지 번호가 모두 숫자가 아니므로 에러 메시지를 출력하고 memolist4.jsp로 돌려보낸다.
				out.println("<script>");
				out.println("alert('수정할 글번호 또는 돌아갈 페이지 번호가 모두 숫자가 아닙니다.')");			
				out.println("location.href='memolist4.jsp'");
				out.println("</script>");
			}
			
		} else {
			// 수정할 글번호와 돌아갈 페이지 번호가 모두 넘어오지 않았으므로 에러 메시지를 출력하고 memolist4.jsp로 돌려보낸다.
			out.println("<script>");
			out.println("alert('수정할 글번호 또는 돌아갈 페이지 번호가 넘어오지 않았습니다.')");			
			out.println("location.href='memolist4.jsp'");
			out.println("</script>");
		}
		
		
	%>

</body>
</html>