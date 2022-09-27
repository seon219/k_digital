const object =[//배열
	{ // 0번째 인덱스
		name: `멍멍이`,
	},
	{ // 1번째 인덱스
		name: `야옹이`,
	}
];

console.log(object);
console.log(object.length);
console.log(object[0]);
console.log(object[1]);
console.log(object[2]); // undefined, 배열의 인덱스 범위를 벗어났다.
console.log(object[0].name);
console.log(object[1].name);
console.log('=====================================');

// push(): 배열에 데이터를 추가
const hong = {
	name: '길동이',
}
object.push(hong);
console.log(object);


object.push({ //익명사용
	name: '꺽정이',
})
console.log(object);
console.log('=====================================');

const doggy = {
	name : '멍멍이',
	sound: '멍멍',
	age: 2
}

// Object.values(): 인수로 지정된 객체의 key에 할당된 value 값을 배열로 묶어서 얻어온다.
const values = Object.values(doggy);
console.log(`Object.values(doggy): ` + values); //멍멍이,멍멍,2
console.log(values.length);

for (let i =0; i<values.length; i++){ // 일반 for
	console.log(values[i]);
}
console.log('=====================================');


// Object.key(): 인수로 지정된 객체의 key값을 배열로 묶어서 얻어온다.
const keys = Object.keys(doggy);
console.log(`Object.keys(doggy): ` + keys);
console.log(keys.length);

for (let key of keys) { //향상된 for
	console.log(key)
}
console.log('=====================================');

// Object.entries(): 인수로 지정된 객체의 key와 value를 한 쌍으로 묶은 배열로 얻어온다.
const entries = Object.entries(doggy);
console.log(`Object.entries(doggy): ` + entries);
console.log(entries.length);

// in을 사용하는 for는 in 뒤에 배열이 나오면 배열의 인덱스가 변수에 저장되며 반복된다.
for (let entrie in entries) {
	console.log(entries[entrie])
}
console.log('=====================================');

// in을 사용하는 for는 in 뒤에 객체가 나오면 객체의 key가 변수에 저장되며 반복된다.
for (let d in doggy) { //향상된 for
	console.log(d)
}
console.log('=====================================');

// 객체의 멤버에 접근하는 방법은 객체 이름에 '.'을 찍어서 접근한는 방법과 []안에 key를 사용해서 접근하는 방법
console.log(doggy.name); //.으로 접근
console.log(doggy['name']); //['key']로 접근, ''를 안하면 변수로 인식

for (let key of keys) { 
	console.log(doggy[key])
}
