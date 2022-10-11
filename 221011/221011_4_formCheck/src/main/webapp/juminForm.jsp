<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민등록번호 유효성 검사</title>

<script type="text/javascript" src="./juminForm.js" defer="defer"></script>

</head>
<body>

	<!--  
		onsubmit 이벤트는 form에 submit 버튼이 클릭되면 실행되는 이벤트
		form check는 submit 버튼이 클릭되면 실행되는 onsubmit 이벤트에서 javasctipt 함수를 실행해서,
		 form에 입력된 데이터가 정상적인 데이터인지 유효성 검사해서 결과가 정상이면 true, 오류가 발생되면 false 리턴
		onsubmit = "return javascript함수(this)" 형태로 코딩하며 javascript 함수의 실행 결과 return 값이 true이면,
		 action 속성으로 지정한 페이지로 넘겨주고, return 값이 false이면 현재 페이지에 그대로 머물러 있는다.
	-->

	<form action="juminFormOK.jsp" method="post" name="juminForm" onsubmit="return formCheck(this)">
	
		<!--  
			onkeypress => 키보드를 누르고 있을 떄 실행되는 이벤트
			onkeydown =>  키보드를 누르는 순간 실행되는 이벤트
						  누른 키보드에 해당되는 문자가 입력되기 전에 실행
			onkeyup => 	  키보드를 눌렀다가 손가락이 떨어지는 순간 실행되는 이벤트
						  누른 키보드에 해당되는 문자가 입력된 후 실행
		-->
	
		<input type="text" name="j1" maxlength="6" placeholder="주민등록번호 앞자리" onkeyup="moveNext(this, 6, document.juminForm.j2)">
		-
		<input type="text" name="j2" maxlength="7" placeholder="주민등록번호 뒷자리" onkeyup="moveNext(this, 7, document.juminForm.sendBtn)">
		<input type="submit" value="검사하기" name="sendBtn">
	</form>

</body>
</html>