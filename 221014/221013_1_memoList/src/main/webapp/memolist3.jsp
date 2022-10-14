<%@page import="java.text.SimpleDateFormat"%>
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
<title>출첵 게시판</title>

<style type="text/css">

	a {
		text-decoration: none; 
		color: black;
	}
	
	a:hover {
		color: DeepSkyBlue;
	}
	
	span {
		color: tomato;
	}
	
</style>

</head>
<body>


	<form action="memoInsert.jsp" method="post">
		<table width="1000" alian="center" border="1" cellpading="5" cellspacing="0">
			<tr>
				<th colspan="3">출첵 게시판 ver 1.3.0</th>
			</tr>
			<tr>
				<th>이름</th>
				<th>비밀번호</th>
				<th>메모</th>
			</tr>
			<tr>
				<td width="100" align="center"><input type="text" name="name" style="width: 90%; height: 25px;"></td>
				<td width="100" align="center"><input type="password" name="password" style="width: 90%; height: 25px;"></td>
				<td width="800" align="center"><input type="text" name="memo" style="width: 92%; height: 25px;">&nbsp;<input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
	
	
	<br/>
	<hr size="3" color="dodgerblue"/>
	<br/>
	
	
	<%
		int pageSize = 10; 
		int totalCount = 0; 
		int totalPage = 0; 
		int currentPage = 1; 
		int startNo = 0; 
		int endNo = 0;
		int startPage = 0; // 페이지 이동 하이퍼링크 또는 버튼에 표시될 시작 페이지 번호
		int endPage = 0; // 페이지 이동 하이퍼링크 또는 버튼에 표시될 마지막 페이지 번호
		
		Connection conn = DBUtil.getMysqlConnection();
		
		String sql = "SELECT COUNT(*) FROM memolist";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		totalCount = rs.getInt(1);
		out.println("테이블에 저장된 전체 글의 개수: " + totalCount + "개 <br/>");
		
		totalPage = (totalCount - 1) / pageSize + 1;
		out.println("전체 페이지 개수: " + totalPage + "개 <br/>");
	
		
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			currentPage = currentPage > totalPage ? totalPage : currentPage;
			
		} catch (NumberFormatException e) {	}
	
		out.println("전체 화면에 표시되는 페이지 번호: " + currentPage + "개 <br/>");	
		
		
		startNo = (currentPage - 1) * pageSize;
		out.println("전체 화면에 표시되는 글 목록의 시작 인덱스 번호: " + startNo + "<br/>");
	
		endNo = startNo + pageSize - 1;
		
		endNo = endNo > totalCount ? totalCount : endNo;


		sql = "SELECT * FROM memolist ORDER BY idx DESC LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
		
	%>
	
	<table width="1200" alian="center" border="1" cellpading="5" cellspacing="0">
			<tr>
				<th width="80">글번호</th>
				<th width="80">이름</th>
				<th width="840">메모</th>
				<th width="120">작성일</th>
				<th width="80">ip</th>
			</tr>
			
			<% 
				if (rs.next()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
					do {
			%>
						<tr>
							<td align="center"><%=rs.getInt("idx")%></td>
							<td align="center"><%= rs.getString("name") %></td>
							<td><%= rs.getString("memo") %></td>
							<td align="center"><%= sdf.format(rs.getTimestamp("writeDate")) %></td>
							<td align="center"><%= rs.getString("ip") %></td>
						</tr>
			<%
						
					} while(rs.next());
				} else {
			%>
					<tr>
						<td colspan="5">
							<marquee>테이블에 저장된 글이 없습니다.</marquee>
						</td>
					</tr>
			<%
				}
			%>
			
			
			<tr>
				<td colspan="5" align="center">
				<!-- 10페이지 단위로 페이지 이동 버튼을 추가 -->
					<% 
						// 페이지 이동 버튼의 시작 페이지 번호와 마지막 페이지 번호를 계산한다.
						startPage = (currentPage - 1) / pageSize * pageSize + 1;
						endPage= startPage + 9;
						// 페이지 이덩 버튼의 마지막 페이지 번호가 전체 페이지 수보다 커지면 존재하지 않는 페이지 번호가 표시되므로
						// 마지막 페이지 번호를 전체 페이지 번호로 수정한다.
						endPage = endPage > totalPage ? totalPage : endPage;
						
						
						// ================처음으로=========================
						// currentPage가 1보다 크다면 처음으로 이동할 수 있다.
						if (currentPage > 1) {
					%>
							<button type="button" title="첫 페이지로 이동하기" onclick="location.href='?currentPage=1'">처음으로</button>
					<%
						} else {
					%>
							<button type="button" disabled="disabled" title="이미 첫 페이지 입니다.">처음으로</button>
					<%		
						}
						
						
						// ================10페이지 앞으로=========================
						// currentPage가 1보다 크다면 10페이지 이전으로 이동할 수 있다.
						if (startPage > 1) {
					%>
							<button 
								type="button" 
								title="10페이지 전으로 이동하기" 
								onclick="location.href='?currentPage=<%=startPage - 1%>'"
								<%-- onclick="location.href='?currentPage=<%=currentPage - 10%>'" --%>
							>이전</button>
					<%
						} else {
					%>
							<button type="button" disabled="disabled" title="이미 첫 10페이지 입니다.">이전페이지</button>
					<%		
						}
						
						
						
						for (int i = startPage; i <= endPage; i++) {
							if (i == currentPage){
					%>
								<button type="button" disabled="disabled"><%=i%></button>
					<%	
							} else {
					%>
								<button type="button" onclick="location.href='?currentPage=<%=i%>'"><%=i%></button>
					<%			
							}		
						}
					
					
						// ================10페이지 뒤로=========================
						// endPage가 totalPage보다 작으면 10페이지 전으로 이동할 수 있다.
						if (endPage < totalPage) {
					%>
							<button type="button" title="10페이지 뒤로 이동하기" onclick="location.href='?currentPage=<%=startPage + 10%>'">다음페이지</button>
					<%
						} else {
					%>
							<button type="button" disabled="disabled" title="이미 마지막 10페이지 입니다.">다음</button>
					<%		
						}
						
						
						// ================마지막으로=========================
						// currentPage가 totalPage보다 작으면 마지막으로 이동할 수 있다.
						if (currentPage < totalPage) {
					%>
							<button type="button" title="마지막 페이지로 이동하기" onclick="location.href='?currentPage=<%=totalPage%>'">마지막으로</button>
					<%
						} else {
					%>
							<button type="button" disabled="disabled" title="이미 마지막 페이지 입니다.">마지막으로</button>
					<%		
						}
					%>
				</td>
			</tr>
						
		</table>
</body>
</html>