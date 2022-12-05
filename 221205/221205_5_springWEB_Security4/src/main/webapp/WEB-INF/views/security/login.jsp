<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>login.jsp</h1>

	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>${pageContext.request.userPrincipal.name} is Login</p>
	</c:if>
	
	<!-- spring-security-taglibs를 사용해 ROLE_USER 그룹으로 들어온 사용자가 있나 확인한다. -->
	<s:authorize ifAnyGranted="ROLE_USER">
		<p><s:authentication property="name"/> is Login</p>
	</s:authorize>

	<c:if test="${empty pageContext.request.userPrincipal}">
		<p>${pageContext.request.userPrincipal.name} is Login</p>
	</c:if>
	
	<!-- spring-security-taglibs를 사용해 ROLE_USER 그룹으로 들어온 사용자가 없나 확인한다. -->
	<s:authorize ifNotGranted="ROLE_USER">
		<p>is Logout</p>
	</s:authorize>

	<%-- USER ID: ${pageContext.request.userPrincipal.name}<br/> --%>
	<!-- spring-security-taglibs를 사용해 id를 출력한다. -->
	<%-- USER ID: <s:authentication property="name"/><br/> --%>
	
	<a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a><br/>

</body>
</html>









