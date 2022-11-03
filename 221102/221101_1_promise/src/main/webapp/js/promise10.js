// Promise 만들기 1
// Promise 객체를 만들어서 변수에 할당
const job = new Promise((resolve, reject) => {
	setTimeout(() => {
		resolve('job ok')
	}, 2000)
})

job.then(data => {
	console.log("data: " + data)
})


const job2 = new Promise((resolve, reject) => {
	setTimeout(() => {
		reject('job2 fail')
	}, 2000)
})

job2.catch(error => {
	console.log("error: ", error)
	console.log("====================================")
})

// ============================================
// Promise 만들기 2
// 함수에서 Promise 객체를 만들어서 리턴
function job3() {
	return new Promise((resolve, reject) => {
		setTimeout(() => {
			reject('job3 fail');
		}, 2000)
	})
}

job3().catch(error2 => {
	console.log("error: ", error2);
})


function job4() {
	return new Promise((resolve, reject) => {
		setTimeout(() => {
			resolve('job4 ok')
			//reject('job4 에러발생')
		}, 2000)
	})
}

job4().then(data2 => {
	console.log("data2: ", data2);
	console.log("====================================")
})

// ==============================================

job3()
	.catch(error3 => {
		console.log("error3: ", error3);
		job4()
			.then(date3 => {
				console.log("date3: ", date3);
				console.log("====================================")
			})
	})


job4()
	.then(data4 => {
		console.log("data4: ", data4)
		return job3();
	})
	.catch(error4 => {
		console.log("error4: ", error4);
		// Promise에서 오류가 발생했을 때 Promise 객체에 reject()함수를 실행하면 이어지는 작업을 중지할 수 있다.
		return Promise.reject(error4);
	})
	.then(data4 => {
		console.log("앞의 작업이 실패하면 이곳의 작업은 실행하지 않는다.")
		console.log("=======================================")
	})
	