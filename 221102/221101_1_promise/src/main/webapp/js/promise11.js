function timer(time) {
	return new Promise((resolve, reject) => {
		setTimeout(() => resolve(time), time)
	})
}

console.time('Promise.all');
Promise.all([timer(1000), timer(2000), timer(3000)])
	.then(result => {
		console.log('result: ', result);
		console.timeEnd('Promise.all');
	})

console.time('Promise.race');
Promise.race([timer(1000), timer(2000), timer(3000)])
	.then(result => {
		console.log('result: ', result);
		console.timeEnd('Promise.race');
	})











