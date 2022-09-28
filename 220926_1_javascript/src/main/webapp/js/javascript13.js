// falsy: 무조건 거짓이 되는 값 => undefiend, null, 0, '', NaN 

// 단축평가(short-circuit evaluation) 논리 계산법
// && 논리 연산에서 앞의 조건이 true면 && 뒤에 내용이 출력된다.
console.log(true && 'hello');

// && 논리 연산에서 앞의 조건이 false면 && 뒤에 내용은 볼 필요가 없으므로 false가 출력된다.
console.log(false && 'hello');
console.log('=====================================');

const dog = {
	name: '멍멍이'
}

/*
function getName(animal) {
	console.log(animal);
	if(animal) {
		return animal.name;
	}
	return undefined;
}
*/

function getName(animal) {
	console.log(animal);
	return animal && animal.name;
}

const name = getName(dog);
console.log(name);
const name2 = getName();
console.log(name2);
console.log('=====================================');


// || 논리 연산에서 앞의 조건이 true면 || 뒤에 내용은 볼 필요가 없으므로 true가 출력된다
console.log(true || 'hello');

// || 논리 연산에서 앞의 조건이 false면 || 뒤의 값이 출력된다.
console.log(false || 'hello');
console.log('=====================================');

const cat = {
	name: '야옹이'
}

function getName2(animal) {
	const name = animal || animal.name;
	console.log(name);
	if (name) {
		return name.name;
	} else {
		return '너... 누구야???';
	}
}

const name3 = getName2(cat);
console.log(name3);
//const name4 = getName2(); // 에러발생
//console.log(name4);

