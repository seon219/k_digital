import java.util.Scanner;

public class Sosoo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("소인수분해할 숫자를 입력하세요: ");
		int num = scanner.nextInt();
		int i;
		
		// 모든 수는 1로 나눠 떨어지기 때문에 2부터 떨어질 떄까지 나눠본다.
		for(i = 2; i <= num; i++) {
			if (num % i == 0) {
			// 나눠서 떨어지면 소수인가 판단하기 위해 반복 탈출
			break;
			}
		}
		
		// 소수인지 판단
		if (num == i) {
			System.out.println(num + "은(는) 소수입니다.");
		} else {
			System.out.println(num + "은(는) 소수가 아닙니다.");			
		}
		
		//조건식 ? 참일때 실행할 문장 : 거짓일때 실행할 문장;
		System.out.println(num + "은(는) 소수" + (num == i ? "입니다." : "가 아닙니다."));			
		

	}

}
