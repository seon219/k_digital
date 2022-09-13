<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tjoeun.myCalendar.MyCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년 달력</title>
<!-- 
	th : 굵게 가운데 정렬
	td : 일반 왼쪽정렬 
-->

<style type="text/css">

	tr {
	 height: 80px; /* 행 높이 */
	}
	tr#week {
	 height: 60px; /* 행 높이 */
	}
	
	
	th#title { /* id 태그는 # */
		font-size: 30pt; /* 글자 크기 */
		font-family: D2coding; /* 글꼴 이름 */
		font-weight: bold; /* 글자 두께 */
		color: tomato /* 글자 색 */
		
	}
	th {
		font-size: 15pt;
		width: 100px;
	}
	
	th#sunday {
		color: red;
	}
	th#satday {
		color: blue;
	}
	
	
	td {
		text-align: right; /* 수평정렬 - 오른쪽 */
		vertical-align: top; /* 수직정렬 - 위쪽 */
	}
	td.sun {/* class 태그는 . */
		color: red;
	}
	td.sat {
		color: blue;
	}
	
	td.before{
		font-size: 10pt;
		color: gray;
		background-color: red;
	}
	td.after{
		font-size: 10pt;
		color: gray;
		background-color: red;
	}
	

</style>

</head>
<body>

<%
	// 컴퓨터 시스템의 년, 월 얻어오기
	Date date = new Date();
	int year = date.getYear() + 1900;
	int month = date.getMonth() + 1;
	out.println(year +"년 " + month + "월");
%>


<table width="700" border="1" align="center" cellpadding="5" cellspacing="0">
	<tr>
		<th id="title" colspan="7">
			<%=year%>년 <%=month%>월
		</th>
	</tr>
	
	<tr align="center" id="week">
		<th id="sunday">일</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
		<th id="satday">토</th>
	</tr>
	
	
	<!-- 달력에 날짜를 출력 -->
	<tr>

		<%-- <td height='50'> <%=i%> </td> --%>

		
		<%
			
			// 1일이 출력될 위치(요일)을 맞추기 위해 1일의 요일만큼 반복하며 전달 날짜 출력
			int week = MyCalendar.weekDay(year, month, 1); // 달의 1일
			int start = 0;
			if (month == 1) {
				start = MyCalendar.lastDay(year - 1, 12) - week; // 1월 
			} else {
				start = MyCalendar.lastDay(year, month - 1) - week; // 2 ~ 12월 
			}
			for (int i = 1; i <= week; i++) {
				out.println("<td class='before'>" + (month == 1 ? 12 : month-1) + "/" + (++start) + "</td>");
				
			}	

				
			
			// 1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력
			for(int i = 1; i <= MyCalendar.lastDay(year, month); i++){
			
			switch (MyCalendar.weekDay(year, month, i)){
				case 0: // 일요일
					out.println("<td class='sun'>" + i + "</td>");
					break;
				case 6: // 토요일
					out.println("<td class='sat'>" + i + "</td>");
					break;
				default:// 평일
					out.println("<td>" + i + "</td>");
					break;
			}
					
		
				// 출력한 날짜가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다.
				if(MyCalendar.weekDay(year, month, i) == 6){
					out.println("</tr><tr>");
				}
			}		
			
			
			
			// 다음달 날짜 출력하기
			// 날짜를 다 출력하고 남은 빈 칸에 다음달 1일의 요일부터 토요일까지 반복하며 날짜를 출력
			if (month == 12) {
				week = MyCalendar.weekDay(year + 1, 1, 1); // 12월
			} else {
				week = MyCalendar.weekDay(year, month + 1, 1);
			}
			// 마지막 요일이 토요일이면 다음달 날짜 출력 안함
			if (week != 0) {
				start = 0;
				for (int i = week; i <= 6; i++) {
					out.println("<td class='after'>" + (month == 12 ? 1 : month+1) + "/" + (++start) + "</td>");
				}
			}
		%>
	
	</tr>
	
</table>


</body>
</html>