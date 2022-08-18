import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("완전수인지 판단할 숫자를 입력하세요: ");
		int num = scanner.nextInt();

		int sum = 0; // 자기 자신을 제외한 약수의 합계를 기억할 함수

		// 자기 자신을 제외한 약수는 숫자의 절반을 넘어가지 않음
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) { // 입력한 숫자의 약수 판단
				System.out.println(i);
				sum += i;

			}
		}
		if (sum == num) {
			System.out.println(sum + "은 완전수입니다.");
		} else {
			System.out.println(sum + "은 완전수가 아닙니다.");
			
		}

	}
}
