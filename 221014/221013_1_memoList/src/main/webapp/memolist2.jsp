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

	<!-- 입력 화면 설계 -->
	<form action="memoInsert.jsp" method="post">
		<table width="1000" alian="center" border="1" cellpading="5" cellspacing="0">
			<tr>
				<th colspan="3">출첵 게시판 ver 1.1.0</th>
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
	<!-- 입력 화면 끝 -->
	
	
	<br/>
	<hr size="3" color="dodgerblue"/>
	<br/>
	
	<!-- 테이블에 저장된 글 목록 전체를 글번호(idx)의 내림차순(최신글부터)으로 얻어온다. -->
	<%
		
	// 1. =====================================================================================================================
		// 페이징 작업에 사용할 8개의 변수를 선언 => 계산에 의한 값을 가져야하는 변수는 0으로 초기화
		int pageSize = 10; // 1페이지에 표시하려는 글의 개수
		int totalCount = 0; // 테이블에 저장된 전체 글의 개수
		int totalPage = 0; // 전체 페이지 개수
		int currentPage = 1; // 현재 브라우저에 표시되는 페이지 번호
		int startNo = 0; // 현재 브라우저에 표시되는 글의 시작 인덱스 번호 => mysql은 인덱스가 0부터 시작
		int endNo = 0; // 현재 브라우저에 표시되는 글의 마지막 인덱스 번호 => mysql에서는 사용하지 않는다.
		int startPage = 0; // 페이지 이동 하이퍼링크 또는 버튼에 표시될 시작 페이지 번호
		int endPage = 0; // 페이지 이동 하이퍼링크 또는 버튼에 표시될 마지막 페이지 번호
	// 1. =====================================================================================================================
	
		
		Connection conn = DBUtil.getMysqlConnection();
		
		
	// 2. =====================================================================================================================
		// totalCount 변수에 테이블에 저장된 전체 글의 개수를 얻어와서 저장
		String sql = "SELECT COUNT(*) FROM memolist";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// 테이블에 저장된 글이 있으면 글의 개수를 얻어와서 ResultSet 객체에 저장하고,
		// 테이블에 저장된 글이 없으면 0을 ResultSet 객체에 저장하므로 ResultSet 객체에 저장되는 데이터가 무조건 있기 때문에
		// 물어보는 동작을 할 필요가 없다.
		rs.next();
		totalCount = rs.getInt(1);
		out.println("테이블에 저장된 전체 글의 개수: " + totalCount + "개 <br/>");
		
		
		// totalPage 변수에 전체 페이지 개수를 계산해 저장
		totalPage = (totalCount - 1) / pageSize + 1;
		out.println("전체 페이지 개수: " + totalPage + "개 <br/>");
	// 2. =====================================================================================================================
		
		
	// 3. =====================================================================================================================
		// 이전 페이지에서 넘어온 브라우저에 표시할 페이지 번호를 받는다.
		// 이전 페이지에서 currentPage가 넘어오지 않으면 넘어오는 값이 없으므로 currentPage는 null
		// null에 parseInt() 메소드를 실행하면 NumberFormatException이 발생되기 때문에,
		//  현재 페이지에 표시할 페이지 번호(currentPage)를 받을 때 예외처리를 해야한다.
		// currentPage가 정상적으로 넘어오면 넘어온 currentPage를 정수로 바꿔서 currentPage 변수에 저장하고,
		//  그렇지 않으면 초기값으로 지정한 1이 유지되게 한다
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			// 현재 화면에 표시할 페이지 번호는 전체 페이지 개수보다 클 수 없으므로,
			//  화면에 표시할 페이지 번호가 전체 페이지 개수보다 큰 값이 넘어왔다면,
			//  화면에 표시할 페이지 번호를 전체 페이지 개수로 수정한다.
			currentPage = currentPage > totalPage ? totalPage : currentPage;
			
		} catch (NumberFormatException e) {	}
	
		out.println("전체 화면에 표시되는 페이지 번호: " + currentPage + "개 <br/>");	
		
		
	// 3. =====================================================================================================================
		
			
	// 4. =====================================================================================================================
		// startNo 변수에 현재 화면에 표시할 글 목록의 시작 인덱스 번호를 계산
		// mysql은 select sql 명령을 실행핬을 떄 맨 처음 나오는 글의 인덱스가 0부터 시작하고 oracle은 1부터 시작
		startNo = (currentPage - 1) * pageSize;
		out.println("전체 화면에 표시되는 글 목록의 시작 인덱스 번호: " + startNo + "<br/>");
		
		// mysql은 limit를 사용하면 되기 때문에 endNo를 계산할 필요가 없지만, oracle은 limit가 없기 때문에 endNo를 계산해야 한다.
		endNo = startNo + pageSize - 1;
		// 마지막 페이지에 표시되는 글의 개수는 반드시 화면에 표시할 글의 개수(pageSize) 만큼 표시되지 않는다.
		// 한 페이지에 표시할 마지막 글의 인덱스는 전체글의 개수보다 커지면 안되므로,
		//  마지막 글의 인덱스 번호가 전체 글의 개수보다 커지면, 전체 글의 개수로 endNo를 수정한다.
		endNo = endNo > totalCount ? totalCount : endNo;
	// 4. =====================================================================================================================
		
		
	// 5. =====================================================================================================================
		// memolist에서 사용했던 select.sql 명령을 수정해서 전체 글을 모두 얻어오던 것을,
		//  limit를 사용해서 현재 페이지에 출력할 내용만 얻어오게 수정
		//sql = "SELECT * FROM memolist ORDER BY idx DESC";
		sql = "SELECT * FROM memolist ORDER BY idx DESC LIMIT ?, ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
	// 5. =====================================================================================================================
		
		
	%>
	
	
	<!-- 테이블에서 얻어온 글 목록을 출력 -->
	
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
			
			
			<!-- 6. 첫 페이지부터 마지막 페이지까지 이동할 수 있는 하이퍼링크 또는 버튼을 만든다. -->
			<!-- 
			<tr>
				<td colspan="5" align="center">
					<% 
						for (int i = 1; i <= totalPage; i++) {
							if (i == currentPage){
					%>		
								<%-- <span>[<%=i%>]</span> --%>
								<button type="button" disabled="disabled"><%=i%></button>
					<%	
							} else {
					%>		
								<%-- <a href="?currentPage=<%=i%>">[<%=i%>]</a> --%>
								<button type="button" onclick="location.href='?currentPage=<%=i%>'"><%=i%></button>
					<%			
							}		
						}
					%>
				</td>
			</tr>
			-->
			
			
			<tr>
				<td colspan="5" align="center">
					<% 
						for (int i = 1; i <= totalPage; i++) {
							if (i == currentPage){
								out.println("<button type='button' disabled='disabled'>" + i + "</button>");	
							} else {
								out.println("<button type='button' onclick='location.href=\"?currentPage=" + i + "\"'>" + i + "</button>");	
							}		
						}
					%>
				</td>
			</tr>
		</table>
	
	
	

</body>
</html>