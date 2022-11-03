// 인수로 받은 시간이 경과한 후 넘겨받은 시간을 리턴하는 Promise를 리턴하는 함수
/*
function timer(time) {
	return new Promise(function (resolve, reject) {
		setTimeout(function() {
			resolve(time);
		}, time)
	})
}

timer(1000).then(function (time) {
	console.log('time: ', time);
})
*/


function timer(time) {
	return new Promise((resolve, reject) => {
		setTimeout(() => resolve(time), time)
	})
}

timer(1000).then(time => console.log('1. time: ', time))

// =========================================================================

// timer() 함수 실행 앞, 뒤에 start, end 표시
console.log('start 1')
timer(1000)
	.then(time => {
		console.log('2. time: ', time)
		// then() 함수에서 리턴하는 값을 다음 then() 함수에서 받을 수 있다.
		return timer(time + 1000)
	})
	.then(time => {
		console.log('3. time: ', time)
		return timer(time + 1000)
	})
	.then(time => {
		console.log('4. time: ', time)
		console.log('end 1') // 여기에 코딩해야 모두 완료된 후 출력된다.
	})
	

// 위에서 실행한 것돠 동일한 결과를 가지는 async, await를 사용하는 함수로 수정
async function run() {
	console.log('start 2');
	let time = await timer(1000);
	console.log('11. time: ', time);
	time = await timer(time + 1000);
	console.log('22. time: ', time);
	time = await timer(time + 1000);
	console.log('33. time: ', time);
	console.log('end 2');
	// async 함수가 결과를 리턴하면 제일 마지막에 코딩
}


// run() 함수 앞, 뒤에 parent start, parent end 표시
/*
console.log('parnet start');
run();
console.log('parnet end');
*/


// run() 함수를 await를 붙여서 run2() async 함수로 만든다.
async function run2() {
	console.log('parnet start');
	run();
	console.log('parnet end');
}

run2();





