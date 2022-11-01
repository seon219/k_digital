<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 --> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> <!-- 함수 --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 보기</title>

<style type="text/css"> 

	a{
		color: black;
		text-decoration: none;
	}
	
	a:hover {
		color: dodgerblue;
		text-decoration: none;
	}

</style>

</head>
<body>

	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th colspan="5">게시판 보기</th>
		</tr>
		<tr>
			<td colspan="5" align="right">
				${boardList.totalCount}(${boardList.currentPage} / ${boardList.totalPage})
			</td>
		</tr>
		<tr>
			<th width="70">글번호</th>
			<th width="600">제목</th>
			<th width="130">이름</th>
			<th width="130">작성일</th>
			<th width="70">조회수</th>			
		</tr>
		
		<c:set var="list" value="${boardList.list}"/>
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5">
					<marquee>테이블에 저장된 글이 없습니다.</marquee>
				</td>
			</tr>
		</c:if>
	
		<c:if test="${list.size() != 0}">
			<c:forEach var="vo" items="${list}">
				<tr>
					<td align="center">${vo.idx}</td>
					<td>
						<!-- 글 레벨에 따른 들여쓰기 -->
						<c:if test="${vo.lev > 0}">
							<c:forEach var="i" begin="1" end="${vo.lev}" step="1">
								&nbsp;&nbsp;&nbsp;
							</c:forEach>
							Re.
						</c:if>
						<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"></c:set>
						<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"></c:set>
						<a href="increment.nhn?idx=${vo.idx}&currentPage=${boardList.currentPage}">
							${subject}
						</a>
					</td>
					<td align="center">
						<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"></c:set>
						<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"></c:set>
						${name}
					</td>
					<td align="center">
						<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
					</td>
					<td align="center">
						${vo.hit}
					</td>
				</tr>
			</c:forEach>
		</c:if>
		
		 <!-- 페이지 이동 버튼 -->
		<tr>
			<td colspan="6" align="center">
			
				<!-- ================처음으로========================= -->
				<c:if test="${boardList.currentPage > 1}">
					<button type="button" 
							class="button button1" 
							title="첫 페이지로 이동하기" 
							onclick="location.href='?currentPage=1'">처음
					</button>
				</c:if>
				
				<c:if test="${boardList.currentPage <= 1}">
					<button type="button" 
							class="button button2" 
							disabled="disabled" 
							title="이미 첫 페이지 입니다.">처음
					</button>
				</c:if>
				
				
				<!-- ================10페이지 앞으로========================= -->
				<c:if test="${boardList.startPage > 1}">
					<button 
						class="button button1"
						type="button" 
						title="10페이지 전으로 이동하기" 
						onclick="location.href='?currentPage=${boardList.startPage - 1}'">이전
					</button>
				</c:if>
				
				<c:if test="${boardList.startPage <= 1}">
					<button type="button" 
							class="button button2" 
							disabled="disabled" 
							title="이미 첫 10페이지 입니다.">이전
					</button>
				</c:if>
				
				
				<!-- ================이동 페이지========================= -->
				<c:forEach var="i" begin="${boardList.startPage}" end="${boardList.endPage}" step="1">
					<c:if test="${boardList.currentPage == i}">
						<button type="button" class="button button2" disabled="disabled">${i}</button>
					</c:if>
					
					<c:if test="${boardList.currentPage != i}">
						<button type="button" 
								class="button button1" 
								onclick="location.href='?currentPage=${i}'">${i}</button>
					</c:if>
				</c:forEach>
				
				
				<!-- ================10페이지 뒤로========================= -->
				<c:if test="${boardList.endPage < boardList.totalPage}">
					<button type="button" 
							class="button button1" 
							title="10페이지 뒤로 이동하기" 
							onclick="location.href='?currentPage=${boardList.endPage + 1}'">다음
					</button>
				</c:if>
				
				<c:if test="${boardList.endPage >= boardList.totalPage}">
					<button type="button" 
							class="button button2" 
							disabled="disabled" 
							title="이미 마지막 10페이지 입니다.">다음
					</button>
				</c:if>

				
				<!-- ================마지막으로========================= -->
				<c:if test="${boardList.currentPage < boardList.totalPage}">
					<button type="button" 
							class="button button1" 
							title="마지막 페이지로 이동하기" 
							onclick="location.href='?currentPage=${boardList.totalPage}'">마지막
					</button>
				</c:if>
				
				<c:if test="${boardList.currentPage >= boardList.totalPage}">
					<button type="button" 
							class="button button2" 
							disabled="disabled" 
							title="이미 마지막 페이지 입니다.">마지막
					</button>
				</c:if>
			</td>
		</tr>
	</table>

</body>
</html>