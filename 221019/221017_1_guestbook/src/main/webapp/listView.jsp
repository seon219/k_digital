<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.tjoeun.vo.GuestbookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tjoeun.vo.GuestbookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>

<link rel="stylesheet" href="./guestbook.css"/>

</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		
		// list.jsp에서 1페이지 분량의 글 목록과 페이징 작업에 사용할 변수를 저장해서 request 영역에 저장한 GuestbookList 클래스 객레를 받는다.
		// request 영역에 저장되는 데이터 타입은 object 타입이므로 데이터를 얻어온 다음에 형변환 시켜야 한다.
		GuestbookList guestbookList = (GuestbookList) request.getAttribute("guestbookList");
		//out.println(guestbookList);
		//out.println(guestbookList.getList()); // 브라우저에 출력할 1페이지 분량의 글 목록
		
		
		// 브라우저에 출력할 1페이지 분량의 글 목록만 꺼내서 별도의 ArrayList를 만들어 사용
		ArrayList<GuestbookVO> view = guestbookList.getList();
	%>
	
	<table width="1000" aling="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>방명록 보기</th>
		</tr>
		<tr>
			<td align="right">
				<%=guestbookList.getTotalCount()%>개(<%=guestbookList.getCurrentPage()%> / <%=guestbookList.getTotalPage()%>)
			</td>
		</tr>
		<tr>
			<td>
				<%
					if(view.size() == 0){
						out.println("<marquee> 테이블에 저장된 글이 없습니다. </marquee>");
					} else {
						
						// 컴퓨터 시스템의 날짜와 시간을 얻어온다.
						Date date = new Date();
						// 날짜, 시간 서식
						SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
						
						
						for (GuestbookVO vo : view) {
				%>
							<table class="table" width="99%" align="center" border="1" cellpadding="5" cellspacing="0">
								<tr>
									<td>
										<%=vo.getIdx()%>. <%=vo.getName().replace("<", "&lt;").replace(">", "&gt;")%>
										(<%=vo.getIp()%>)님이 
										<%
											// 오늘 입력된 글은 시간만 표시하고 어제부터는 입력된 날까만 표시
											/*
											if (date.getYear() == vo.getWriteDate().getYear() && date.getMonth() == vo.getWriteDate().getMonth() 
												&& date.getDate() == vo.getWriteDate().getDate()) {
												out.println(sdf1.format(vo.getWriteDate()));
											} else {
												out.println(sdf2.format(vo.getWriteDate()));												
											}
											*/
										
											if (sdf2.format(date).equals(sdf2.format(vo.getWriteDate()))) {
												out.println(sdf1.format(vo.getWriteDate()));
											} else {
												out.println(sdf2.format(vo.getWriteDate()));												
											}
										
										%>									
										에 남긴 글
										
										<!-- 수정 삭제 버튼 추가 -->
										<input 
											class="button button1"
											type="button" 
											value="수정"
											onclick="location.href='selectByIdx.jsp?idx=<%=vo.getIdx()%>&currentPage=<%=guestbookList.getCurrentPage()%>&job=update'"/>
										<input 
											class="button button1"
											type="button" 
											value="삭제" 
											onclick="location.href='selectByIdx.jsp?idx=<%=vo.getIdx()%>&currentPage=<%=guestbookList.getCurrentPage()%>&job=delete'"/>
										
										<br/>
										 > <%=vo.getMemo().replace("<", "&lt;").replace(">", "&gt;").replace("\r\n", "<br/>")%>
									</td>
								</tr>
							</table>							
				<%
						}
						
					}
				%>
			</td>
		</tr>
		
		<!-- 페이지 이동 버튼 -->
		<tr>
				<td colspan="6" align="center">
				<!-- 10페이지 단위로 페이지 이동 버튼을 추가 -->
					<% 
						// ================처음으로=========================
						if (guestbookList.getCurrentPage() > 1) {
					%>
							<button type="button" class="button button1" title="첫 페이지로 이동하기" onclick="location.href='?currentPage=1'">처음</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 첫 페이지 입니다.">처음</button>
					<%		
						}
						
						
						// ================10페이지 앞으로=========================
						if (guestbookList.getStartPage() > 1) {
					%>
							<button 
								class="button button1"
								type="button" 
								title="10페이지 전으로 이동하기" 
								onclick="location.href='?currentPage=<%=guestbookList.getStartPage() - 1%>'"
								<%-- onclick="location.href='?currentPage=<%=currentPage - 10%>'" --%>
							>이전</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 첫 10페이지 입니다.">이전</button>
					<%		
						}
						
						
						// ================10페이지 단위로 이동버튼 출력=========================
						for (int i = guestbookList.getStartPage(); i <= guestbookList.getEndPage(); i++) {
							if (i == guestbookList.getCurrentPage()){
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
						if (guestbookList.getEndPage() < guestbookList.getTotalPage()) {
					%>
							<button type="button" class="button button1" title="10페이지 뒤로 이동하기" onclick="location.href='?currentPage=<%=guestbookList.getStartPage() + 10%>'">다음</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 마지막 10페이지 입니다.">다음</button>
					<%		
						}
						
						
						// ================마지막으로=========================
						if (guestbookList.getCurrentPage() < guestbookList.getTotalPage()) {
					%>
							<button type="button" class="button button1" title="마지막 페이지로 이동하기" onclick="location.href='?currentPage=<%=guestbookList.getTotalCount()%>'">마지막</button>
					<%
						} else {
					%>
							<button type="button" class="button button2" disabled="disabled" title="이미 마지막 페이지 입니다.">마지막</button>
					<%		
						}
					%>
				</td>
			</tr>
			
			
			<!-- 글쓰기 버튼 -->
			<tr>
				<td align="right">
					<input class="button button1" type="button" value="글쓰기" onclick="location.href='insert.jsp'"/>
				</td>
			</tr>
		
		
	</table>

</body>
</html>