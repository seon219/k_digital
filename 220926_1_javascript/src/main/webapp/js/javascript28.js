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