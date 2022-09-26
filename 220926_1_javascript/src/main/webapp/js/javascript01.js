// 선언하지 않은 변수를 사용하려면 에러가 발생
'use strict' // ECMA Script5 에서 추가

console.log('Hello World');
// 자바 스크립트는 변수를 선언할 때 앞에 자료형을 쓰지 않는다.
// 변수에 대입되는 데이터의 형태에 따라 자동으로 변수의 자료형이 결정됨
// int a = 100; //에러발생
// d = 100; // 선언하지 않은 변수이기 때문에 에러 발생
// console.log('d: '+ d);

// ECMA Script 부터 변수를 선언할 때 앞에 var를 붙여서 선언하기 시작
var a = 200;
console.log('a: '+ a);
// 먼저 선언한 변수를 다시 선언할 수 있는 문제점
var a = 'abcd';
console.log('a: '+ a);

// ECMA Script16 부터 변수를 선언할 때 앞에 let이나 const 를 붙여서 선언하기 시작
let b = 300;
console.log('b: '+ b);
// let은 먼저 선언한 변수를 다시 선언하면 에러가 발생
// let b = 'abcd'; // 에러발생
b = 'abcd';
console.log('b: '+ b);

const c = 400;
console.log('c: '+ c);
