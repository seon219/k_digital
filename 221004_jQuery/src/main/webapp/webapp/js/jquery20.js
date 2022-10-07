$(() => {
	
	// 자바스크립트로 주기적인 작업을 실행하기 위해서 setInterval() 함수와 setTimeout() 함수를 사용
	// setInterval() 함수와 setTimeout() 함수는 비슷하게 실행되지만 중요한 차이점을 가진다.
	
	// setInterval(): 지정된 시간마다 함수를 반복해서 실행
	// setInterval(실행할 함수, 함수를 주기적으로 실행할 시간)
	// clearInterval(): setInterval() 함수의 실행을 중지시킨다.
	
	// setTimeout(): 지정된 시간이되면 함수를 실행한다.
	// setTimeout(실행할 함수, 시간)
	// clearTimeout(): setTimeout() 함수의 실행을 중지시킨다.
	
	//let count = 0;
	setInterval(() => {
		//console.log('setInterval: ' + ++count)
		// 메뉴의 첫번째 이미지를 선택해서 마지막 이미지로 위치를 이동시킨다.
		// appendTo(): 선택된 요소를 인수로 지정한 요소의 마지막에 추가
		$('.active').first().appendTo($('#menu'));
	}, 10)

	
	$('button:eq(0)').click(() => {
		// 클릭된 버튼의 문자열이 start면 stop으로 변경하고, stop이면 start로 변경
		console.log($('button:eq(0)').html());
		if ($('button:eq(0)').html() == 'start') {
			$('button:eq(0)').html('stop');
			//$('img').addClass('active');
		} else {
			$('button:eq(0)').html('start');
			//$('img').removeClass('active');
		}
		$('img').toggleClass('active');
	})
})
