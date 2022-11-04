<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery ajax</title>

<meta name="viewpport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="./images/logo.png"/>
<link rel="stylesheet" href="./css/bootstrap.css"/>

<script type="text/javascript" src="./js/jquery-3.6.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript" src="./js/ajax.js"></script>

</head>
<body>

	<div class="container" style="margin-top: 20px;">
		<form action="./userRegister" method="post"> <!-- ① -->
			<table class="table table-hover table-bordered" style="border: 1px solid #dddddd;">
				<thead>
					<th class="success" colspan="3" style="text-align: center;">
						<h2>회원 가입 양식</h2>
					</th>
				</thead>
				
				<tbody>
					<tr>
						<th class="danger" style="vertical-align: middle; width: 120px;">아이디</th>
						<td>
							<input id="userid" class="form-control" type="text" name="userid" placeholder="아이디를 입력하세요" autocomplete="off"/>
						</td>
						<td class="info" style="text-align: center; width: 120px;">
							<button class="btn btn-primary" type="button" onclick="registerCheckFunction()">중복검사</button>
						</td>
					</tr>
					<tr>
						<th class="danger" style="vertical-align: middle">비밀번호</th>
						<td colspan="2">
							<input id="userpassword1" class="form-control" type="password" name="userpassword1" 
									placeholder="비밀번호를 입력하세요" onkeyup="passwordCheckFunction()"/>
						</td>
					</tr>
					<tr>
						<th class="danger" style="vertical-align: middle">비밀번호 확인</th>
						<td colspan="2">
							<input id="userpassword2" class="form-control" type="password" name="userpassword2" 
									placeholder="비밀번호를 한 번 더 입력하세요" onkeyup="passwordCheckFunction()"/>
						</td>
					</tr>
					<tr>
						<th class="danger" style="vertical-align: middle">이름</th>
						<td colspan="2">
							<input id="username" class="form-control" type="text" name="username" 
									placeholder="이름을 입력하세요" autocomplete="off"/>
						</td>
					</tr>
					<tr>
						<th class="danger" style="vertical-align: middle">나이</th>
						<td colspan="2">
							<input id="userage" class="form-control" type="text" name="userage" 
									placeholder="나이를 입력하세요" autocomplete="off"/>
						</td>
					</tr>
					<tr>
						<th class="danger" style="vertical-align: middle">성별</th>
						<td colspan="2">
							<div class="form-group" style="margin: 0 auto;">
								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-success active">
										<input type="radio" name="usergender" value="남자" checked="checked"> &nbsp; 남자
									</label>
									<label class="btn btn-success">
										<input type="radio" name="usergender" value="여자"> &nbsp; 여자
									</label>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th class="danger" style="vertical-align: middle">이메일</th>
						<td colspan="2">
							<input id="useremail" class="form-control" type="email" name="useremail" 
									placeholder="이메일을 입력하세요" autocomplete="off"/>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align: center;">
							<!-- 비밀번호 일치 검사 결과 메시지가 출력될 영역 -->
							<h5 id="passwordCheckMessage" style="color: tomato; font-weight: bold;"></h5>
							<!-- 아이디 중복 검사 결과 메시지가 출력될 영역 -->
							<h5 id="idCheckMessage" style="color: tomato; font-weight: bold;"></h5>
							<!-- 오류 메시지가 출력될 영역 -->
							<h5 id="errorMessage" style="color: tomato; font-weight: bold;">
								<%-- ${messageType} : --%> ${messageContent}
							</h5>
							
							<input class="btn btn-primary" type="submit" value="회원가입"> &nbsp; <!-- ① -->
							<input class="btn btn-primary" type="reset" value="다시쓰기">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

	<%
		// session에 저장된 메시지 출력
		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String) session.getAttribute("messageType");
			//out.println("messageType: " + messageType + "<br/>");
		}
		
		String messageContent = null;
		if (session.getAttribute("messageContent") != null) {
			messageContent = (String) session.getAttribute("messageContent");
			//out.println("messageContent: " + messageContent + "<br/>");
		}
		
		
		// session에 메시지가 있으면 메시지를 표시하는 모달(팝업)창을 띄운다.
		if (messageContent != null) {
			%>
			<div id="messageModal" class="modal fade" role="dialog" aria-hidden="true">
				<div class="vartical-alignment-helper">
					<div class="modal-dialog vertical-align-center">
						<!-- 모달 창의 종류를 설정 -->
						<!-- class 속성에 panel-warning 또는 panel-success 스타일을 추가 -->
						<div class="modal-content 
						<%
							if (messageType.equals("오류 메시지")){
								out.println("panel-warning");
							} else {
								out.println("panel-success");								
							}
						%>
						">
							
							<!-- 헤더 -->
							<div class="modal-header panel-heading">
								<!-- 헤더 오른쪽 상단에 "x" 버튼 -->
								<button class="close" type="button" data-dismiss="modal">
									<span aria-hidden="true">&times;</span>
									<span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title">
									${messageType}
								</h4>
							</div>
							
							<!-- 바디 -->
							<div class="modal-body">
								${messageContent}
							</div>
							
							<!-- 풋터 -->
							<div class="modal-footer">
								<button class="btn btn-primary" type="button" data-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<script type="text/javascript">
				$('#messageModal').modal('show');
			</script>
			
			<%
			// 메시지를 모달창에 출력했으므로 session에 저장된 메시지를 지운다.
			session.removeAttribute("messageType");
			session.removeAttribute("messageContent");
			
		} 
	%>

</body>
</html>