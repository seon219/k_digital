<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
	request.setCharacterEncoding("UTF-8");
	
	//Date date = new Date();
	//out.println(date + "<br/>");
	%>
	
	<!--  
		useBean 액션 태그로 new를 사용하지 않고 객체를 만들 수 있다.
		id 속성에는 만들려는 객체의 이름을 쓴다.
		class 속성에는 객체를 만들려하는 클래스의 이름을 반드시 풀 패키지 이름과 같이 써야 한다.
		액션 태그는 xml 문법을 따르기 때문에 <tag>와 </tag> 사이에 아무런 내용이 코딩되지 않을 경우
		</tag>를 생략할 수 있는데 그냥 지우면 에러가 발생되므로 <tag>의 끝에 /를 입력해서 <tag />와 같은 형태로 만들면 된다.
	-->
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	${date}<br/>
	
	<!-- MemberVO vo = new MemberVO();와 같이 useBean을 사용해서 객체를 만든다. -->
	<jsp:useBean id="vo" class="com.tjoeun.useBean.MemberVO">
		<!-- 
			setProperty 액션 태그는 지정한 필드의 setter 메소드를 실행
			property 속성에는 setter 메소드를 실행할 필드 이름을 쓴다.
			name 속성에는 setter 메소드를 실행할 필드가 정의된 객체 이름을 쓴다.
			useBean 액션 태그를 사용하면 이전 페이지에서 form에 저장되서 넘어오는 데이터를 받는 동작을
			별도로 코딩하지 않아도 자동으로 받아서 처리
		 -->
		<%-- 
		<jsp:setProperty property="id" name="vo"/>
		<jsp:setProperty property="name" name="vo"/>
		<jsp:setProperty property="password" name="vo"/>
		<jsp:setProperty property="age" name="vo"/>
		<jsp:setProperty property="gender" name="vo"/>
		<jsp:setProperty property="ip" name="vo"/> 
		--%>
		
		
		<!--  
			property 속성에 *을 입력하면 모든 필드의 setter 메소드가 실행된다.
			단, form name 속성의 속성값과 같은 이름을 가지는 필드의 setter 메소드만 실행된다.
		-->
		<jsp:setProperty property="*" name="vo"/> 
		
	</jsp:useBean>
	${vo}<br/>
	
</body>
</html>