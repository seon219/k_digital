<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jstl을 사용하겠다고 알려준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 --> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정할 글 확인</title>
</head>
<body>

	<!-- 수정할 글을 화면에 보여주고 비밀번호를 입력받아 실제로 글을 수정하는 페이지로 넘겨준다. -->
	<fmt:requestEncoding value="UTF-8"/>
	
	<form action="updateOK.jsp" method="post">
		<table width="600" alian="center" border="1" cellpading="5" cellspacing="0">
			<tr>
				<th colspan="2">수정할 글 확인</th>
			</tr>
			<tr>
				<th width="100">
					<label for="name"> 이름 </label>
				</th>
				<td width="500">
					<input type="text" name="name" value="${fn:trim(vo.name)}">
				</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>
					<fmt:formatDate value="${vo.writeDate}" pattern="yyyy년 MM월 dd일 E요일 a h시 mm분"/>
				</td>
			</tr>
			<tr>
				<th>
					<label for="memo">메모</label> 
				</th>
				<td>
					<textarea rows="10" name="memo" style="resize: none; width: 98%">${vo.memo}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<label>
						비밀번호 <input type="password" name="password">
					</label>
					<input type="submit" value="수정하기">
					<input type="reset" value="다시쓰기">
					<input type="button" value="돌아가기" onclick="history.back()"/>
				</td>
			</tr>
		</table>
		
		<!-- 수정할 글번호와 수정 후 돌아갈 페이지 번호를 form에 hidden으로 저장해서 수정하는 페이지로 넘긴다. -->
		<input type="hidden" name="idx" value="${vo.idx}">
		<input type="hidden" name="currentPage" value="${currentPage}">
		
	</form>

</body>
</html>