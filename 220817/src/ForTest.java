
public class ForTest {

	public static void main(String[] args) {
		
//		 for는 {}을 조건이 만족하는 동안 반복해서 실행
//		 반복 횟수가 알려져 있는 경우 
//		 for(자료형 변수이름(제어변수) = 초기치; 조건식; 증감치;) {
//			 조건이 참인 동안 반복할 문장;
//		 }
		
		int sum = 0;
		
		// i를 1로 초기화 후, 조건 비교시 만족할 경우 반복 시작
		// 조건을 만족하면 {}블록의 내용을 실행하고 i를 증감치 만큼 변경한 후 
		// 조건을 만족하면 {}블록을 실행하고 조건을 만족하지 않으면 반복 종료
		for (int i=1; i<=10; i++) {
			sum += i; // sum = sum + i;
			// 대입 연산자 : "="와 같이 사용 (+=, -=, *=, /=, %= 등)
		}
		System.out.println("1 ~ 10의 합계: " + sum);
		
		
		// 증감 연산자 : ++(1증가), --(1감소) => 단항연산자
		// ++a : 1증가 후 사용, a에 저장된 값을 1 증가시키고 사용
		// a++ : 사용 후 1증가, a변수에 저장된 값을 사용(연산)하고 ";"을 만나서 문장이 종료될 때 1 증가
		int a = 1, b, c;
		b = a++;
		c = ++a;
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		
		
		int d = 1, e;
		e = ++d + ++d + ++d + ++d; // 5 + 4 + 3 + 2
		System.out.println("d = " + d +", e = "+ e);
		
		
	}
}
