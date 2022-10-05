$(() => {
	//$('.error').css('display', 'none');
	$('.error').hide();
	
	// id 속성이 single로 지정된 form에서 submit 버튼이 클릭되면 실행할 이벤트를 지정
	// submit(html이나 javascript는 onsubmit) 이벤트는 input 태그나 button 태그의 type 속성이,
	// submit으로 지정된 버튼이 클릭되면 발생되는 이벤트
	// submit 이벤트가 실행되면 서버로 전송하기 전에 form의 유효성을 검사하고,
	// 폼에 입력된 데이터가 이상이 없으면 true(기본값), 이상이 있으면 에러 메시지를 출력한 후 false를 리턴
	// submit 이벤트의 리턴값이 true면 action 페이지로 form의 데이터를 가지고 이동하고 false면 현재 페이지를 그대로 표시
	$('#single').submit(() => {
		//alert('submit 버튼이 클릭 됨')
		let userID = $('#infoBox').val().trim();
		console.log(userID);
		if (userID == null || userID == ''){
			$('#infoBox').val('');
			$('#infoBox').focus();
			$('.error').show();
			
			return false; //flase가 리턴되면 현재 페이지에 그대로 머물러 있는다.
			// 기본값이 true이기 때문에 현재 페이지에 머물러주기 위해 false 리턴
		}
		return true; // true가 리턴되면 action 페이지로 이동
	})
	
	
	
	// 전체선택 체크박스가 클릭되면 모든 체크 박스를 선택 또는 해제한다.
	$('input:checkbox[name=all]').click(() => {
		console.log('전체선택 체크박스 클릭');
		// prop('속성이름'): 인수로 지정된 속성의 프로퍼티를 얻어온다.
		let checked = $('input:checkbox[name=all]').prop('checked') //prop으로 선택 유무에 따라 true, false 
		console.log(checked);
		
		//name 속성이 chk인 체크 박스의 프로퍼티를 name 속성이 all인 체크박스의 프로퍼티로 바꾼다.
		// prop('속성이름', 프로퍼티): 인수로 지정된 속성의 프로퍼티를 변경한다.
		/*
		// 방법1
		$('input:checkbox[name=chk]').each(index => {
			$('input:checkbox[name=chk]').eq(index).prop('checked', checked)
		})
		*/
		/*
		// 방법2
		$('input:checkbox[name=chk]').each(function (index) {
			$(this).prop('checked', checked)
		})
		*/
		// 방법3
		$('input:checkbox[name=chk]').prop('checked', checked)
		
	})
	
	// name 속성이 chk인 체크박스가 클릭되면 모든 체크박스가 체크되었나 검사해서,
	// 모두 체크되었으면 전체선택 체크박스를 체크되게 하고, 그렇지 않으면 체크안되게 한다.
	$('input:checkbox[name=chk]').click(() => {
		console.log('체크박스 클릭')
		// name 속성이 chk인 요소의 개수와 name 속성값이 chk인 요소 중에서 체크된 요소의 개수를 비교
		console.log('name 속성이 chk인 요소의 개수:' + $('input:checkbox[name=chk]').length)
		console.log('name 속성이 chk인 요소 중에서 체크된 요소의 개수:' + $('input:checkbox[name=chk]:checked').length)
		
		if ($('input:checkbox[name=chk]').length == $('input:checkbox[name=chk]:checked').length) {
			$('input:checkbox[name=all]').prop('checked', true);
		} else {
			$('input:checkbox[name=all]').prop('checked', false);			
		}
		
	})
	
	
	
	// 체크박스를 선택하고 확인버튼을 클릭하면 체크 여부를 확인해서 그 결과를 id 속성이 result로 저장된 div 태그 내부에 출력
	$('#confirm').click(() => {
		console.log('확인버튼 클릭됨')
		// 선택한 과일 과격이 표시된 div태그 내부 내용을 지운다.
		//$('#result').html('');
		//$('#result').text('');
		// empty(): 선택된 요소의 내부 내용을 지운다.
		$('#result').empty();
		
		// name 속성에 chk가 지정된 체크 박스의 체크된 항목의 개수를 얻어온다.
		let count = $('input:checkbox[name=chk]:checked').length
		if (count == 0) {
			$('#result').html('<b style="color: tomato;">과일을 1개 이상 선택하세요</b>');
		} else {
			 $('input:checkbox[name=chk]:checked').each(index => {
				let chk =  $('input:checkbox[name=chk]:checked').eq(index);
				console.log(chk.val()); // 
			})
		}
		
		
	})
})














