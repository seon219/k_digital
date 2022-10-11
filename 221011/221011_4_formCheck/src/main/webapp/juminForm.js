onload = function () {
		document.getElementsByName('j1')[0].focus();
	}
	
	
// 이벤트가 실행되는 객체에 입력 가능한 최대 글자수만큼 문자가 입력되면
// 다음 객체로 포커스를 넘겨줄 객체로 포커스를 넘겨주는 함수
// moveNext(이벤트가 실행되는 객체, 최대 글자수, 포커스를 넘겨줄 객체);
function moveNext(obj, len, nextObj) {
	//console.log(obj, len, nextObj);
	if (obj.value.length == len) {
		nextObj.focus();
	}
}


// 인수로 넘어온 form의 유효성을 검사하고 정상이면 true를 리턴하고,
// 오류가 발생되면 오류 메시지를 출력하고 false를 리턴하는 함수
function formCheck(obj) {
	// obj로 this(form)가 넘어오므로 obj에는 document.juminForm이 저장된다.
	console.log(obj);
	
	// 주민등록번호 앞 자리에 아무것도 입력되지 않았거나 전부 공백이 입력됐으면 오류메시지 출력하고 false 리턴
	if (!obj.j1.value || obj.j1.value.trim().length == 0){
		// 입력이 되있으면 T, 아무것도 입력되지 않았으면 F, !obj.j1.value 이므로 아무것도 입력되지 않았으면 T
		alert('주민번호 앞자리를 입력하세요');
		// obj.j1.value = '';
		document.getElementsByName('j1')[0].value = ''; // 가능하지만, 인수로 받는 의미가 없음
		obj.j1.focus();
		return false;
	} 
	
	// 주민등록번호 앞자리에 6글자가 입력되었는지 검사
	if (obj.j1.value.trim().length != 6) {
		alert('주민번호 앞자리 6글자를 입력하세요');
		obj.j1.value = '';
		obj.j1.focus();
		return false;
	}
	
	// 주민등록번호 앞자리가 숫자만 입력되었나 검사
	// isNaN(): 인수로 지정된 데이터가 숫자가 아니면 true, 숫자면 false 리턴
	if (isNaN(obj.j1.value.trim())) {
		alert('주민번호 앞자리에 숫자만 입력하세요');
		obj.j1.value = '';
		obj.j1.focus();
		return false;
	}
	
	
	if (!obj.j2.value || obj.j2.value.trim().length == 0){
		alert('주민번호 뒷자리를 입력하세요');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	
	if (obj.j2.value.trim().length != 7) {
		alert('주민번호 뒷자리 7글자를 입력하세요');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	
	if (isNaN(obj.j2.value)) {
		alert('주민번호 뒷자리에 숫자만 입력하세요');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	
	
	// 여기까지 왔다면 주민등록번호가 13자리의 숫자로 입력되었다는 의미
	// 주민등록번호 유효성을 검사한다
	// 주민등록번호 유효성을 검사하기 위해 따로 입력된 주민등록번호를 하나의 문자열로 이어준다.
	let jumin = obj.j1.value.trim() + obj.j2.value.trim();
	console.log(jumin);
	
	// 자바 스크립트는 문자열끼리 덧셈 연산을 실행하면 문자열을 연결하지만 뺄셈, 곱셈, 나눗셈은 숫자로 바꿔 연산
	// 문자열로 구성된 숫자의 덧셈연산을 하려면 Number() 함수를 이용해 숫자로 변환한 뒤 연산한다.
	// console.log(Number(obj.j1.value.trim()) + Number(obj.j2.value.trim()));
	
	
	// 가중치 => 234567892345, 둘리 주민등록번호 => 8304221185600 => 가중치와 곱해서 모두 더하면 143
	let u = "234567892345";
	let sum = 0;
	for (let i = 0; i < 12; i++) {			
			// sum += jumin.charAt(i) * u.charAt(i);
			//sum += jumin.charAt(i) * (i < 8 ? i + 2 : i - 6);
			sum += jumin.charAt(i) * (i % 8 + 2);
		}
	console.log(sum);
	
	// sum에 저장된 값을 11로 나눈 나머지를 11에서 뺀 결과가 10 이상일 경우 1의 자리 숫자가 주민등록번호의 마지막 자리와 같아야 한다.
	let result = (11 - sum % 11) % 10;
		
		if (result != (jumin.charAt(12))) {
			alert("잘못된 주민등록번호입니다.");
			obj.j1.value = '';
			obj.j2.value = '';
			obj.j1.focus();
			return false;
		}
	
	// 모든 유효성 검사를 무사히 통과하면 마지막에 true를 리턴
	return true;
	
}











