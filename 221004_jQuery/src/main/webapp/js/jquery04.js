// input 요소의 선택
//   :button: type 속성이 'button'인 모든 요소를 선택한다.
//   :checkbox: type 속성이 'checkbox'인 모든 요소를 선택한다.
//   :file: type 속성이 'file'인 모든 요소를 선택한다.
//   :image: type 속성이 'image'인 모든 요소를 선택한다.
//   :password: type 속성이 'password'인 모든 요소를 선택한다.
//   :radio: type 속성이 'radio'인 모든 요소를 선택한다.
//   :reset: type 속성이 'reset'인 모든 요소를 선택한다.
//   :submit: type 속성이 'submit'인 모든 요소를 선택한다.
//   :text: type 속성이 'text'인 모든 요소를 선택한다.
//   :checked: type 속성이 'checkbox' 또는 'radio'인 요소 중에서 체크된 모든 요소들를 선택한다.
//   :selected: option 요소 중에서 선택된 모든 요소들를 선택한다.
//   :focus: 현재 포커스를 가지고 있는 요소를 선택한다.
//   :disabled: 비활성화 되어있는 모든 요소를 선택한다.
//   :enabled: 활성화 되어있는 모든 요소를 선택한다.

function choice() {
	/* 자바스크립트
	// 전체 선택
	//let inputs = document.getElementsByTagName('input');
	//let inputs = document.querySelectorAll('input');
	//console.log(inputs.length);
	//console.log(inputs[0]);
	
	// 개별 선택
	//let input = document.getElementsByTagName('input').[0];
	//let input = document.querySelectorAll('input')[0];
	let input = document.querySelector('input');
	console.log(input.value)
	input.value = '임꺽정'
	*/
	
	// javascript는 value라는 속성을 사용해서 [~~~~.value] 형태로 값을 얻어오고 [~~~~.value='값'] 형태로 값을 넣어준다.
	// jQuery는 value라는 속성 대신 val()메소드를 사용해서 [~~~~.val()] 형태로 값을 얻어오고, [~~~~.value('값')] 형태로 값을 넣어준다. 
	
	//let inputs = $('input'); // input태그 전체를 얻어온다.
	//console.log(inputs.length); // 7
	let inputs = $('input:text'); // input태그 중에서 type 속성값이 text인 태그 전체를 얻어온다.
	console.log(inputs.length); // 2
	
	// 아래와 같이 사용하면 input 태그의 type 속성이 text인 요소가 여러 개 있다 하더라도 첫번째 요소의 값만 얻어온다.
	//let doc = $('input:text').val();
	//console.log(doc);
	
	console.log(inputs);
	console.log(inputs.value); //배열의 인덱스 지정이 안된 상태에서 value를 사용하면 undefined가 리턴된다.
	console.log(inputs[0].value); //javascript
	console.log(inputs[1].value); //javascript
	console.log('===================');	
	
	
	// jQuery
	let text = $('input:text').eq(0);
	console.log(text.value); //undefined
	console.log(text.val());
	
	let text2 = $('input:text').eq(1);
	console.log(text2.value); //undefined
	console.log(text2.val());
	
	$('input:text').eq(1).val('장길산')
	
}


function choice2(){
	/* 자바스크립트
	let input = document.querySelectorAll('input')[3];
	console.log(input);
	console.log(input.value);
	
	//let a = document.getElementById('a');
	//console.log(a);
	//a.innerHTML = radio.value
	document.getElementsByTagName('div').innerHTML = '<h1>' + input.value + '</h1>'
	//document.getElementById('a').innerText = '<h1>' + input.value + '</h1>'
	//document.getElementById('a').textContent = '<h2>' + input.value + '</h2>'
	*/
	
	
	//jQuery
	//let text = $('input:radio').val();
	//let text = $('input:radio').eq(0).val();
	let text = $('input:radio:eq(0)').val();
	console.log(text);
	
	// javascript는 innerHTML, innerText, textContent를 사용해서 태그 내부에 텍스트를 넣는다.
	// jQuery는 innerHTML 역할을 하는 html() 메소드나 innerText, textContent 역할을 하는 text() 메소드로 태그 내부에 텍스트를 넣어준다.
	// hteml() 메소드 태그를 지원하고 text() 메소드는 태그를 지원하지 않는다.
	$('#a').html('<h1>' + text + '</h1>')
	//$('#a').text('<h1>' + text + '</h1>')
}


function choice3() {
	//let input = document.querySelectorAll('input')[4];
	//document.getElementById('a').innerHTML = '<h1>' + input.value + '</h1>'
	//console.log(text);
	
	let text = $('input:checkbox:eq(0)').val();
	$('#a').html('<h1>' + text + '</h1>')
	console.log(text);
}


// onload 1
//$(document).ready(function() {
//	alert('$(document).ready(function() {\n\n}')
//})

// onload 2
//$().ready(function() {
//	alert('$().ready(function() {\n\n}')
//})

// onload 3
//$().ready(() => {
//	alert('$().ready(() => {\n\n}')
//})

// onload 4
//$(function() {
//	alert('$(function() {\n\n}')
//})

// onload 5
//$(() => {
//	alert('$(() => {\n\n}')
//})

$(() => {
	/* 자바스크립트
	let select = document.getElementsByTagName('select')[0];
	console.log(select)
	
	// 이벤트를 연결할 객체.이벤트 = function() {};
	// 이벤트를 연결할 객체.이벤트 = () => {};
	select.onchange = () => {
		//console.log(select.selectedIndex); // 몇 번째 option이 선택되었나 얻어온다.
		//console.log(select.options); // option 목록을 배열 형태로 얻어온다.
		//console.log(select.options[select.selectedIndex]); // 어떤 option이 선택되었나 얻어온다.
		console.log(select.options[select.selectedIndex].value);
		
		let input = document.querySelectorAll('input')[0];
		input.value = select.options[select.selectedIndex].value
	};
	*/
	
	
	// javascript는 onclick, onchange와 같이 이벤트가 'on'으로 시작하지만 jQuery는 앞에 'on'을 붙이지 않는다.
	$('select:eq(0)').change(() => {
		//console.log('select 태그의 change 이벤트 실행됨');
		
		// option:selected는 option 태그 중에서 선택(selected)된 optioin 태그를 얻어온다.
		let select = $('select:eq(0) > option:selected').eq(0).val();
		console.log(select)
		$('input:text').eq(0).val(select);
	})
	
	
	$('input[name=gender]').click(() => {
		let check = $('input[name=gender]:checked').val();
		console.log(check)
		$('input:text').eq(1).val(check);
	})
	
})
