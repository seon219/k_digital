// JSON(JavaScript Object Notation)

// javascript 객체를 json으로 변환하기
// stringify(객체): 인수로 지정된 javascript 객체를 json 객체로 변환한다.
let json = JSON.stringify(true); //JSON 객체는 대문자로 사용해야 한다.
console.log(json);
console.log('1.====================');


json = JSON.stringify(['apple', 'banana']);
console.log(json);
console.log('2.====================');


// 자바스크립트 객체
const rabbit = {
	name: '토끼',
	color: '흰색',
	size: '왕큼',
	// 자바스크립트 객체나 함수는 stringify() 함수 실행 시 json 형태로 변환하지 않는다.
	birthDate : new Date(),
	jump: () => console.log('jump')
}
console.log(rabbit);


// json은 key 부분을 반드시 큰따옴표를 사용하는 문자열 형태로 만들어야 한다,
json = JSON.stringify(rabbit);
console.log(json);
console.log('3.====================');


// stringify() 함수의 2번째 인수로 json으로 변환할 속성을 배열로 지정할 수 있다.
json = JSON.stringify(rabbit, ['name', 'color']);
console.log(json);
console.log('4.====================');


// 보다 더 세밀한 제어를 하기 위해서 2번째 인수로 콜백 함수를 지정할 수 있다.
json = JSON.stringify(rabbit, (key, value) => {
	console.log(`key: ${key}, value: ${value}`);
	//console.log('key: ' +key + ', value: ' + value);
	//return value;
	return key == 'name' ? '별주부' : value
});
console.log(json);
console.log('5.====================');


// json을 javascript 객체로 변환
// parse(json): 인수로 지정된 json을 javascript 객체로 변환
// console.clear(); // 콘솔 창에 출력한 내용을 지운다

// rabbit 객체를 json으로 변경한 후 다시 자바스크립트 객체로 변환
json = JSON.stringify(rabbit);
console.log(json);
const obj = JSON.parse(json);
console.log(obj);
console.log('6.====================');


rabbit.jump();
// 자바스크립트 객체의 함수는 json 형태로 변환시킬 수 없다.
// obj.jump();

console.log(rabbit.birthDate.getDate());
// json에 포함한 날짜도 문자열 형태임로 객체로 변환되지 않는다.
//console.log(obj.birthDate.getDate());
console.log('7.====================');


// 보다 더 세밀한 제어를 하기 위해서 2번째 인수로 콜백 함수즐 지정할 수 있다.
const json2 = JSON.parse(json, function (key, value) {
	console.log(`key: ${key}, value: ${value}`);
	//return value;
	return key == 'birthDate' ? new Date() : value;
})
console.log(json2);
console.log(json2.birthDate.getDate());
console.log('8.====================');


// json 관련 유용한 사이트
// 1. json diff(https://json-diff.com/) => 서버로 요청해 응답받은 데이터를 비교
// 2. JSON Beautifier(https://codebeautify.org/jsonviewer) => json 포맷을 예쁘게 만든다.
// 3. JSON Parser(http://json.parser.online.fr/) => json 데이터를 객체 형태로 만든다.
// 4. json validator(https://jsonformatter.curiousconcept.com/) => json 데이터가 요효한지 검사한다.



