import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		
		// 관계(비교)연산자 : 연산 결과는 무조건 참(true), 거짓(false) (<, <=, >, >=, ==, !=)
		// 논리 연산자 : 연산 결과는 무조건 참(true), 거짓(false) (&&(and), ||(or), |(not))
		// && : 논리곱(and), 두 조건이 모두 참일 경우에만 참, ~이고, ~이면서, ~ 중에서
		// || : 논리합(or) , 두 조건 중 하나 이상 참일 경우 참, ~또는, ~이거나
		// |  :	논리 부정(not), 참은 거짓으로, 거짓은 참으로
		
		
		// 연산자 우선순위
		// ( )
		// 단항 연산자 : ++, --
		// 이항 연산자(산술 연산자(*, /, %  =>  +, -), 관계 연산자(>, >=, <, <=  =>  ==, !=), 논리 연산자(&&  =>  ||)
		// 삼항 연산자 : ?:
		// 대입 연산자 : "="와 함께 사용
		
		
//		if (조건식) {
//			조건식이 참일 경우 실행할 문장;
//		} else {
//			조건식이 거짓일 경우 실행할 문장;
//		}
//		조건식이 거짓일 경우 실행할 문장이 없으면 else이하를 생략
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		int age = scanner.nextInt();
		
		if (age >= 18) {
			System.out.println("투표권이 있습니다.");
		} else {
			System.out.println("투표권이 없습니다.");
		}
				
	}
}
