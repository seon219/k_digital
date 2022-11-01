// 동기 방식 처리 => 순서대로 실행
console.log('1');
console.log('2');
console.log('3');
// 위와 같이 실행하면 순서대로 실행해서 1, 2, 3이 출력된다
console.log('동기방식===================');


// 비동기 방식 처리
console.log('1');
// setTimeout(함수, 시간): 지정된 시간이 경과된 후 함수를 싱행
/*
setTimeout(function() {
	console.log('2');
}, 1000)
*/
setTimeout(() => console.log('2'), 1000)
console.log('3');


// 동기적 콜백
// 변수가 var로 선언되거나 함수가 선언되면 호이스팅에 의해서 맨 위로 올라간다.
function printImmdiately(print) {
	print();
}

printImmdiately(() => console.log('hello'));


// 비동기적 콜백
function printWithDelat(print, timeout) {
	setTimeout(print, timeout);
}

printWithDelat(() => console.log('async callback'), 1000);

