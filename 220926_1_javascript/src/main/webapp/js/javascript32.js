function allcheck() {
	// name 속성값이 all인 체크박스에 체크하면 true, 해제하면 flase인 상태를 변수에 저장
	let check = document.getElementsByName('all')[0].checked;
	console.log(check)

	// name 속성값이 chk인 모든 체크 박스를 얻어온다.
	let checkboxs = document.getElementsByName('chk');
	console.log(checkboxs)
	
	// name 속성값이 chk인 체크 박스의 개수만큼 반복하며 일괄적으로 선택 또는 해제시킨다.
	for (let checkbox of checkboxs) {
		checkbox.checked = check;
	}

}


function chkSelect() {
	/*
	// name 속성값이 chk인 모든 체크 박스를 얻어온다.
	let checkboxs = document.getElementsByName('chk');
	console.log(checkboxs)
	
	// 빨강, 파랑, 노랑, 검정 체크박스가 모두 체크되었나 검사
	let count = 0;
	for (let checkbox of checkboxs) {
		console.log(checkbox.checked)
		if (checkbox.checked){
			count++;
		}
	}
	console.log(count)
	
	// 빨강, 파랑, 노랑, 검정 체크박스가 체크되었으면 전체선택 체크박스에 체크하고,
	// 한개라도 체크가 안되었으면 전체선택 체크박스의 체크를 해제
	if (count == checkboxs.length) { //모두 체크되었으면
		document.getElementsByName('all')[0].checked = true;
	} else {
		document.getElementsByName('all')[0].checked = false;
	}
	*/
	
	let checkboxs = document.getElementsByName('chk');
	let flag = true;
	for (let checkbox of checkboxs) { 
		if (checkbox.checked) { // 각각의 체크 박스가 체크되었나 검사
			flag = false; // 체크 상자가 체크가 안되어있으면 flag를 false로 변경
			// 빨강, 파랑, 노랑 체크 박스 중에서 한개라도 체크가 안되어있으면 나머지는 비교할 필요없다.
			break;
		}
	}
	document.getElementsByName('all')[0].checked = flag;
}


function selectColor() {
	let checkboxs = document.getElementsByName('chk');
	for (let checkbox of checkboxs) { 
		if (checkbox.checked) { 
			console.log(checkbox.value + '선택')
			document.getElementById(checkbox.value).style.backgroundColor = checkbox.value;
			document.getElementById(checkbox.value).style.color = 'white';
		} else {
			console.log(checkbox.value + '해제')			
			document.getElementById(checkbox.value).style.backgroundColor = 'white';
			document.getElementById(checkbox.value).style.color = 'black';
		}
	}
}


function clearColor() {
	//let divs = document.getElementsByTagName('div');
	let divs = document.querySelectorAll('#colorbox > div');
	for (let i = 0; i < divs.length; i++) {
		divs[i].style.backgroundColor = 'white';
		divs[i].style.color = 'black';
	}
	
	// 전체선택 체크 박스를 해제하고 모든 체크 박스 선택을 해제하는 함수를 실행한다.
	document.getElementsByName('all')[0].checked = false;
	allcheck();
}


















