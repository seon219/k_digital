function a1() {
	// let span = document.getElementsByTagName('span');
	//let span = document.querySelectorAll('span');
	//console.log(span.length)
	//for (let i = 0; i < span.length; i++){
	//	span[i].style.color = dodgerblue;
	//}
	
	// jQuery는 배열 형태도 반복문 없이 알아서 처리
	$('span').css('color', 'chocolate'); //$('tag'): 태그 선택자
}


function a2() {
	$('#t1').css('color', 'red'); //$('#id'): id 선택자
}


function a3() {
	$('.t2').css('color', 'blue'); //$('.class'): class 선택자
}


function a4() {
	$('li > span').css('color', 'lime'); // 자식 선택자
}


function a5() {
	$('li span').css('color', 'purple'); // 공백: 자손 선택자
}



// :nth-child, :nth-last-child
// 같은 부모 요소를 가지는 형제 요소 중에서 특정 순서에 있는 요소를 선택하는 선택자
// :nth-child()는 앞에서부터 세고 :nth-last-child는 뒤에서부터 센다
// 인수로 숫자, 연산식(곱하기는 숫자가 앞에 와야 하고 더하기 빼기는 숫자가 뒤에 와야 한다.)
// odd(홀수, 기수), even(짝수, 우수)도 사용할 수 있다.
function a6() {
	// $('li').eq(0)와 $('li:eq(0)')는 같은 의미로 사용
	//$('li').eq(0).css('backgroundColor', 'skyblue');
	//$('li:eq(0)').css('backgroundColor', 'hotpink');
	
	// eq()는 index가 0부터 시작하고 nth-child는 index가 1부터 시작된다 => 주의
	//$('li:nth-child(1)').css('backgroundColor', 'dodgerblue'); // 처음부터 위치를 센다
	//$('li:nth-last-child(1)').css('backgroundColor', 'yellowgreen'); // 마지막부터 위치를 센다

	//$('li:nth-child(odd)').css('backgroundColor', 'dodgerblue'); // 홀수 인덱스만 선택
	//$('li:nth-last-child(even)').css('backgroundColor', 'yellowgreen'); // 짝수 인덱스만 선택
	
	
	// n은 자동을 0부터 1씩 증가하는 정수이고 +, -, * 연산을 사용할 수 있다.
	//$('li:nth-child(n)').css('backgroundColor', 'dodgerblue'); //모두 선택
	//$('li:nth-last-child(n + 3)').css('backgroundColor', 'yellowgreen'); // 3번부터 모두 선택
	// * 연산도 가능한데 * 연산자를 사용하면 안되고 숫자가 n 앞에 나와야 한다.
	//$('li:nth-child(2n)').css('backgroundColor', 'dodgerblue'); // 짝수 인덱스만 선택
	//$('li:nth-last-child(2n + 1)').css('backgroundColor', 'yellowgreen'); // 홀수 인덱스만 선택
	$('li:nth-last-child(3n)').css('backgroundColor', 'yellowgreen'); // 3의 배수번째 인덱스만 선택
}


// first-child: 같은 부모를 가지는 형제 요소 중에서 첫번째 자식 요소만 선택
// last-child: 같은 부모를 가지는 형제 요소 중에서 마지막 자식 요소만 선택
function a7() {
	$('li:first-child').css('backgroundColor', 'tomato');
}

function a8() {
	$('li:last-child').css('backgroundColor', 'pink');	
}



