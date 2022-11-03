// id와 password를 받아서 로그인 처리와 로그인 후 역할을 받아오는 클래스
class UserStorage {
	
	// callback 지옥에 빠진 이유는 함수가 성공시 실행할 함수와 실패시 실행할 함수를 인수로 받았기 때문
	// promise를 사용하면 성공시는 resolve()로 실패시 reject()로 처리하면 된다
	//loginUser (id, password, onSuccess, onError) {
	loginUser (id, password) {
		// 함수가 호출되면 Promise를 만들어 리턴시킨다,
		return new Promise((resolve, reject) => {
			// 기존에 있던 코드를 Promise의 executor 함수에서 실행
			setTimeout(() => {
				if (id == '홍길동' && password == '1111' || id == '임꺽정' && password == '2222'){
					//onSuccess(id);
					resolve(id);
				} else {
					//onError(new Error('로그인 실패'))
					reject(new Error('로그인 실패'));
				}
			}, 2000);
			
		})
			
	}
	
	// 로그인 후 역할을 받아오는 함수
	getRoles(user) {
		return new Promise((resolve, reject) => {
			setTimeout(() => {
				if (user == '홍길동'){
					//onSuccess({name: '홍길동', role: '관리자'})
					resolve({name: '홍길동', role: '관리자'})
				} else {
					//onError(new Error('권한이 없습니다.'));
					reject(new Error('권한이 없습니다.'))
				}
			},1000)
		})
	}
}

const userStorage = new UserStorage();


const id = prompt('아이디를 입력하세요');
const password = prompt('비밀번호를 입력하세요');


/*
userStorage.loginUser(
	id, 
	password, 
	user => {
		console.log('로그인 성공');
		
		userStorage.getRoles(
			user, 
			userWithRole => {
				alert(`안녕하세요. ${userWithRole.name}님 당신의 권한은 ${userWithRole.role} 입니다.`)
			},
		 	console.log);
	},
	console.log);
*/


userStorage.loginUser(id, password)
	.then(id => userStorage.getRoles(id))
	.then(userWithRole => alert(`안녕하세요. ${userWithRole.name}님 당신의 권한은 ${userWithRole.role} 입니다.`))
	

