function elementCreate() {
	// 요소(element)를 만들어 문서에 추가
	// createElement('태그이름'): 인수로 지정한 태그를 만든다.
	let div = document.createElement('div'); // <div></div>
	
	
	
	// appendChild('추가할 태그 또는 문자열'): 인수로 지정된 태그를 맨 뒤에 추가
	document.body.appendChild(div);
	div.innerHTML = '<marquee>수업끝</marquee>'
}























