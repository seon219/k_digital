function searchParent() {
	let child = document.getElementsByTagName('p')[0];
	console.log(child);
	
	// parentNode는 탐색된 요소(element)의 부모 요소를 탐색
	let parentDiv = child.parentNode;
	console.log(parentDiv);
	parentDiv.style.backgroundColor = 'pink';
	
	console.log(parentDiv.nodeName); // 탐색된 요소의 태그 이름 얻어오기
	
}


function searchChild() {
	let parent = document.getElementsByTagName('div')[0];
	console.log(parent);
	
	/* 
	// children은 탐색된 요소의 자식요소(태그)만 탐색
	let childs = parent.children;
	console.log(childs);
	
	console.log(childs[0]);
	console.log(childs[1]);
	console.log(childs[2]);
	
	childs[0].style.backgroundColor = 'skyblue';
	childs[1].style.backgroundColor = 'yellowgreen';
	childs[2].style.backgroundColor = 'dodgerblue';
	*/
	
	// childNodes는 탐색된 요소의 자식요소(태그 및 텍스트)를 탐색
	let childs = parent.childNodes;
	console.log(childs);
	
	console.log(childs[1]);
	console.log(childs[3]);
	console.log(childs[5]);
	
	childs[1].style.backgroundColor = 'skyblue';
	childs[3].style.backgroundColor = 'yellowgreen';
	childs[5].style.backgroundColor = 'dodgerblue';
	
}


function testSearch() {
	let test1 = document.getElementsByTagName('p')[3];
	console.log(test1);
	
	let div = test1.parentNode;
	console.log(div);
	div.style.backgroundColor = 'pink';
	
	
	let test4 = document.getElementsByTagName('div')[3];
	console.log(test4);
	
	let childs = test4.childNodes;
	console.log(childs);
	console.log(childs[3]);
	childs[3].style.fontSize = '20px';
	
}

















