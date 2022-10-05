$(() => {
	//input 태그 중에서 type이 text인 요소를 선택해서 배경색 변경
	// 자바스크립트
	/*
	let inputs = document.getElementsByTagName('input');
	console.log(inputs.length); //9
	for(let i = 0; i < inputs.length; i++) {
		// getAttribute()함수는 인수로 지정된 속성의 속성값을 얻어온다.
		if(inputs[i].getAttribute('type') == 'text') {
			inputs[i].style.backgroundColor = 'tomato';
		}
	}
	*/
	/*
	let inputs = document.querySelectorAll('input[type=text]');
	console.log(inputs.length);
	for(let i = 0; i < inputs.length; i++) {
		inputs[i].style.backgroundColor = 'skyblue';
	}
	*/
	
	
	// jQuery
	//$('input[type=text]').css('backgroundColor', 'yellowgreen');
	$('input:text').css('backgroundColor', 'pink');
	
	
	
	
	
	// select 태그의 name 속성이 email인 요소에서 change 이벤트가 발생되면.
	// 선택된 option의 value 값을 name 속성이 addr인 text 상자에 넣어준다.
	/* 자바스크립트
	let email = document.querySelectorAll('select[name=email]')[0];
	console.log(email);
	email.onchange = () => {
		let emailValue = email.options[email.selectedIndex].value;
		console.log(emailValue);
		let addr = document.querySelectorAll('input[name=addr]')[0];
		addr.value = emailValue;
	}
	*/
	
	/* jQuery
	$('select[name=email]').eq(0).change(() => {
		let emailValue = $('select[name=email]:eq(0) > option:selected').val();
		console.log(emailValue)
		$('input[name=addr]').eq(0).val(emailValue);
	})
	*/
	
	$('select[name=email]').eq(0).change(function() {
		// 콤보상자는 1번에 1개만 선택되기 때문에 $('select[name=email]:eq(0) > option:selected')와,
		// $(this)는 같은 의미로 사용된다.
		// $(this)는 화살표함수를 사용할 때 동작되지 않는다.
		let emailValue = $(this).val();
		$('input[name=addr]').eq(0).val(emailValue);
	})
	
	/*
	// 체크 박스를 체크(클릭)하면 체크된 목록을 출력
	let hobby1 = document.getElementsByName('hobbies')[0];
	let hobby2 = document.getElementsByName('hobbies')[1];
	let hobby3 = document.getElementsByName('hobbies')[2];
	
	hobby1.onclick = () => hobbyCheck();
	hobby2.onclick = () => hobbyCheck();
	hobby3.onclick = () => hobbyCheck();
	*/
	
	
	$('input:checkbox[name=hobbies]').click(() => {
		let msg = [];
		// each(): 선택된 요소들의 index와 요소 자체를 리턴하며 인수로 지정한 함수를 반복 실행
		// each() 메소드는 익명 함수로 2개의 인수를 넘긴다. 1번째 인수는 index이고 2번째 인수가 객체이다.
		$('input[name=hobbies]:checked').each(function (value, obj) { //obj 생략 가능
			//console.log('index: ' + index);
			//msg.push($('input[name=hobbies]:checked').eq(index.val()))
			msg.push(obj.value);
		})
		console.log(msg.length == 0 ? '없음' : msg.join(', '));
	})
	
	/*
	$('input:checkbox[name=hobbies]').click(() => {
		let msg = [];
		$('input[name=hobbies]:checked').each(index => {
			//console.log('index: ' + index);
			msg.push($('input[name=hobbies]:checked').eq(index).val())
		})
		console.log(msg.length == 0 ? '없음' : msg.join(', '));
	})
	*/
	/*
	$('input:checkbox[name=hobbies]').click(() => {
		let msg = [];
		// 인수의 형식상 변수가 나와야 하는데 사용하지 않을 경우 '_'로 처리하기도 한다.
		$('input[name=hobbies]:checked').each(function (_, obj) {
			//console.log(obj);
			msg.push(obj.value)
		})
		console.log(msg.length == 0 ? '없음' : msg.join(', '));
	})
	*/
})


function hobbyCheck() {
	let hobbies = document.getElementsByName('hobbies');
	//let msg = '';
	let msg = [];
	for (let hobby of hobbies) {
		if (hobby.checked) {
			//msg += hobby.value + ' ';
			msg.push(hobby.value);
		}
	}
	//console.log(msg.length == 0 ? '없음' : msg);
	console.log(msg.length == 0 ? '없음' : msg.join(', '));
}





