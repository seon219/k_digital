const slime = {
	name: '슬라임',
};

const cuteslime = {
	name: '슬라임',
	attribute: 'cute',
};

const purpleCuteslime = {
	name: '슬라임',
	attribute: 'cute',
	color: 'purple'
};

console.log(slime);
console.log(cuteslime);
console.log(purpleCuteslime);
console.log('=====================================');

// ... => spread 연산자 => ES6에서 추가 => 객체나 배열 내부의 다른 객체나 배열을 퍼뜨린다.

const slime2 = {
	name: '슬라임',
};

const cuteslime2 = {
	...slime2,
	attribute: 'cute',
};

const purpleCuteslime2 = {
	...cuteslime2,
	color: 'purple'
};

console.log(slime2);
console.log(cuteslime2);
console.log(purpleCuteslime2);
console.log('=====================================');

// spread 연산자는 배열에도 사용할 수 있다.
const animal = ['개', '고양이', '참새']
console.log(animal);
const animal2 = animal.concat('비둘기');
console.log(animal2);
const animal3 = [...animal2, '닭둘기']
console.log(animal3);