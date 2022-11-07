<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한국을 빛낸 100명의 위인들</title>

<link rel="icon" href="./image/logo.png">
<link rel="stylesheet" href="./css/fetch.css">

</head>
<body>

	<h2><a href="./summary.jsp">한국을 빛낸 100명의 위인들</a></h2>
	
	<ol>
		<!-- <li><a href="./1.jsp">1절 가사</a></li> -->
		<!-- <li><a href="#" onclick="document.getElementsByTagName('div')[0]">1절 가사</a></li> -->
		<li><a href="#" onclick="document.querySelectorAll('div')[0].innerHTML='아름다운 이 땅에 금수강산에~'">1절 가사</a></li>
		<li><a href="./2.jsp">2절 가사</a></li>
		<li><a href="./3.jsp">3절 가사</a></li>
		<li><a href="./4.jsp">4절 가사</a></li>
		<li><a href="./5.jsp">5절 가사</a></li>
	</ol>
	
	<div>
		가사가 출력될 영역
	</div>

</body>
</html>