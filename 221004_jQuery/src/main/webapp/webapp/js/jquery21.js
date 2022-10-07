$(() => {
	
	$('#btn1').click(() => {
		// $('<tag>'): 태그를 만든다.
		// 태그를 만들고 태그의 데이터를 넣어야 하면 2번째 인수에 {}로 묶어서 넣어준다. (생략 가능)
		// jQuery는 태그를 기억하는 변수는 앞에 '$'를 붙여서 만든다.
		let $tr = $('<tr>', {});
		let $td1 = $('<td>', {text : '방법1'});
		let $td2 = $('<td>', {text : '방법1'});
		let $td3 = $('<td>', {text : '방법1'});
		let $td4 = $('<td>', {text : '방법1'});
		$tr.append($td1);
		$tr.append($td2);
		$tr.append($td3);
		$tr.append($td4);
		$('tbody').append($tr);
	})
	
	
	
	$('#btn2').click(() => {
		// template literals: 템플릿 리터럴은 여러줄로 이루어진 문자열을 허용하는 문자열 리터럴
		// 템플릿 리터럴은 `(그레이브)로 묶어서 표현하며 '${'와 '}' 사이에 변수 이름을 입력하면,
		// 변수에 저장된 데이터가 템플릿 리터럴에 삽입된다.
		let str = '내장된 표현식';
		let html = `
			<tr>
				<td>${str}</td>
				<td>방법2</td>
				<td>방법2</td>
				<td>방법2</td>
			</tr>
		`;
		$('tbody').append(html);
	})
	
})
