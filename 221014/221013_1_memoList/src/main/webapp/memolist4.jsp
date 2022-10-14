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

	tr {
		height: 45px;
	}

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
	
	.button {
		background-color: #4CAF50; /* Green */
		border: none;
		color: white;
		padding: 2px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 12px;
		margin: 4px 2px;
		transition-duration: 0.4s;
		cursor: pointer;
		width: 50px;
		height: 30px
	}
	
	.button1 {
		background-color: white; 
		color: black; 
		border: 2px solid #4CAF50;
	}
	
	.button1:hover {
		background-color: #4CAF50;
		color: white;
	}
	
	.button2 {
		background-color: white; 
		color: lightgray; 
		border: 2px solid lightgray;
		cursor: not-allowed;
	}
	
</style>

</head>
<body>


	<form action="memoInsert.jsp" method="post">
		<table width="1000" alian="center" border="1" cellpading="5" cellspacing="0">
			<tr>
				<th colspan="3">출첵 게시판 ver 1.4.0</th>
			</tr>
			<tr>
				<th width="100">이름</th>
				<th width="100">비밀번호</th>
				<th width="800">메모</th>
			</tr>
			<tr>
				<td align="center"><input type="text" name="name" style="width: 90%; height: 25px;"></td>
				<td align="center"><input type="password" name="password" style="width: 90%; height: 25px;"></td>
				<td align="center">
					<input type="text" name="memo" style="width: 90%; height: 25px;">&nbsp;
					<input type="submit" class="button button1" value="저장"></td>
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
		
		// =============================================================================================
		// 페이지당 표시할 글의 개수를 받아 pageSize 변수에 저장
		// 게시판이 최초로 실행될 떄 이전 페이지가 없으므로 넘어오는 pageSize값이 null이고,
		// 보기버튼 이외의 다른 버튼이 클릭되면 pageSize가 넘어오지 않기 떄문에 null이 된다. => 예외 처리 필요
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			// 화면에 표시할 글의 개수가 정상적으로 넘어왔으므로 화면에 표시할 글의 개수를 세션에 저장
			session.setAttribute("pageSize", pageSize + "");
		} catch(NumberFormatException e){
			// 보기 버튼을 제외한 나머지 기능은 pageSize를 전달하는 기능이 없기 때문에
			// NumberFormatException이 발생되서 이곳으로 오게 된다.
			// 이전페이지에서 넘어오는 pageSize가 null이면 세션에 저장해둔 pageSize를 얻어와서 화면에 표시할 글의 개수로 지정
			// 브라우저가 최초로 실행될 때 세션이 만들어지기 때문에 브라우저가 최초로 실행되면 
			// 이전페이지에서 넘어오는 pageSize도 null이고 세션에 저장된 pageSize도 null이다.
			String temp = (String) session.getAttribute("pageSize");
			if(temp != null) {				
				pageSize = Integer.parseInt(temp);
			}
		}

		// =============================================================================================
		
		
		Connection conn = DBUtil.getMysqlConnection();
		
		String sql = "SELECT COUNT(*) FROM memolist";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		totalCount = rs.getInt(1);
		/* out.println("테이블에 저장된 전체 글의 개수: " + totalCount + "개 <br/>"); */
		
		totalPage = (totalCount - 1) / pageSize + 1;
		/* out.println("전체 페이지 개수: " + totalPage + "개 <br/>"); */
	
		
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			currentPage = currentPage > totalPage ? totalPage : currentPage;
			
		} catch (NumberFormatException e) {	}
	
		/* out.println("전체 화면에 표시되는 페이지 번호: " + currentPage + "개 <br/>"); */	
		
		
		startNo = (currentPage - 1) * pageSize;
		/* out.println("전체 화면에 표시되는 글 목록의 시작 인덱스 번호: " + startNo + "<br/>"); */
	
		endNo = startNo + pageSize - 1;
		
		endNo = endNo > totalCount ? totalCount : endNo;


		sql = "SELECT * FROM memolist ORDER BY idx DESC LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
		
	%>
	
	<table width="1330" alian="center" border="1" cellpading="5" cellspacing="0">
			<tr>
				<th width="80">글번호</th>
				<th width="80">이름</th>
				<th width="840">메모</th>
				<th width="120">작성일</th>
				<th width="80">ip</th>
				<th width="130">&nbsp;</th>
			</tr>
			
			
			<!-- 새로 추가한 내용 -->
			<!-- 한 페이지에 표시할 글의 개수를 변경한다. -->
			<tr>
				<td colspan="3">
					<form action="?" method="post">
						페이지당 표시할 글의 개수를 선택하세요.
						<select name="pageSize" style="width: 100px;">
							<option>3</option>
							<option>5</option>
							<option selected="selected">10</option>
							<option>15</option>
							<option>20</option>
						</select>
						<input type="submit" class="button button1" value="보기">
					</form>
				</td>
				<td colspan="3" align="right">
					<%=totalCount%>개(<%=currentPage%> / <%=totalPage%>)Page
				</td>
			</tr>
			
			
			
			<% 
				if (rs.next()) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
					do {
			%>
						<tr>
							<td align="center"><%=rs.getInt("idx")%></td>
							<td align="center"><%= rs.getString("name").replace("<", "&lt;") %></td>
							<td><%= rs.getString("memo").replace("<", "&lt;") %></td>
							<td align="center"><%= sdf.format(rs.getTimestamp("writeDate")) %></td>
							<td align="center"><%= rs.getString("ip") %></td>
							
							<!-- 수정/삭제 버튼 추가 -->
							<td align="center">
								<button type="button" class="button button1" onclick="location.href='memoUpdate.jsp?idx=<%=rs.getInt("idx")%>&currentPage=<%=currentPage%>'">수정</button>
								<button type="button" class="button button1" onclick="location.href='memoDelete.jsp?idx=<%=rs.getInt("idx")%>&currentPage=<%=currentPage%>'">삭제</button>
							</td>
						</tr>
			<%
					} while(rs.next());
				} else {
			%>
					<tr>
						<td colspan="6">
							<marquee>테이블에 저장된 글이 없습니다.</marquee>
						</td>
					</tr>
			<%
				}
			%>
			
			
			<tr>
				<td colspan="6" align="center">
				<!-- 10페이지 단위로 페이지 이동 버튼을 추가 -->
					<% 
						startPage = (currentPage - 1) / 10 * 10 + 1;
						endPage= startPage + 9;
						endPage = endPage > totalPage ? totalPage : endPage;
						
						
						// ================처음으로=========================
						if (currentPage > 1) {
					%>
							<button type="button" class="button button1" title="첫 페이지로 이동하기" onclick="location.href='?currentPage=1'">처음</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 첫 페이지 입니다.">처음</button>
					<%		
						}
						
						
						// ================10페이지 앞으로=========================
						if (startPage > 1) {
					%>
							<button 
								class="button button1"
								type="button" 
								title="10페이지 전으로 이동하기" 
								onclick="location.href='?currentPage=<%=startPage - 1%>'"
								<%-- onclick="location.href='?currentPage=<%=currentPage - 10%>'" --%>
							>이전</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 첫 10페이지 입니다.">이전</button>
					<%		
						}
						
						
						// ================10페이지 단위로 이동버튼 출력=========================
						for (int i = startPage; i <= endPage; i++) {
							if (i == currentPage){
					%>
								<button type="button" class="button button2" disabled="disabled"><%=i%></button>
					<%	
							} else {
					%>
								<button type="button" class="button button1" onclick="location.href='?currentPage=<%=i%>'"><%=i%></button>
					<%			
							}		
						}
					
					
						// ================10페이지 뒤로=========================
						if (endPage < totalPage) {
					%>
							<button type="button" class="button button1" title="10페이지 뒤로 이동하기" onclick="location.href='?currentPage=<%=startPage + 10%>'">다음</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 마지막 10페이지 입니다.">다음</button>
					<%		
						}
						
						
						// ================마지막으로=========================
						if (currentPage < totalPage) {
					%>
							<button type="button" class="button button1" title="마지막 페이지로 이동하기" onclick="location.href='?currentPage=<%=totalPage%>'">마지막</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 마지막 페이지 입니다.">마지막</button>
					<%		
						}
					%>
				</td>
			</tr>
						
		</table>
</body>
</html>