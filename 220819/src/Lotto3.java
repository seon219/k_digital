import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto3 {

	public static void main(String[] args) {

		// 추첨기를 만든다
		int lotto[] = new int[45];

		// 추첨기에 공을 넣는다.
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}
		show(lotto);

		Scanner scanner = new Scanner(System.in);
		System.out.print("금액을 입력하세요: ");
		int n = scanner.nextInt();


		// 자동 로또 번호 출력
		for (int k = 0; k < n / 1000; k++) {

			System.out.print("번호: ");
			for (int i = 0; i < 6; i++) {
				Random random = new Random();
				for (int a = 0; a < 1000000; a++) {
					int r = random.nextInt(44) + 1;
					int temp = lotto[0];
					lotto[0] = lotto[r];
					lotto[r] = temp;
				}
				System.out.printf("%02d ", lotto[i]);
			}
			System.out.println();
		}
		System.out.println("====================================");
		// show(lotto);

	}

	private static void show(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%02d ", lotto[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n====================================");
	}
}
