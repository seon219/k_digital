// 변수(variavle)
'use strict' // 변수가 varl, let, const로 선언되지 않으면 에러를 발생


// 변수의 타입
// primitive type(기본자료형, 원시자료형)
//		=> number(숫자), String(문자), boolean(논리), null, undefined, symbol(ES6)
// object(객체), box container
// function => 함수도 변수에 할당이 가능
//		=> 함수의 인수로 전달도 가능. 함수의 결과로 리턴도 가능 => 일급함수


// var를 사용해서 선언한 변수는 프로그램 어디에서 선언하던지 변수 선언만 항상 맨 위로 끌어올려진다.
// 변수를 선언만 하고 값을 할당하지 않으면 undefined가 된다.
// var age;
console.log('age: ' + age); // undefined

// var
// variavle hoistion: 아래에 var로 선언한 변수를 맨 위로 끌어올린다.
// 어디에서 선언했는지에 상관없이 항상 제일 위로 변수 선언을 끌어올리는 것을 말한다.
console.log('age: ' + age); // undefined
var age = 20;
console.log('age: ' + age); // 20
var age = '열살'; //var는 같은 이름의 변수를 다시 선언할 수 있다.
console.log('age: ' + age); // 열살
console.log('=====================================');


// var는 block scope를 사용하지 않고 function scope를 사용 => 유연성
// block scope: 변수가 선언된 {}블록 내부에서만 사용할 수 있다 => let, const
// function scope: 변수가 선언된 함수에서만 사용할 수 있다. = > var
// block scope는 변수가 선언된 {} 블록 밖으로 나가면 소멸되고 function scope는 변수가 선언된 함수가 종료되면 선언

// let => ES6에서 추가
// block scope: {} 내부의 내용은 {}외부에서 접근할 수 없다.

let globalName = '장길산';
{
	let name = '홍길동';
	console.log('name: ' + name);
	// let name = '임꺽정'; //에러, 같은 이름의 변수를 다시 선언할 수 없음
	name = '임꺽정';
	console.log('name: ' + name);
	console.log('globalName: ' + globalName);
}
console.log('name: ' + name); // 아무런 값이 출력되지 않는다.
console.log('globalName: ' + globalName);



// 상수(constant)
// 선언시 값을 할당한 다음 값을 변경할 수 없는 데이터 타입, 보안성
// const maxNumber; //상수는 최초 선언 시 값을 할당해야 하므로 에러가 발생
const maxNumber = 100;
console.log('maxNumber: ' + maxNumber);
// maxNumber = 200; // 상수로 선언한 변수에 값을 할당하려했으므로 에러가 발생
console.log('=====================================');


// template: `(그레이브)를 사용 => ${ ~ } 사이에 출력
// typeof 명령으로 변수의 자료형을 확인할 수 있다.
let count = 17.5;
const size = true;
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);

// 자바 스크립트는 나눗셈을 0으로 하면 결과가 infinity가 된다.
const infinity = 1/0;
console.log(`value: ${infinity}, type: ${typeof infinity}`);
const negativeInfinity = -1/0;
console.log(`value: ${infinity}, type: ${typeof infinity}`);
const nan = 'Not A Number'/0;
console.log(`value: ${infinity}, type: ${typeof infinity}`);
console.log('=====================================');

// dynamic typing(동적 자료형): 변수에 저장되는 데이터의 타입에 맞춰 변수와 타입이 결정
let text ="Hello";
console.log(`value: ${text}, type: ${typeof text}`);
text ="1";
console.log(`value: ${text}, type: ${typeof text}`);
console.log('=====================================');

// symbol: 고유한 식별자를 만들 때 사용
const symbol = Symbol('id');
console.log(symbol);
console.log(`type: ${typeof symbol}`);
const symbol2 = Symbol('id');
console.log(symbol2);
console.log(`type: ${typeof symbol2}`);
console.log(symbol == symbol2);
console.log('=====================================');

// object 객체
const obj = {
	name: '홍길동',
	age : 20
}
console.log(obj);
console.log(obj.name);
console.log(obj.age);
obj.age = 21;
console.log(obj);
console.log(typeof obj);

const obj2 = {
	name: '홍길동',
	age : 30
}
console.log(obj2);
console.log(typeof obj2);

