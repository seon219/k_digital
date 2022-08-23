import java.util.Scanner;

public class SoinsooTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("소인수분해할 숫자를 입력하세요: ");
			int n = scanner.nextInt();

			if (n < 2) {
				break;
			}

			// 소인수분해
			int s[] = new int[20]; // 전 값이 남아있을 수 있으므로 실행시마다 초기화
			int num = n;
			int c = 0; // s 배열의 인덱스, 소인수의 개수

			while (true) {
				int k = 2; // 2부터 나누기

				while (true) {
					int r = n % k;

					if (r == 0) { // 소인수 분해가 되었는지
						break;
					}

					// 소인수 분해가 되지 않았다면 k를 1증가 후 다시 소인수분해
					k++;
				}

				// 소인수 분해가 되었으면 s배열에 넣어줌
				s[c++] = k;
				// 다음 소인수를 얻기 위해 n에 n을 k로 나눈 몫을 넣어준다.
				n /=  k ;

				if (n == 1) {
					break;
				}
			}

			// n이 소수이면 소수라고 출력하고, 소수가 아니면 분해된 소인수를 출력
			// 소인수의 개수(c)가 1개라면 자기 자신으로 나눠 떨어진 것을 의미하므로 소수
			if (c == 1) { // n이 소수인가?
				System.out.println(num + "은(는) 소수입니다.");
			} else {
				// 소인수를 출력
				System.out.print(num + " = ");
				for (int y = 0; y < c-1; y++) {
					System.out.print(s[y] + " * ");
				}
				System.out.println(s[c-1]);
			}
			
			
		}
		System.out.println("프로그램 종료");
	}

}
