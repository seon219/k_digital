<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<script type="text/javascript" src="./js/setting.js" defer="defer"></script>

</head>
<body>

	<div class="m-3">
		<table class="table table-bordered" style="width: 700px; margin-left: auto; margin-right: auto;">
			<tr class="table-primary">
				<th colspan="4" style="font-size: 30px; text-align: center;">게시글 보기</th>
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
					<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"></c:set>
					<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"></c:set>
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
				<th style="text-align: center;">제목</th>
				<td colspan="3">
					<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"></c:set>
					<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"></c:set>
					${subject}
				</td>
			</tr>
			
			<tr>
				<th class="align-middle" style="text-align: center;">내용</th>
				<td colspan="3">
					<c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"></c:set>
					<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"></c:set>
					<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"></c:set>
					${content}
				</td>
			</tr>
			<tr class="table-primary">
				<td colspan="4" align="center">
					<input class="btn btn-light btn-outline-primary" type="button" value="수정하기" 
						   onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${currentPage}&job=update'">
					<input class="btn btn-light btn-outline-danger" type="button" value="삭제하기"
						   onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${currentPage}&job=delete'">
					
					<!-- history.back, history.go(-1)을 사용하면 단순히 전 화면으로 돌아가서 증가된 조회수가 반영되지 않는다. -->
					<input class="btn btn-light btn-outline-success" type="button" value="돌아가기" onclick="location.href='list.jsp?currentPage=${currentPage}'">
				</td>
			</tr>
		</table>
	</div>
	
	<hr style="width: 700px; margin-left: auto; margin-right: auto;"/>
	
	
	<!-- 댓글 폼 -->
	<form class="m-3" action="commentOK.jsp" method="post" name="commentForm">
		<table class="table table-bordered" style="width: 700px; margin-left: auto; margin-right: auto;">
			<tr class="table-success">
				<th colspan="4">댓글쓰기</th>
			</tr>
			
			<!-- 이 줄은 화면에 표시되지 않는 줄로 작업이 끝나면 표시되지 않게 한다. -->
			<tr>
			<!-- <tr style="display:none;"> -->
				<td colspan="4"> 
					<!-- 수정 또는 삭제할 댓글의 글번호를 넘겨준다. -->
					idx: <input type="text" name="idx" value="${vo.idx}" size="1">
					
					<!-- 현재 댓글이 어떤 메인글에 댓글인지 넘겨준다. -->
					gup: <input type="text" name="gup" value="${vo.idx}" size="1">
					
					<!-- 작업모드. 1 => 댓글저장, 2 => 댓글 수정, 3 => 댓글 삭제 -->
					mode: <input type="text" name="mode" value="1" size="1">
					
					<!-- 메인글이 표시되던 페이지 번호 -->
					currentPage: <input type="text" name="currentPage" value="${currentPage}" size="1">
					
					<!-- 댓글 작성자의 ip 주소를 넘겨준다. -->
					ip: <input type="text" name="ip" value="${pageContext.request.remoteAddr}" size="10">
				</td>
			</tr>
			
			<!-- 댓글 입력, 수정, 삭제에 사용 -->
			<tr>
				<td class="align-middle" style="width: 100px; text-align: center;" >
					<label for="name">이름</label>
				</td>
				<td style="width: 250px;">
					<input id="name" class="form-control" type="text" name="name"/> 
				</td>
				<td class="align-middle" style="width: 100px; text-align: center;">
					<label for="password">비밀번호</label>
				</td>
				<td style="width: 250px;">
					<input id="password" class="form-control" type="password" name="password"/> 
				</td>
			</tr>
			<tr>
				<td class="align-middle" style="width: 100px; text-align: center;">
					<label for="content">내용</label>
				</td>
				<td style="width: 600px;" colspan="3">
					<textarea id="content" class="form-control" rows="3" name="content" style="resize: none;"></textarea> 
				</td>
			</tr>
			<tr class="table-success">
				<td colspan="4" align="center">
					<input class="btn btn-light btn-outline-success" type="submit" name="commentBtn" value="저장">
					<input class="btn btn-light btn-outline-danger" type="button" value="다시쓰기" onclick="setting(0, 1, '저장', '', '')">
				</td>
			</tr>
			
			
			<!-- 댓글을 출력 -->
			<c:set var="comment" value="${freeboardCommentList.list}"></c:set>
			
			<!-- 댓글이 없는 경우 -->
			<c:if test="${comment.size() == 0}">
				<tr>
					<td colspan="4">
						<marquee> 댓글이 없습니다. </marquee>
					</td>
				</tr>
			</c:if>
			<!-- 댓글이 있는 경우 -->
			<c:if test="${comment.size() != 0}">
				<c:forEach var="co" items="${comment}">
					<tr>
						<td colspan="4">
							${co.idx}.
							
							<c:set var="name" value="${fn:replace(co.name, '<', '&lt;')}"></c:set>
							<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"></c:set>
							${name}님이 
							
							<fmt:formatDate value="${co.writeDate}" pattern="yyyy.MM.dd(E) HH:mm:ss"/>에 남긴 글 <br/>
							
							<c:set var="content" value="${fn:replace(co.content, '<', '&lt;')}"></c:set>	
							<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"></c:set>
							<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"></c:set>
							${content} <br/>
							
							<div align="right">
								<input class="btn btn-outline-primary" type="button" value="수정" onclick="setting(${co.idx}, 2, '수정', '${name}', '${content}')">
								<input class="btn btn-outline-danger" type="button" value="삭제" onclick="setting(${co.idx}, 3, '삭제', '${name}', '${content}')">
							</div>
							
						</td>
					</tr>
					
				</c:forEach>
			</c:if>
			
		</table>
	</form>
	
	
</body>
</html>