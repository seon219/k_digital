<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>

<!-- bootstrap -->
<meta name="viewpport" content="width=device-width, initial-scale=1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<form class="m-3" action="insertOK.jsp" method="post">
		<table class="table" style="width: 700px; margin-left: auto; margin-right: auto">
			<tr class="table-primary">
				<th colspan="3" style="font-size: 30px; text-align: center;">자유게시판</th>
			</tr>
			<tr>
				<th class="align-middle" width="100" style="text-align: center;">
					<label for="name">이름</label>
				</th>
				<td width="450">
					<input id="name" class="form-control" type="text" name="name" style="width: 300px">
				</td>
				<th class="align-middle" width="150">
					공지글 <input class="form-check-input" type="checkbox" name="notice" value="yes">
				</th>
			</tr>
			<tr>
				<th class="align-middle" width="100" style="text-align: center;">
					<label for="password">비밀번호</label>
				</th>
				<td colspan="2" width="450">
					<input id="password" class="form-control" type="password" name="password" style="width: 300px">
				</td>
			</tr>
			<tr>
				<th class="align-middle" width="100" style="text-align: center;">
					<label for="subject">제목</label>
				</th>
				<td colspan="2" width="450">
					<input id="subject" class="form-control" type="text" name="subject">
				</td>
			</tr>
			<tr>
				<th class="align-middle" width="100" style="text-align: center;">
					<label for="content">내용</label>
				</th>
				<td colspan="2" width="450">
					<textarea rows="10" id="content" class="form-control" name="content" style="resize: none"></textarea>
				</td>
			</tr>
			<tr class="table-primary">
				<td colspan="3" align="center">
					<input class="btn btn-light btn-outline-primary" type="submit" value="저장">
					<input class="btn btn-light btn-outline-danger" type="reset" value="다시쓰기">
					<input class="btn btn-light btn-outline-success" type="button" value="돌아가기" onclick="history.back()">
				</td>
			</tr>
		</table>
		
		<!-- 접속자 ip 주소는 hidden으로 insertOK.jsp로 넘긴다. -->
		<input type="hidden" name="ip" value="${pageContext.request.remoteAddr}">
		
	</form>

</body>
</html>