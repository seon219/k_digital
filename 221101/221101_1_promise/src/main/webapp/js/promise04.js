// id와 password를 받아서 로그인 처리와 로그인 후 역할을 받아오는 클래스
class UserStorage {
	
	// 로그인 함수
	// loginUser(아이디, 비밀번호, 로그인 성공시 실행할 callback 함수, 로그인 실패시 실행할 callback 함수)
	loginUser (id, password, onSuccess, onError) {
		setTimeout(() => {
			if (id == '홍길동' && password == '1111' || id == '임꺽정' && password == '2222'){
				// 로그인 성공시 실행할 callback 함수 실행
				onSuccess(id);
			} else {
				// 로그인 실패시 실행할 callback 함수 실행
				onError(new Error('로그인 실패'))
			}
		}, 2000);
	}
	
	// 로그인 후 역할을 받아오는 함수
	// getRoles(아이디, 역할을 받아오면 실행할 callback 함수, 역할을 받아오지 못하면 실행할 callback함수)
	getRoles(user, onSuccess, onError) {
		setTimeout(() => {
			if (user == '홍길동'){
				onSuccess(
					{
						name: '홍길동',
						role: '관리자',
					}
				)
			} else {
				onError(new Error('권한이 없습니다.'));
			}
		},1000)
	}
}

// UserStorage 클래스의 객체를 생성
const userStorage = new UserStorage();


// id 와 password를 입력받는다.
const id = prompt('아이디를 입력하세요');
const password = prompt('비밀번호를 입력하세요');


// 로그인 처리를 한다.
userStorage.loginUser(id, password, function (user) {
	console.log('로그인 성공');
}, function (error) {
	console.log('로그인 실패');	
})










