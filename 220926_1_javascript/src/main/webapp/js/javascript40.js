function tableAdd() {
	// 데이터가 입력된 form을 얻어와서 form에 입력된 데이터를 배열에 저장
	//let form = document.getElementsByTagName('form')[0];
	//let form = document.querySelectorAll('from')[0];
	// forms: 현제 문서의 form을 배열 형태로 저장하는 자바스크립트 내장 객체
	let form = document.forms[0];
	console.log(form)
	
	console.log('id: ' + form.id.value);
	console.log('password: ' + form.password.value);
	console.log('address: ' + form.address.value);
	console.log('phone: ' + form.phone.value);
	
	let values = [form.id.value, form.password.value , form.address.value, form.phone.value];
	console.log(values)
	
	
	// form에 데이터가 모두 입력되었나 검사
	for (let i = 0; i < values.length; i++) {
		let value = values[i];
		if (value == null || value == '' || value == undefined) {
			switch (i) {
				case 0:
					alret('아이디를 입력하세요');
					break;
				case 1:
					alret('비밀번호를 입력하세요');
					break;
				case 2:
					alret('주소를 입력하세요');
					break;
				case 3:
					alret('전화번호를 입력하세요');
					break;	
			}
			return;
		}
	}
	
	// 배열에 저장된 데이터를 id 속성이 ctb인 테이블에 추가한다.
	// <tbody> 태그를 얻어온다.
	let tbody = document.getElementById('addtr');
	// 배열에 저장된 데이터를 사용해서 <tbody> 태그에 추가할 행(<tr> 태그)을 만들어 리턴하는 함수를 실행해서 리턴된 결과를 추가
	tbody.appendChild(createRow(values))
	
	
	// 다음 데이터를 입력받기 위해서 텍스트 상자의 내용을 모두 제거
	form.id.value = '';
	form.password.value = '';
	form.address.value = '';
	form.phone.value = '';
	
	// 텍스트 상자의 내용을 지운 후 다음 데이터 입력을 위해 아이디 텍스트 상자로 포커스를 이동
	form.id.focus();
}

// <tbody> 태그에 추가할 <tr> 태그를 만들어 리턴하는 함수
function createRow(values) {
	console.log(values);
	
	// <tr> 태그를 만든다.
	let tr = document.createElement('tr') //<tr></tr>
	
	// 열의 개수(인수로 넘어온 values 배열의 length)만큼 반복하여 <td> 배열 만들기
	for (let i = 0; i < values.length; i++) {
		// <td>태그를 만든다.
		let td = document.createElement('td')
		// <td>태그에 데이터를 넣어준다.
		td.innerHTML = values[i]
		
		// <tr>태그에 <td>태그를 추가
		tr.appendChild(td);
	}
	
	
	// 현재 데이터 삭제 버튼을 추가하기 위해 <td> 태그에 버튼을 만들어 <tr>태그에 추가
	// <td>태그를 만든다.
	let td = document.createElement('td')
	td.innerHTML = '<input type="button" value="' + values[0] + '데이터 삭제" onclick="removeCurrnet(this)"/>'
	//td.innerHTML = `<input type="button" value="${values[0]}데이터 삭제" onclick="removeCurrnet(this)"/>`
	tr.appendChild(td);
	
	// <tbody> 태그에 추가할 <tr> 태그를 리턴
	return tr;
}


function removeCurrnet(obj) {
	console.log(obj);
	console.log(obj.parentNode); //<td></td>
	console.log(obj.parentNode.parentNode); //<tr></tr>
	
	// 삭제할 <tr> 태그 선택
	let removetr = obj.parentNode.parentNode
	
	// <tbody> 태그의 자식인 <tr>태그 제거
	let tbody = document.getElementById('addtr');
	tbody.removeChild(removetr)
}

function removeLast() {
	// <tbody> 태그를 선택해서 마지막 <tr> 태그를 제거
	let tbody = document.getElementById('addtr');
	tbody.removeChild(tbody.lastChild);	
}


function removeAll() {
	// <tbody> 태그를 선택해서 공백으로 채운다
	let tbody = document.getElementById('addtr');
	tbody.innerHTML = '';	
}
