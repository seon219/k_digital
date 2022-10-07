$(() => {
	
	$('#emp_search').click(() => {
		// 조회할 사원 번호 얻어오기
		let empid = $('input:text[name=empid]').val();
		
		if (!isNaN(empid) && empid.length == 3) {
// ======== jQuery Ajax ======================================			
			
			$.ajax({
				url: 'emplist.xml', 
				cache: false, 
				method: 'get', 
				asyn: true, 
				dataType: 'xml', 
				data: { 'key': 'value'},
				
				success: data => {
					let empInfo = $(data).find('EMPLOYEE_ID:contains(' + empid + ')').parent();
					
					if ($(empInfo).is('ROW')) {
						/*
						$('table input').each(function(index, obj) {
							let search = $(empInfo).children().eq(index).text();
							$('table input').eq(index).val(search);
						})
						*/
						
						// body 태그에 테이블을 만들고 xml 파일에서 읽어온 데이터를 넣어주는 함수를 실행
						$('body').append(makeTable(empInfo)).append('<br/>');
						
						
					} else {
						console.log('없음')
						alert(empid +'번은 존재하지 않는 사원 번호입니다.')
					}
					$('input:text[name=empid]').val('');
					$('input:text[name=empid]').focus();
				},
				
				error: e => { 
					console.log(e.status + ': ' + e.statusText)
				}
			})
			
						
// ======== jQuery Ajax ======================================			
			
		} else {
			alert('정확한 사원 번호를 입력하세요');
			$('input:text[name=empid]').val('');
			$('input:text[name=empid]').focus();
		}
	})

})


// 테이블을 만들고 xml 파일에서 얻어온 데이터를 테이블에 넣어서 리턴하는 함수
function makeTable(empInfo) {
	console.log(empInfo.html());
	
	// 테이블을 만든다.
	let $table = $('<table border="1">'); // <table border="1"> ~ </table>
	
	
	// 테이블의 첫 행(머리글 행)을 만든다.
	let $tr = $('<tr>'); //<tr> ~ </tr>
	
	// xml 파일에서 읽어온 사원번호에 해당하는 데이터(자식요소)의 개수만큼 반복하며 행에 열을 만들어 추가
	for(let i = 0; i<empInfo.children().length; i++) {
		// 행에 추가할 열을 만든다.
		let $th =  $('<th>').append(empInfo.children().eq(i).prop('tagName'));
		// 행에 열을 추가
		$tr.append($th)
	}
	
	// 첫 행을 테이블에 추가한다.
	$table.append($tr);
	
	
	let html = `
		<tr>
			<td>사원번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>내선번호</td>
			<td>입사일</td>
		</tr>
	`
	$table.append(html);
	
	
	// 테이블에 추가할 나머지 행을 만들어 테이블에 추가한다.
	$tr = $('<tr>');
	for(let i = 0; i<empInfo.children().length; i++) {
		let $td = $('<td>').append(empInfo.children().eq(i).text());
		$tr.append($td)
	}
	$table.append($tr);
	
	// 테이블을 리턴시킨다.
	return $table;
}
