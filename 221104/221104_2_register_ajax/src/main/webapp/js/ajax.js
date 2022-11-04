// 비밀 번호가 일치하는지 확인하는 함수
function passwordCheckFunction() {
	let userPassword1 = $('#userpassword1').val();
	let userPassword2 = $('#userpassword2').val();
	//console.log('userPassword1: ' + userPassword1 + ', userPassword2: ' + userPassword2);
	
	if (userPassword1 != userPassword2) {
		$('#passwordCheckMessage').html('비밀번호가 일치하지 않습니다.');
	} else {
		$('#passwordCheckMessage').html('');	
	}
}


//==========================================================================================
// 회원가입을 실행하는 함수
function userRegister() {
	let userid = $('#userid').val();
	let userpassword1 = $('#userpassword1').val();
	let userpassword2 = $('#userpassword2').val();
	let username = $('#username').val();
	let userage = $('#userage').val();
	let usergender = $('input[name=usergender]:checked').val();
	let useremail = $('#useremail').val();
	//console.log(userid, userpassword1, userpassword2, username, userage, usergender, useremail);
	
	
	// jQuery ajax
	$.ajax({
		type: 'POST', // 요청방식
		url: './userRegister', // 요청할 서블릿
		data: {// 서블릿으로 전송할 데이터
			// 변수명: 값
			userid: userid,
			userpassword1: userpassword1,
			userpassword2: userpassword2,
			username: username,
			userage: userage,
			usergender: usergender,
			useremail: useremail
		},
		
		// ajax 요청이 성공하면 response.getWrite().wrute(문자열)의 문자열이 콜백 함수의 인수로 넘어온다.
		success : response => { // ajax 요청이 성공하면 실행할 콜백 함수
			//console.log('요청성공');
			
			// 다음 데이터 입력을 받기 위해서 텍스트 상자의 내용을 지운다. => 새로고침이 되지 않기 떄문에 직접 지워야 한다.
			$('#userid').val('');
			$('#userpassword1').val('');
			$('#userpassword2').val('');
			$('#username').val('');
			$('#userage').val('');
			$('#useremail').val('');
			
			// 서블릿 응답에 따른 작업을 실행
			switch (response) {
				case '1': // 모든 내용 입력
					$('#messageType').html('에러 메시지');
					$('#messageContent').html('모든 내용을 입력하세요.');
					$('#messageCheck').attr('class', 'modal-content panel-warning');
					break;
				case '2': // 비밀번호 일치여부
					$('#messageType').html('에러 메시지');
					$('#messageContent').html('비밀번호가 일치하지 않습니다.');
					$('#messageCheck').attr('class', 'modal-content panel-info');
					break; 
				case '3': // 정상적으로 실행되었을 때
					$('#messageType').html('성공 메시지');
					$('#messageContent').html('회원 가입에 성공했습니다.');
					$('#messageCheck').attr('class', 'modal-content panel-success');
					break;
				case '4': // 중복되는 id 일 때
					$('#messageType').html('에러 메시지');
					$('#messageContent').html('이미 존재하는 회원입니다.');
					$('#messageCheck').attr('class', 'modal-content panel-danger');
					break;
			}
			
			// 회원 가입상태 모달창을 띄운다.
			$('#messageModal').modal('show');
		},
		// ajax 요청이 실패하면 에러 정보가 콜백 함수의 인수로 넘어온다.
		error: function(error) { // ajax 요청이 실패하면 실행할 콜백 함수
			console.log('요청실패: ', error.status);
		}
	})
}		


// 아이디 중복 검사를 실행하는 함수
function registerCheckFunction() {
	// ajax를 이용해서 중복 검사할 아이디를 얻어온다.
	let userid = $('#userid').val();
	console.log(userid);
	
	// jQuery ajax
	$.ajax({
		type: 'POST',
		url: './userRegisterCheck ',
		data: {
			userid: userid
		},
		success: response => {
			switch (response) {
				case '1': 
					$('#idCheckMessage').html('아이디를 입력하고 중복 체크 버튼을 누르세요.');
					$('#checkMessage').html('아이디를 입력하고 중복 체크 버튼을 누르세요.');
					$('#idCheck').attr('class', 'modal-content panel-warning');
					break;
				case '2': 
					$('#idCheckMessage').html('사용중인 아이디 입니다.');
					$('#checkMessage').html('사용중인 아이디 입니다.');
					$('#idCheck').attr('class', 'modal-content panel-warning');;
					break; 
				case '3': 
					$('#idCheckMessage').html('사용 가능한 아이디 입니다.');
					$('#checkMessage').html('사용 가능한 아이디 입니다.');
					$('#idCheck').attr('class', 'modal-content panel-success');
					break;
			}
		// 아이디 중복 검사 모달창을 띄운다.
			$('#idModal').modal('show');
		},
		error: e => {
			console.log('요청 실패: ', e.status);
		}
	});
}
