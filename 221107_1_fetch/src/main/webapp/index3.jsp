<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한국을 빛낸 100명의 위인들</title>

<link rel="icon" href="./image/logo.png">
<link rel="stylesheet" href="./css/fetch.css">
<script type="text/javascript" src="./js/fetch3.js"></script>

</head>
<body>

	<h2><a onclick="fetchAjax('summary')">한국을 빛낸 100명의 위인들</a></h2>
	
	<ol>
		<li><a onclick="fetchAjax('1')">1절 가사</a></li>
		<li><a onclick="fetchAjax('2')">2절 가사</a></li>
		<li><a onclick="fetchAjax('3')">3절 가사</a></li>
		<li><a onclick="fetchAjax('4')">4절 가사</a></li>
		<li><a onclick="fetchAjax('5')">5절 가사</a></li>
	</ol>
	
	<div>
		가사가 출력될 영역
	</div>

</body>
</html>