<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제할 글 보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

</head>
<body>

	<fmt:requestEncoding value="UTF-8"/>
	
	<form action="deleteOK.jsp" method="post">
		<div class="m-3">
		<table class="table table-bordered" style="width: 700px; margin-left: auto; margin-right: auto;">
			<tr class="table-primary">
				<th colspan="4" style="font-size: 30px; text-align: center;">삭제할 글 확인</th>
			</tr>
			
			<tr class="table-info">
				<th style="width: 100px; text-align: center;">글번호</th>
				<th style="width: 350px; text-align: center;">이름</th>
				<th style="width: 150px; text-align: center;">작성일</th>
				<th style="width: 100px; text-align: center;">조회수</th>
			</tr>
			
			<tr>
				<td align="center">
					${vo.idx}
				</td>
				
				<td align="center">
					<!-- 이름에 tag를 적용할 수 없게 한다. -->
					<c:set var="name" value="${fn:replace(vo.name, '<', '%lt;')}"></c:set>
					<c:set var="name" value="${fn:replace(name, '>', '%gt;')}"></c:set>
					${name}
				</td>
				
				<td align="center">
					<jsp:useBean id="date" class="java.util.Date"/>
					<!-- 오늘 입력된 글은 시간만, 어제 입력된 글은 날짜만 출력 -->
					<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
						<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm:ss"/>
					</c:if>
					
					<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month || date.date != vo.writeDate.date}">
						<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
					</c:if>
				</td>
				
				<td align="center">
					${vo.hit}
				</td>
			</tr>
			
			<tr>
				<th class="align-middle" style="text-align: center;">제목</th>
				<td colspan="3">
					<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"></c:set>
					<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"></c:set>
					${subject}
				</td>
			</tr>
			
			<tr>
				<th class="align-middle" style="text-align: center;">내용</th>
				<td colspan="3" align="left">
					<c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"></c:set>
					<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"></c:set>
					<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"></c:set>
					${content}
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="row g-3 align-items-center" style="width: 90%; margin-left: auto; margin-right: auto;">
					
						<div class="col-auto">
							<label for="password" class="col-form-label">비밀번호</label>
						</div>
						<div class="col-auto">
							<input id="password" class="form-control form-control-sm" type="password" name="password">
						</div>
					
					
						<div class="col-auto">
							<input class="btn btn-light btn-outline-danger" type="submit" value="삭제하기">
							<input class="btn btn-light btn-outline-primary" type="reset" value="다시쓰기">
							<input class="btn btn-light btn-outline-success" type="button" value="이전" onclick="history.back()">	
							<input class="btn btn-light btn-outline-success" type="button" value="목록" 
								onclick="location.href='list.jsp?idx=${idx}&currentPage=${currentPage}'">	
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	
	<input type="hidden" name="idx" value="${vo.idx}">
	<input type="hidden" name="currentPage" value="${currentPage}">
	
	</form>

</body>
</html>