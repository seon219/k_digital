public class PerfectNumber2 {

	public static void main(String[] args) {

		int lm = 0; // 완전수의 개수를 기억할 변수

		// 반복문이 중첩될 경우 제어 변수 이름은 다른 이름 사용
		// 변수는 변수가 선언된 {}안에서만 유효, {}벗어나면 메모리에서 소멸
		for (int n = 4; n <= 10000; n++) { // 완전수인지 판단할 수
			
			int sum = 0; // 숫자가 바뀔 때마다 초기화
			int k = n / 2;

			for (int j = 1; j <= k; j++) {
				if (n % j == 0) {
					sum += j;
				}

			}
			if (sum == n) {
				lm++;
				System.out.printf("%d번째 완전수 => %4d \n", lm, sum);
			}

		}
		System.out.printf("4 ~ 10000 사이의 완전수는 %d개 입니다.", lm);

	}
}
