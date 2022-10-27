function setting(idx, mode, title, name, content) {
	
	let frm = document.commentForm; // contentView.jsp의 댓글 폼을 얻어온다.
	
	// 수정 또는 삭제할 댓글 번호를 넣어준다. 댓글 입력시는 0을 넣어준다.
	frm.idx.value = idx;
	
	// commentOK.jsp에서 사용할 댓글 작업 모드를 넣어준다. 1 => 저장, 2 => 수정, 3 => 삭제
	frm.mode.value = mode;
	
	// submit 버튼에 표시할 텍스트를 넣어준다.
	frm.commentBtn.value = title;
	
	// 수정 또는 삭제할 댓글 작성자 이름을 댓글 폼의 name 속성인 텍스트 상자에 넣어준다. 
	frm.name.value = name;
	
	// 수정 또는 삭제할 댓글 내용을 댓글 폼의 content 속성인 텍스트 상자에 넣어준다. 
	//frm.content.value = content;
	// 위와 같이 하면 enter가 <br/>로 나오는 문제가 생긴다.
	
	// vo.content를 넘겨받으면 자바스크립트는 이스케이프 시퀀스('\r\n')가 포함된 데이터를 
	// 인수로 받을 수 없기 때문에 정상적으로 동작되지 않는다.
	// 브라우저에 enter 키가 입력된 곳을 줄로 바꿔서 출력하기 위해서 '\r\n'을 '<br/>'로 치환해서 넣어준
	// content를 인수로 넘겨야 하고 자바스크립트에서는 '<br/>'을 다시 '\r\n'로 치환해야 한다.
	
	// java나 jsp의 replace() 메소드는 모든 내용을 일괄적으로 치환하지만 
	// javascript의 replace() 함수는 맨 처음 1개만 치환하기 때문에 인수로 넘어온 데이터에 
	// 더 이상 '<br/>'이 없을 때까지 반복하며 '\r\n'으로 치환시킨다.
	while (content.indexOf('<br/>') != -1) {
		content = content.replace('<br/>', '\r\n');
	}
	frm.content.value = content;
}








