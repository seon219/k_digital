// 하이퍼링크를 클릭시 호출했던 fetch() 함수의 반복되는 부분을 함수로 구현
function fetchAjax(pageName) {
	fetch(pageName)
		.then(function(response) {
			console.log(response.status);
			if (response.status == 200) {
				response.text().then(function(text) {
					document.querySelectorAll('div')[0].innerHTML = text;
				});
			} else {
				document.querySelectorAll('div')[0].innerHTML = '요청 실패';
			}
		});
}

// javascript onload
/*
onload = function() {
	// 페이지가 로드되거나 새로고침 될 때 해시가 없으면 summary 파일에 저장된 내용을 표시하고,
	// 해시가 있으면 지정된 파일의 내용을 표시한다.
	// location.hash: 클릭된 파일의 내용을 표시한다.
	// console.log('location.hash: ' + location.hash);
	if (location.hash) {
		fetchAjax(location.hash.substring(2));		
	} else {
		console.log('해시 없음');
		fetchAjax('summary');
	}
}
*/


// jQuery onload
$(() => {
	if (location.hash) {
		fetchAjax(location.hash.substring(2));		
	} else {
		console.log('해시 없음');
		fetchAjax('summary');
	}
})








