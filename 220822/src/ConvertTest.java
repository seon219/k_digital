import java.util.Arrays;
import java.util.Scanner;

public class ConvertTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("2진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int num = dec;
		
		int[] hex = new int[8]; // 결과를 기억할 배열 선언, 0으로 자동초기화
		int index = 0; // 배열의 인덱스로 사용할 변수
		
		// 입력되는 10진수의 크기에 따라 반복횟수가 달라지므로 무한루프 처리
		while (true) {
			int n = dec / 2; // 몫
			int r = dec % 2; // 나머지
			
			hex[index++] = r; // 2진수 배열에 나머지 넣어주기
			// dec에 저장된 10진수를 2로 나눈 몫이 0이 되면 무한루프 탈출
			if (n == 0) {
				break;
			}
			// 이전 작업의 몫이 다음 작업의 dec가 된다.
			dec = n;
		}
		
		System.out.print(num + "를(을) 2진수로 변환하면 ");
		for (int i = hex.length-1; i >= 0; i--) {
			System.out.print(hex[i]);
			
		}
		System.out.println("입니다");
		//System.out.println(Arrays.toString(hex));

		System.out.print(num + "를(을) 2진수로 변환하면 ");
		for (int i = index-1; i >= 0; i--) {
			System.out.print(hex[i]);
			
		}
		System.out.println("입니다");
		
	}

}
