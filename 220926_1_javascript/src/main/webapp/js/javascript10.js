// 배열에 저장된 전체 데이터 더하기
const numbers = [1, 2, 3, 4, 5];
let sum = 0;

for(let i = 0; i < numbers.length; i++){
	sum += numbers[i];
}
console.log(sum);


sum = 0;
function total(n) {
	sum += n;
}
numbers.forEach(total);
console.log(sum);


sum = 0;
numbers.forEach (function (n) {
	sum += n;
})
console.log(sum);


sum = 0;
numbers.forEach (n => sum += n)
console.log(sum);
console.log('1. ====================================┘');


// 배열.reduce(function (accumulator[, currentValue, currentIndex, array]) {
//	실행할 문장;
//	...
//	return 값; // 먼저 실행한 return 값이 다음 실행의 accumulator에 저장된다.
// })

// 배열.reduce ((accumulator[, currentValue, currentIndex, array]) => {
//	실행할 문장;
//	...
//	return 값; // 현재 실행의 return 값이 다음 실행의 accumulator에 저장된다.
// }[, accumulator의 초기치])

// accumulator: 연산 결과가 저장될 기억장소
// accumulator의 초기치를 생략하면 reduce() 함수를 실행하는 배열의 0번째 index 값이 초기치로 지정
// currentValue: reduce() 함수를 실행하는 배열의 값이 차례대로 넘어와 저장하는 변수
// currentIndex: currentValue로 넘어오는 값의 index가 저장되는 변수
// array: reduce() 함수를 실행하는 배열 자신을 의미


// 최초 실행 시 accumulator의 초기치를 accumulator에 저장한 후 반복이 시작되고,
// 그 다음부터는 현재 실행의 return 값이 다음 실행의 accumulator에 저장한 후 끝까지 반복
sum = numbers.reduce(function (accumulator, currentValue, currentIndex, array) {
	console.log(accumulator, currentValue, currentIndex, array);
	return accumulator + currentValue;
}, 0);
console.log(sum);


sum = numbers.reduce((accumulator, currentValue) => {
	return accumulator + currentValue;
}, 0);
console.log(sum);


sum = numbers.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
console.log(sum);

console.log('2. ====================================┘');


// 배열에 저장된 데이터 중에서 10보다 큰 데이터의 개수
const numbers2 = [1, 2, 3, 4, 5, 10, 20, 30, 40, 50, 60];
let count = 0;
for(let i = 0; i < numbers2.length; i++){
	if (numbers2[i] > 10) {
		count++;
	}
}
console.log(count);
console.log('3. ====================================┘');

function tenOverNumber(numbers) {
	let count = 0;
	numbers.forEach(n => {
		if (n > 10) {
			count++;
		}
	})
	return count;
}
count = tenOverNumber(numbers2);
console.log(count);
console.log('4. ====================================┘');


function tenOverNumber2(numbers) {
	return numbers.filter(function (n){
		return n > 10;
	})
} 
count = tenOverNumber2(numbers2);
console.log(count)
console.log(count.length)
console.log('5. ====================================┘');

function tenOverNumber2(numbers) {
	return numbers.filter(n => n > 10).length
} 
count = tenOverNumber2(numbers2);
console.log(count)
console.log('6. ====================================┘');

function tenOverNumber3(numbers) {
	return numbers.reduce(function (acc, curr) {
		if (curr > 10) {
			// 조건을 만족하면 10이상인 경우이므로 현재 acc 값에 1을 더해서 다음으로 넘겨준다.
			// acc++를 사용하면 현재 acc 값인 0을 다음 실행의 acc에 넣어주기 때문에 최종 결과가 0이 나온다.
			return ++acc; // ++acc와 acc+1은 같은 결과를 얻을 수 있다.
		} else {
			// 조건을 만족하지 않으면 10 이하인 경우이므로 현재 acc 값을 그대로 다음으로 넘겨준다.
			return acc;
		}
	})
} 
count = tenOverNumber3(numbers2);
console.log(count)
console.log('7. ====================================┘');


// 배열에 저장된 문자 개수세기
const alpha = ['a', 'a', 'a', 'b', 'c', 'c', 'd', 'e'];

const alphaCount = alpha.reduce(function (acc, curr) {
	//console.logaa(acc, curr)
	if (acc[curr]){// 객체에 curr에 저장된 key가 있는가?
		// key가 있으면 문자의 개수를 증가시킨다
		acc[curr] += 1;
	} else {
		// key가 없으면 1로 초기화한다
		acc[curr] = 1;
	}
	return acc;
}, {}) // acc를 빈 객체로 초기화
console.log(alphaCount)














