<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- html 주석: 지정 => ctrl + shift + /, 해제 => ctrl + shift + \ -->
<%-- jsp 주석 : jsp 요소는 html 주석으로 주석 설정이 되지 않는다 --%>
<%--
	<%@ ~ %> : 디렉티브 => 대부분 자동으로 입력. import 같이 설정에 관련된 정보
	<%! ~ %> : 선언부 => 프로그램에서 사용할 변수나 메소드를 정의 => java 파일로 뽑아내서 사용
	<%= ~ %> : 표현식 => 변수에 저장된 결과나 연산 결과를 출력 => EL(${ ~ })로 대체해서 사용
	<% ~ %> : 스크립트 릿 => 일반적인 jsp코드를 적는다 => jspl로 대체해서 사용
 --%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfo</title>
</head>
<body>

<!--  
	html은 spacebar를 여러번 입력해도 1칸밖에 떨어지지 않고, enter 키를 여러번 눌러도 줄이 변경되지 않는다.
	2칸 연속해서 띄우려면 &nbsp;를 띄울 칸의 개수만큼 입력하고 줄을 바꾸려면 <br>을 입력한다.
-->

myInfo.jsp &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;입니다. <br><br><br><br><br>반갑습니다.

<!-- 
	현재 페이지에 입력한 데이터를 특정 페이지로 전송하려면 전송할 데이터를 입력하는 코드를 <form> ~ </form> 사이에 작성
	▶ action 속성은 전송(type = "submit") 버튼이 클릭되면 form에 입력한 데이터를 가지고 넘어갈 jsp 페이지 이름을 쓴다.
	 => "?"만 입력하면 현재 페이지를 의미
	▶method 속성은 action페이지로 데이터가 전송될 때 정보가 url(주소)창에 표시되는 여부를 지정
	action 속성의 기본값은 "get"이고, get은 전송되는 데이터가 url 창에 표시되고 "post"로 변경하면 url 창에 표시되지 않음
	
 -->


<form action="myInfoOk.jsp" method="post">
	<label>이름 : <input type="text" name="name"></label><br>
	<label>아이디 : <input type="text" name="id"></label><br>
	<!-- type = "password"일 경우 한글을 타이핑해서 넣을 수 없다. -->
	<label>비밀번호 : <input type="password" name="password"></label><br>
	<label>나이 : <input type="text" name="age"></label><br><br>
	
	
	
	<!-- radio와 checkbox는 같은 그룹끼리 같은 이름의 name 속성을 지정해서 그룹으로 묶어야 함 
		 radio는 하나만 선택 가능하고, check박스는 여러개 선택 가능
		 checked="checked" 속성을 지정하면 브라우저에 표시될 때 기본값으로 선택 여부를 지정할 수 있다.	
	-->
	
	<fieldset style ="width: 120px;"> <!-- 칸조절 -->
		<legend>성별</legend>
		<input type = "radio" name = "gender" value="남자" checked="checked">남자 <!-- 성별로 묶어주고, value를 통해 남자/여자 구분 -->
		<input type = "radio" name = "gender" value="여자">여자	
	</fieldset> <br>
	
	<fieldset style ="width: 200px;">
		<legend>취미</legend>
		<input type="checkbox" name = "hobbies" value="등산">등산
		<input type="checkbox" name = "hobbies" value="바둑">바둑
		<input type="checkbox" name = "hobbies" value="낚시">낚시
	</fieldset> <br>
	
	
	<!-- 콤보상자나 목록상자는 별도의 스타일을 지정하지 않으면 option 태그에 입력한 문자열 중 가장 긴 문자열 길이에 맞춰서
		 콤보상자나 목록상자의 크기가 결정된다.
		 콤보상자나 목록상자에 selected="selected" 속성을 지정하면 기본값으로 선택되게 할 수 있다.
		 select 태그에 multiple="multiple" 속성을 지정하면 목록상자가 만들어진다.  -->
	
	
	
	<!-- 콤보상자 만들기 -->
	<select name="trip" style ="width: 200px; height: 30">
		<option>괌</option>	
		<option>코타키나발루</option>	
		<option>다낭</option>	
		<option>나트랑</option>	
		<option>보라카이</option>	
		<option>푸꾸욱</option>			
	</select> <br>
	
	
	
	<!-- 목록상자 만들기 -->
	<!-- 목록상자에 표시되는 아이템의 개수는 4개가 기본이고 size 속성을 지정하면 지정한만큼 표시된다. -->
	<select name="travel" style ="width: 200px;" multiple="multiple" size="6">
		<option>괌</option>	
		<option selected="selected">코타키나발루</option>	
		<option>다낭</option>	
		<option>나트랑</option>	
		<option>보라카이</option>	
		<option>푸꾸욱</option>			
	</select> <br><br>
	
	
	
	<!-- textarea는 value 속성이 없다. <textarea> ~ </textarea> 사이를 value로 취급한다. -->
	메모<br>
	<textarea rows="10" cols="60" name="content" style="resize: none;"></textarea> <br><br>
	
	
	
	<input type="submit" value="정보보기">
	<input type="reset" value="다시쓰기">
	<input type="button" value="그냥버튼">
	
	<button type = "submit">정보보기</button>
	<button type = "reset">다시쓰기</button>
	<button type = "button">그냥버튼</button>
	


</form>


</body>
</html>