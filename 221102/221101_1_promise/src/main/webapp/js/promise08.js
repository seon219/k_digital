// 기존에 존대하는 것(Promise) 위에 또는 기존에 존재하는 것을 감싸서 좀 더 편하게 사용할 수 있게 해주는 것일 syntatic suger라 한다.
// async와 await를 사용하면 Promise를 보다 깔끔하게 사용할 수 있다.

// Promise
function fetchUser() {
	// 작업 시간이 오래 걸리는 작업이 있다면 비동기적으로 처리를 할 수 있게 해야 한다.
	// Promise를 리턴하면 pending 상태로 리턴된다.
	return new Promise((resolve, reject) => {
		// Promise 내부에서는 resolve() 또는 reject()를 실행해서 완료해줘야 한다.
		//return '홍길동'; // pending 상태로 리턴
		resolve('홍길동'); // fulfilled 상태로 리턴
		//reject('홍길동'); // rejected 상태로 리턴
	})
}


// javascript는 기본적으로 동기적으로 실행되기 때문에 함수를 실행할 때 비동기 처리를 하지 않으면
// 함수의 실행이 종료될 때까지 기다리는 문제가 발생한다.
const user = fetchUser();
console.log('1. ', user);
user.then(response => console.log('1. ', response))

// ========================================================================

// async
// 함수 앞에 async를 붙이면 함수 내부의 코드가 자동으로 Promise로 변경된다.
async function fetchUser2() {
	return '홍길동';
}

const user2 = fetchUser2();
console.log('2. ', user2);
user2.then(response => console.log('2. ', response));


// await
/*
function delay(ms) {
	return new Promise((resolve, reject) => {
		setTimeout(function() {
			resolve();
		}, ms)
	})
}
*/

function delay(ms) {
	return new Promise((resolve, reject) => {
		setTimeout(() =>resolve(), ms)
	})
	
}


// async를 붙여서 Promise를 리턴하도록 설정한 getApple() 함수는 await에 의해 delay() 함수가 끝나기를 기다렸다가 delay() 함수라 종료되면 Promise를 리턴
async function getApple() {
	// await는 asyn가 붙은 함수에서만 사용할 수 있고 await를 붙여준 함수가 끝나기를 기다렸다가 다음 작업을 실행
	delay(2000);
	return '사과';
}

async function getBanana() {
	delay(1000);
	return '바나나';
}

// Promise도 지나치게 chaining을 하면 callback 지옥현상이 나타난다.
/*
function pickFruits() {
	return getApple()
		.then(apple => {
			console.log('pickFruits: ', apple);
			return getBanana ()
				.then(banana => {
				console.log('pickFruits: ', banana);
				return `${apple} + ${banana}`;
			})
		})
}
*/

// async와 await를 사용하면 동기적 프로그램을 작성하는 것처럼 비동기 프로그램을 작성할 수 있다.
// 순차적 처리
/*
async function pickFruits() {
	const apple = getApple(); // 2초
	const banana = getBanana(); // 1초
	return `${apple} + ${banana}`
}
*/


// 병렬(동시) 처리
async function pickFruits() {
	// Promise가 만들어지는 순간 Promise의 executor 함수가 실행
	const applePromise = getApple();
	const bananaPromise = getBanana();
	const apple = await getApple(); // 2초
	const banana = await getBanana(); // 1초짜리라 이미 종료되어 있다.
	return `${apple} + ${banana}`
}


//console.log(pickFruits()); // Promise{<fulfilled: '사과'>}
pickFruits().then(result => console.log('3. ', result));


// ========================================================================


// Promise가 서로 연관이 없을 경우 병렬 처리할 때 위와 같이 작성하지 않고,
//  아래와 같이 all() 함수를 사용해서 작성할 수 있다.
function pickAllFruits() {
	// all() 함수의 인수가 Promise가 저장된 배열을 전다랗면 배열로 전달한 모든 Promise가 종료되면 Promise의 결과가 then()으로 전달된다.
	return Promise.all([getApple(), getBanana()])
		.then(fruits => fruits.join(' + '));
}

pickAllFruits().then(result => console.log('4. ', result));


// ========================================================================


// race() 함수를 사용
function pickOnlyOne() {
	// race() 함수의 인수로 Promise가 저장된 배열을 전달하면 배열로 전달한 Promise 중에서 가장 먼저 종료되는 Promise의 결과가 then()으로 전달
	// 나머지 Promise는 무시된다.
	return Promise.race([getApple(), getBanana()])
}

pickOnlyOne().then(result => console.log('5. ', result));





