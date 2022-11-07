<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한국을 빛낸 100명의 위인들</title>

<link rel="icon" href="./image/logo.png">
<link rel="stylesheet" href="./css/fetch.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="./js/fetch4.js"></script>

</head>
<body>

	<!-- hash 사용 -->
	<!-- html은 #(hash)은 북마크 기능이 있기 때문에 다른 북마크와 구별하기 위해 '#' 뒤에 '!'를 붙여준다. -->
	<!-- '!'을 뱅이라 부른다. -->

	<h2><a href="#!summary" onclick="fetchAjax('summary')">한국을 빛낸 100명의 위인들</a></h2>
	
	<ol>
		<li><a href="#!1" onclick="fetchAjax('1')">1절 가사</a></li>
		<li><a href="#!2" onclick="fetchAjax('2')">2절 가사</a></li>
		<li><a href="#!3" onclick="fetchAjax('3')">3절 가사</a></li>
		<li><a href="#!4" onclick="fetchAjax('4')">4절 가사</a></li>
		<li><a href="#!5" onclick="fetchAjax('5')">5절 가사</a></li>
	</ol>
	
	<div>
		가사가 출력될 영역
	</div>

</body>
</html>