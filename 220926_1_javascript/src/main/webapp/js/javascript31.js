function locationTest() {
	// location.href='https://www.naver.com';
	// location 객체의 assign() 함수는 location.href와 같은 기능이 실행
	location.assign('http://www.naver.com');
	
	// location 객체의 replace() 함수는 location.href, location.assign()와 같은 기능을 실행하지만,
	// location.href, location.assign()는 돌아가기 버튼을 사용할 수 있지만, location.replace()를 사용하면 돌아가기 버튼을 사용할 수 없다.
	location.replace('http://www.naver.com');
	
	
}




























