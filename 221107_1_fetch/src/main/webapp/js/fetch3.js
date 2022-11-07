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