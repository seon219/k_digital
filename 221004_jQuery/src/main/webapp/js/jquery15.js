// class 속성 추가 및 제거
//   addClass(): 선택된 요소에 인수로 전달받은 클래스를 추가한다.
//   removeClass(): 선택된 요소에 인수로 전달받은 클래스를 제거한다.
//   toggleClass(): 선택된 요소에 인수로 전달받은 클래스가 없으면 추가하고 인수로 전달받은 클래스가 없으면 제거한다.
//   hasClass(): 인수로 전달받은 값이 선택된 요소에 클래스로 존재하는가 검사해서 존재하면 true,
//    			 존재하지 않으면 false를 리턴한다.

$(() => {
	
	$('img').click(function () {
		// 클릭된 img 태그에 addSize 클래스 속성이 설정되었나 검사
		if ($(this).hasClass('addSize')) {
			//console.log('있음')
			$(this).removeClass('addSize');
		} else {
			//console.log('없음')
			$(this).addClass('addSize');
		}
	})
	
	
	$('#btn').click(() => {
		$('img').toggleClass('onoffImage')
	})
})
