function openWin() {
	//window.open();
	//window.open(url, title, option);
	let url = './20_window2.html'; // 새로 띄울 창에 표시될 페이지 이름
	let title = '아이디 중복 검사'; // 윈도우 이름
	// 새 윈도우를 현재 브라우저에 새 탭으로 띄우려면 option을 생략하면 된다.
	let option = 'top=50px, left=100px, width=500px, height=600px'; // 윈도우 옵션
	window.open(url, title, option);
}


function registerForm() {
	// 숨겨놓은 id 속성이 register로 지정된 div 태그를 화면에 보이게 한다.
	document.getElementById('register').style.display = 'block';
	document.body.style.backgroundColor = 'gray';
	
//	로그인 버튼 비활성화
	// 비활성화 시킬 버튼이 1개일 때
	//document.getElementsByName('btn')[1].disabled ='disabled';
	
	// 비활성화 시킬 버튼이 여러개일 때
	// name 속성이 btn인 모든 버튼을 배열로 얻어온다
	//let btns = document.getElementsByName('btn')
	
	// 일반 for
	//for (let i = 0; i<btns.length; i++) {
	//	btns[i].disabled ='disabled';
	//}
	
	// 향상된 for => of
	// 변수 btn에 btns 배열의 요소들이 차례대로 전달되어 반복
	//for (let btn of btns) {
	//	btn.disabled ='disabled';
	//}
	
	// 향상된 for => in
	// in 뒤의 요소가 객체라면 key가 in 앞의 변수로 차례대로 전달되며 반복
	// in 뒤의 요소가 배열이라면 배열의 index가 in 앞의 변수로 차례대로 전달되며 반복
	//for (let i in btns) {
	//	btns[i].disabled ='disabled';
	//}
	

//	모든 input 태그를 비활성화 시킨다.
	let inputs = document.getElementsByTagName('input')
	for (let i = 0; i<6; i++) {
		inputs[i].disabled ='disabled';
	}
}


function closeWin() {
	// id 속성이 register로 지정된 div 태그를 화면에서 사라지게 한다.
	document.getElementById('register').style.display = 'none';
	document.body.style.backgroundColor = 'white';
	
	//	모든 input 태그를 활성화 시킨다.
	let inputs = document.getElementsByTagName('input')
	for (let i = 0; i<6; i++) {
		inputs[i].disabled ='';
	}
}


function idChk() {
	alert('중복체크 버튼을 클릭하고 아이디 중복체크를 하세요')
}


function idCheck(){
	let url = './21_window3.html';
	let title = '아이디 중복 검사'; 
	let option = 'top=50px, left=100px, width=500px, height=600px';
	window.open(url, title, option);
}

