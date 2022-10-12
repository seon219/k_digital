function passwordCheck(obj) {
	//alert('passwordCheck 실행')
	
	/*
	// 입력한 비밀번호가 8자 이상, 12자 이하인가 검사
	let len = obj.password.value.trim().length;
	console.log(len);
	
	if (len < 8 || len > 12) {
		alert ('비밀번호는 8 ~ 12자 사이로 입력하세요');
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		
		return false;
	}
	
	
	// 영문자, 숫자, 특수문자가 각각 1개 이상씩 입력되었나 검사
	let alphaCount = 0; // 영문자 개수
	let numberCount = 0; // 숫자 개수
	let etcCount = 0; // 특수문자 개수
	// 입력된 비밀번호의 문자 개수만큼 반복하며 영문자, 숫자, 특수문자의 개수를 센다.
	const pw = obj.password.value.trim();
	for (let i = 0; i < len; i++){
		
		if (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z' || pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z') {
			alphaCount++;
		} else if (pw.charAt(i) >= 0 && pw.charAt(i) <= 9) {
			numberCount++;
		} else {
			etcCount++;
		}
		
	}
	console.log('영문자: '+ alphaCount + ', 숫자: ' + numberCount + ', 특수문자: ' + etcCount)
	
	if (alphaCount == 0 || numberCount == 0 || etcCount == 0) {
		alert('비밀번호는 영문자, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.');
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}
	*/
	
	const pw = obj.password.value.trim();
	
	// 정규 표현식(정규식)을 사용한 영문자 대소문자, 숫자, 특수문자가 각각 1개 이상 입력되었고,
	// 8자 이상 12자 이하로 입력되었나 검사
	
	// new RegExp('정규식패턴') => 자바 스크립트 정규식 객체를 만든다.
	// .: 모든 문자 1글자를 대신한다. => 어떤 문자라도 1글자가 나와야 한다.
	// *: 모든 문자 0글자 이상을 대신한다 => 아무문자가 안나와도 되고 몇개가 나와도 상관없다.
	// +: 모든 문자 1글자 이상을 대신한다 => 아무문자나 1글자 이상 나와야 한다.
	// ^: 시작하는
	// $: 끝나는
	
	//const pattern = new RegExp('^.{8}$'); // 글자수 제한 => 무조건 8자만 허용
	//const pattern = new RegExp('^.{1,8}$'); // 글자수 제한 => 1자이상 8자미만 허용
	//const pattern = new RegExp('^.{8,}$'); // 글자수 제한 => 8자 이상만 허용
	//const pattern = new RegExp('^.{8,12}$'); // 글자수 제한 => 8자 이상, 12자 이하만 허용
	
	// 숫자만 허용 => 허용가능한 문자를 []안에 나열
	//const pattern = new RegExp('^[0123456789]+$') // +를 사용하지 않으면 딱 1글자만 검사
	//const pattern = new RegExp('^[0-9]+$'); // -를 사용해서 범위 지정 가능
	
	// 숫자 4글자만 허용 => {}가 사용되면 +, *을 사용할 수 없다,
	//const pattern = new RegExp('^[0-9]{4}$'); // -를 사용해서 범위 지정 가능
	
	
	// 영문자만 허용
	//const pattern = new RegExp('^[A-Z]+$'); // 대문자만 허용
	//const pattern = new RegExp('^[a-z]+$'); // 소문자만 허용
	//const pattern = new RegExp('^[A-Za-z]+$'); // 영문자만 허용
	//const pattern = new RegExp('^[a-zA-Z]+$'); // 영문자만 허용
	
	//const pattern = new RegExp('^[ㄱ-힣]+$');// 한글만 허용
	//const pattern = new RegExp('^[!@#$%^&]+$');// 지정된 특수문자만 허용
	
	// 영문자, 숫자, 특수문자(!@#$%^&)만 8자 이상 12자 이하로 입력을 허용
	//const pattern = new RegExp('^[a-zA-Z0-9!@#$%^&]{8,12}+$');
	
	
	// 긍정형 전방 탐색 기능으로 특정 문자가 포함되어있나 검사한다 => (?=.*)
	//const pattern = new RegExp('(?=.*[0-9]+)'); // 숫자가 포함되어있나 검사
	//const pattern = new RegExp('(?=.*[A-Z]+)'); // 대문자가 포함되어있나 검사
	//const pattern = new RegExp('(?=.*[a-z]+)'); // 소문자가 포함되어있나 검사
	//const pattern = new RegExp('(?=.*[a-zA-Z]+)'); // 영문자가 포함되어있나 검사
	//const pattern = new RegExp('(?=.*[ㄱ-힣]+)'); // 한글이 포함되어있나 검사
	//const pattern = new RegExp('(?=.*[!@#$%^&]+)'); // 지정된 특수문자가 포함되어있나 검사
	
	
	const pattern = new RegExp('^(?=.*[0-9]+)(?=.*[a-zA-Z]+)(?=.*[!@#$%^&]+)ㄴ[a-zA-Z0-9!@#$%^&]{8,12}+$');
	
	// test() 함수는 인수로 지정된 문자열이 정규식 패턴에 만족하나 검사해서 만족하면 true, 만족하지 못하면 false 리턴
	if (!pattern.test(pw)){
		alert('비밀번호는 영문자, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.');
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		return false;
	}
	
	
	
	// 입력한 두 개의 비밀번호가 같은가 검사
	if (obj.password.value.trim() != obj.repassword.value.trim()) {
		alert ('비밀번호가 일치하지 않습니다.');
		obj.password.value = '';
		obj.repassword.value = '';
		obj.password.focus();
		
		return false;
	}
	
	return false;
}
