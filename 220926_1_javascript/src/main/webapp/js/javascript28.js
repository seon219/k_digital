function randomNumber(number) {
	// random(): 0 이상이고 1미만인 무작위수를 발생
	for (let i = 0; i < 6; i++){
		console.log(parseInt(Math.random() * number) + 1);
	}
		console.log('=========');
		
		// ceil(): 올림, floor():내림, round():반올림
		console.log('올림: ' + Math.ceil(3.14));
		console.log('내림: ' + Math.floor(3.94));
		console.log('반올림: ' + Math.round(3.44));
		console.log('반올림: ' + Math.round(3.54));		
}

function randomBGColor() {
	/*
	let r = Math.floor(Math.random() * 256);
	let g = Math.floor(Math.random() * 256);
	let b = Math.floor(Math.random() * 256);
	
	console.log('r: ' + r + ', g: ' + g + ', b: ' + b)
	
	//document.body.style.backgroundColor = 'rgb(' + r + ', ' + g + ', ' + b +')'
	document.body.style.backgroundColor = `rgb(${r}, ${g}, ${b})`
	*/
	
	/*
	let ren = function() {
		return Math.floor(Math.random() * 256);
	}
	document.body.style.backgroundColor = 'rgb(' + ren() + ', ' + ren() + ', ' + ren() +')'
	*/
	
	let ren = () => Math.floor(Math.random() * 256);

	document.body.style.backgroundColor = `rgb(${ren()}, ${ren()}, ${ren()})`
}


function randomCircle() {
	let radius = Math.floor(Math.random() * 100) + 1;
	console.log('원의 반지름: ' + radius);
	
	let circle = document.getElementById('circle');
	circle.style.width = radius * 2 + 'px';
	circle.style.height = radius * 2 + 'px';
	
	let ren = () => Math.floor(Math.random() * 256); // color
	circle.style.border = '2px solid ' + `rgb(${ren()}, ${ren()}, ${ren()})`;
	circle.style.backgroundColor = `rgb(${ren()}, ${ren()}, ${ren()})`
	circle.style.borderRadius = '50%'
}


function randomCircleArea() {
	let circleWidth = document.getElementById('circle').style.width; //width 속성의 값을 얻어온다.
	console.log('원의 지름: ' + circleWidth);
	
	let width = circleWidth.substring(0, circleWidth.length-2);
	console.log('원의 지름: ' + width);
	
	width = parseInt(circleWidth);
	console.log('원의 지름: ' + width); //px 빼고 숫자만 추출
	
	let radius = width / 2;
	console.log('원의 반지름: ' + radius);
	
	
	let area = Math.PI * Math.pow(radius, 2); // 원의 너비
	let len = 2 * Math.PI * radius; // 원의 둘레
	
	document.getElementById('area').innerHTML = Math.round(area);
	document.getElementById('len').innerHTML = Math.round(len);
}






