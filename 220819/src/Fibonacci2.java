import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("피보나치 수열의 합계를 계산할 항수를 입력하세요: ");
		int n = scanner.nextInt();
		
		// 입력받은 피보나치 수열의 합계를 계산할 항의 개수만큼 배열을 만든다
		int fibo[] = new int[n];
		//System.out.println(Arrays.toString(fibo)); // 자동초기화 확인
		//System.out.println("배열의 크기: " + fibo.length); // 배열크기 확인
		
		// 배열의 1번째, 2번째 요소를 각각 1로 초기화
		fibo[0] = 1; // n-2번째
		fibo[1] = 1; // n-1번째
		int y = 2;
		
		// 피보나치 수열의 각 항 값으로 배열을 채우고 피보나치 수열의 합계를 계산
		for (int k = 3; k <= n; k++) {
			fibo[k-1] = fibo[k-3] + fibo[k-2];
			y += fibo[k-1];
			
		}
		System.out.println(Arrays.toString(fibo));
		System.out.println("피보나치 수열의 " + n + "번째 항까지의 합계: " + y);
		System.out.printf("피보나치 수열의 %d번째 항까지의 합계: %d = ", n, y);
		
		
//		for (int i = 0; i < fibo.length - 1; i++) { // 마지막 인덱스 값 빼고 돌린 후
//			System.out.print(fibo[i] + " + ");
//		}
//		System.out.print(fibo[fibo.length - 1]); // 마지막 값 넣어주기
		
		
		for (int i = 0; i < fibo.length; i++) {
			if (i > 0) {
				System.out.print(" + "); // + 먼저 찍어주기
			}
			System.out.print(fibo[i]);
		}
		System.out.println();
		
		
	}
		
}
