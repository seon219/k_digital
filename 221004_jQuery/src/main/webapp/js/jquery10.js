$(() => {
	
	//$('p').eq(0).css('color', 'blue');
	//$('p:eq(0)').css('color', 'red');
	//$('span').css('color', 'green');
	
	// 0번째 <p> 태그를 선택한 후, 추가적으로 <span> 태그를 선택
	//$('p:eq(0)').add('span').css('color', 'hotpink');
	$('p').eq(0).add('span:eq(1)').add('p:eq(1)').css('color', 'dodgerblue');
	
	
	$('div').children().css('color', 'yellowgreen');
	$('div').children().click(function () {
		if ($(this).is('span')) {
			$(this).css('color', 'hotpink')
		}
		
		if ($(this).is('b')) {
			$(this).css('fontSize', '20px')
		}
		
		if ($(this).is('p')) {
			$(this).css('color', 'lime')
		}
	})
})