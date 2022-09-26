// 객체
const dog = {
	// key: value
	name: '멍멍이',
	age: 2
}

console.log(dog);
console.log(dog.name);
console.log(dog.age);
dog.name = '고양이'
console.log(dog);
console.log('=====================================');

const ironMan = {
	name: '토니 스타크',
	actor: '로버트 다우니 주니어',
	alias: '아이언맨'
}
console.log(ironMan);

const captainAmerica = {
	name: '스티븐 로저스',
	actor: '크리스 에반스',
	alias: '캡틴 아메리카'
}
console.log(captainAmerica);
console.log('=====================================');


// 아이언맨(토니스타크) 역할을 맡은 배우는 로버트 다우니 주니어 입니다.
function print (hero) {
	const str = `${hero.alias}(${hero.name}) 역할을 맡은 배우는 ${hero.actor} 입니다.`;
	console.log(str);
}
print(ironMan)

function print2 (hero) {
	const str = `${hero.alias}(${hero.name}) 역할을 맡은 배우는 ${hero.actor} 입니다.`;
	console.log(str);
}
print2(captainAmerica)
console.log('=====================================');

// 비구조화 할당 => 객체 구조 분해
function heroprint (hero) {
	// 인수 hero로 받은 객체 내부의 값을 외부로 꺼내온다
	// 비구조화 할당을 통해서 객체 내부의 값을 꺼내서 저장할 변수의 이름은 객체에서 사용한 key 이름과 반드시 같아야 한다.
	// const (key, ...) = 객체;
	const {name, actor, alias} = hero;
	const str = `${alias}(${name}) 역할을 맡은 배우는 ${actor} 입니다.`;
	console.log(str);
}
heroprint(ironMan);
heroprint(captainAmerica);
console.log('=====================================');

// 객체를 인수로 받을 떄 비구조화 할당을 할 수 있다.
function heroprint2 ({name, actor, alias}) {
	const str = `${alias}(${name}) 역할을 맡은 배우는 ${actor} 입니다.`;
	console.log(str);
}
heroprint2(ironMan);
heroprint2(captainAmerica);
console.log('=====================================');

// 비구조화 할당은 함수 외부에서도 가능
const {name, actor, alias} = ironMan;
console.log(name);
console.log(actor);
console.log(alias);






