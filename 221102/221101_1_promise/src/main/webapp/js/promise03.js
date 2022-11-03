// 일급 객체(first-class)
// 컴퓨터 프로그래밍 언어 디자인에서 일급 객체란 다른 객체들에 일반적으로 적용 가능한 연산을 모두 지원하는 객체를 의미
// 함수에 인수로 넘기기, 수정하기, 변수에 대입하기와 같은 연산을 지원할 때 일급 객체라고 한다.

// 아래 3가지 조건을 충족한다면 일급 객체라고 할 수 있다.
// 1. 변수에 할당할 수 있어야 한다.
// 2. 객체의 인수로 넘길 수 있어야 한다.
// 3. 객체의 리넡값으로 리턴할 수 있어야 한다.

// javascript filter 함수 구현하기
const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];

function callback (element) {
	console.log(element);
}

//words.filter(callback);
words.filter(element => console.log(element));
console.log('1.==================================');


function callback2 (element) {
	//console.log(element);
	if (element.length > 6) {
		return element;
	}
}


let newWords = words.filter(callback2);
console.log(newWords);
console.log('2.==================================');


function callback3 (element) {
	if (element.length > 6) {
		return true;
	} else {
		return false;
	}
}

newWords = words.filter(callback3);
console.log(newWords);
console.log('3.==================================');


function callback4 (element) {
	// element.length > 6 실행결과 자체가 논리값이므로 바로 리턴해도 된다
	return element.length > 6;
}

newWords = words.filter(callback4);
console.log(newWords);
console.log('4.==================================');


// 익명함수를 바로 넣어준다.
newWords = words.filter(function (element) {
	return element.length > 6;
});
console.log(newWords);
console.log('5.==================================');


// 익명함수를 arrow 함수로 변경
newWords = words.filter((element) => {
	return element.length > 6;
});
console.log(newWords);
console.log('6.==================================');


// arrow 함수를 생략형으로 변경
// 함수의 인수가 1개일 경우()를 생략할 수 있다.
// 함수가 실행할 문장이 1개일 경우 {}를 생략할 수 있다. 이때 1문장이 return 이라면 return도 생략한다.
newWords = words.filter(element => element.length > 6);
console.log(newWords);
console.log('7.==================================');



// newWords = words.filter(element => element.length > 6)와 같은 기능 구현하기
function myFilter(origin, callback) {
	let result = []; // 조건에 맞는 결과를 가억할 빈 배열을 선언
	for (let i = 0; i <origin.length; i++) {
		// 원본 데이터가 저장된 배열의 각 요소를 하나씩 꺼내서 변수에 넣는다
		let current = origin[i];
		if(callback(current)) {
			// callback 함수의 조건에 만족하는 요소를 배열에 추가한다.
			result.push(current);
		}
	}
	
	return result;
}
newWords = words.filter(element => element.length > 6);
console.log(newWords);
console.log('8.==================================');








