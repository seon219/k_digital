<%@page import="com.tjoeun.myCalendar.SolaToLunar"%>
<%@page import="com.tjoeun.myCalendar.LunarDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tjoeun.myCalendar.MyCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년달력</title>
<!-- 
	th : 굵게 가운데 정렬
	td : 일반 왼쪽정렬 
-->

<style type="text/css">	
	
	tr {
	 height: 80px; /* 행 높이 */
	 border-width: 0px;
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
		border-width: 0px;
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
		border-radius: 10px;
		border: 1px solid navy;
	}
	td.sun {/* class 태그는 . */
		color: red;
	}
	td.sat {
		color: blue;
	}
	
	td#beforesun{
		font-size: 10pt;
		color: red;
		background-color: lavender;
	}
	td#aftersat{
		font-size: 10pt;
		color: blue;
		background-color: lavender;
	}
	td.before, td.after{
		font-size: 10pt;
		color: gray;
		background-color: lavender;
	}
	
	td#choice{
		text-align: left;
		vertical-align: middle;
	}
	
	td.holiday{
		background-color: MistyRose;
		color: red;
		font-weight: bold;
	}
	
	
	span{
		font-size: 8pt;
	}
	
	
	/* 하이퍼링트 스타일 지정
		link : 1번도 클릭하지 않은 하이퍼링크
		visited : 1번 이상 클릭한 하이퍼링크
		hover : 하이퍼링크에 마우스를 올리고 있을 떄
		active : 하이퍼링크를 마우스로 누르고 있을 때
		
		a:link와 a:visited에 같은 서식이 적용되므로 ,로 나열해서 지정 가능
		a:link, a:visited{
			color: black;
			text-decoration: none;
		}
	 */
	
	a {
		color: black;
		text-decoration: none;
	}
	
	a:hover {
		color: lime;
		/* text-decoration: overline; */ /*윗줄*/
	}
	
	a:active {
		color: DodgerBlue;
		/* text-decoration: line-through; */ /*가웃데 줄*/
	}
	
	
	/* https://www.w3schools.com */
	.button { /* 태그 상관없이 모든 클래스 */
	  background-color: #4CAF50; /* Green */
	  border: none;
	  color: white;
	  /* padding: 8px 16px; */
	  padding: 5px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  /* margin: 4px 2px; */
	  margin: 0;
	  transition-duration: 0.4s;
	  cursor: pointer;
	  border-radius: 10px;
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
	
	.select {
		width: 100px;
		height: 30px;
	}
	
	fieldset {
		width: 105 px;
		height: 50 px;
		display: inline;
		border: none;
	}
	
	
	table {
		/* border : 선두께, 선종류, 선색상 */
		border: 0px solid tomato;
	}

</style>

</head>
<body>

<%
	// 달력 메소드 테스트
	//out.println(MyCalendar.isLeapYear(2022));
	//out.println(MyCalendar.lastDay(2022, 9));
	//out.println(MyCalendar.totalDay(2022, 9, 13));
	
	
	// 컴퓨터 시스템의 년, 월 얻어오기
	Date date = new Date();
	int year = date.getYear() + 1900;
	int month = date.getMonth() + 1;
	int day = date.getDay();
	
	/* Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1; */
	//out.println(year +"년 " + month + "월");
	
	
	// 이전달, 다음달 하이터링크 또는 버튼이 클릭되면 get 방식으로 넘어오는 달력을 출력할 년, 월을 받는다.
	// 달력이 최초로 실행되면 이전페이지가 존재하지 않기 때문에 넘어오는 데이터가 없으므로 year와 month가 null이므로,
	// NumberFormatException이 발생된다 => 예외처리를 해야함
	try {
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		
		
		// month에 13이 넘어오면 달력에는 다음 해 1월을 표시해야 하고, month에 0이 넘어왔으면 달력에는 전년도 12월을 표시해야 함
		if (month >= 13){
			year++;
			month = 1;					
		} else if (month <= 0) {
			year--;
			month = 12;
		}
		
	} catch(NumberFormatException e){ }
	
	
	// 달력을 출력할 달의 양력/음력 대응 결과를 얻어온다.
	ArrayList<LunarDate> lunarDate = SolaToLunar.solaToLunar(year, month);
	
	
%>


<table width="700" border="1" align="center" cellpadding="5" cellspacing="0">
	<tr>
		<th>
		<!-- <a> 태그가 설정된 문자열을 클릭하면 href 속성에 지정된 곳으로 이동.
			 href 속성에 #뒤에 id(해시)를 지정하면 현재 문서에서 id가 지정된 요소로 이동(책갈피)하고,
			 url(주소)가 지정되면 지정된 url에 지정된 페이지로 이동하고, ?가 지정되면 현재 페이지 재로딩.
			 ? 뒤에 이동하는 페이지로 전달할 데이터를 넘겨주는데, 이때 넘겨줄 데이터가 2건 이상이면 데이터 사이에 &로 구분
			 ? 뒤에는 절대로 띄어쓰기를 쓰면 안된다. 
		-->
			 
			<%-- <a href="?year=<%=year%>&month=<%=month-1%>">이전달</a> --%> <!-- 하이퍼링크 -->
			<button class="button button1" type="button" onclick="location.href='?year=<%=year%>&month=<%=month-1%>'">이전달</button>
		</th>
		<th id="title" colspan="5">
			<%=year%>년 <%=month%>월
		</th>
		<th>
			<%-- <a href="?year=<%=year%>&month=<%=month+1%>">다음달</a> --%> <!-- 하이퍼링크 -->
			<input class="button button1" type="button" value="다음달" onclick="location.href='?year=<%=year%>&month=<%=month+1%>'">
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
			/* // 1일이 출력될 위치(요일)을 맞추기 위해 1일의 요일만큼 반복하며 빈칸 출력
			for(int i = 0; i <MyCalendar.weekDay(year, month, 1); i++) {
				out.println("<td></td>");
			} */
			
			// 1일이 출력될 위치(요일)을 맞추기 위해 1일의 요일만큼 반복하며 전달 날짜 출력
			int week = MyCalendar.weekDay(year, month, 1); // 달의 1일
			int start = 0;
			if (month == 1) {
				start = MyCalendar.lastDay(year - 1, 12) - week; // 1월 
			} else {
				start = MyCalendar.lastDay(year, month - 1) - week; // 2 ~ 12월 
			}
			for (int i = 1; i <= week; i++) {
				if (i == 1) {
					out.println("<td id='beforesun' >" + (month == 1 ? 12 : month-1) + "/" + (++start) + "</td>");
				} else {
					out.println("<td class='before'>" + (month == 1 ? 12 : month-1) + "/" + (++start) + "</td>");
				}
				
			}	

				
			
			// 1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력
			for(int i = 1; i <= MyCalendar.lastDay(year, month); i++){
				
				// 공휴일인가 판단해서 class 속성을 다르게 지정해서 날짜를 출력한다.
				if (lunarDate.get(i - 1).getHoliday().length() == 0) {
					switch (MyCalendar.weekDay(year, month, i)) {
						case 0:
							out.println("<td class='sun'>" + i + "</td>");
							break;
						case 6:
							out.println("<td class='sat'>" + i + "</td>");
							break;
						default:
							out.println("<td>" + i + "</td>");
							break;
					}
				} else {
					out.println("<td class='holiday'>" + i + lunarDate.get(i - 1).getHoliday() + "</td>");
				}
				
				if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
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
					 
					
					if (i == 6) {
						out.println("<td id ='aftersat' >" + (month == 12 ? 1 : month+1) + "/" + (++start) + "</td>");
					} else {
						out.println("<td class='after'>" + (month == 12 ? 1 : month+1) + "/" + (++start) + "</td>");
					}
				}
			}
		%>
	</tr>
	
	<!-- 년, 월을 선택하고 보기 버튼을 클릭하면 선택된 달의 달력으로 한번에 넘어가게 한다. -->
	<tr>
		<td id="choice" colspan="7">
			
			<form action="?" method="post">
			<fieldset>
				<legend>년</legend>
				<select class="select" name="year">
					<%
						for (int i = 1900; i <= 2100; i++){
							if (i == date.getYear() + 1900){
								out.println("<option selected='selected'>" + i + "</option>");
							} else {
								out.println("<option>" + i + "</option>");
							}
						}
					%>
				</select>
			</fieldset>
				
			<fieldset>
				<legend>월</legend>
				<select class="select" name="month">
					<%
						for (int i = 1; i <= 12; i++){
							if (i == date.getMonth()+1){
								out.println("<option selected='selected'>" + i + "</option>");
							} else {
								out.println("<option>" + i + "</option>");
							}
						}
					%>
				</select>
			</fieldset>
			
			<input class="select" type="submit" value="보기">
			</form>
			
		</td>
	</tr>
	
	
</table>
</body>
</html>