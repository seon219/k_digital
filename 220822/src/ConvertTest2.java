import java.util.Arrays;
import java.util.Scanner;

public class ConvertTest2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("8진수로 변환할 10진수를 입력하세요: ");
		int dec = scanner.nextInt();
		int num = dec;
		
		int[] bin = new int[8]; // 결과를 기억할 배열 선언
		int index = 0; // 배열의 인덱스로 사용할 변수

		while (true) {
			int n = dec / 8; // 몫
			int r = dec % 8; // 나머지
			
			bin[index++] = r; // 나머지 넣어주기
			
			if (n == 0) {
				break;
			}
			// 이전 작업의 몫이 다음 작업의 dec가 된다.
			dec = n;
		}
		
		System.out.print(num + "를(을) 8진수로 변환하면 ");
		for (int i = bin.length-1; i >= 0; i--) {
			System.out.print(bin[i]);
			
		}
		System.out.println("입니다");
		//System.out.println(Arrays.toString(bin));

		System.out.print(num + "를(을) 8진수로 변환하면 ");
		for (int i = index-1; i >= 0; i--) {
			System.out.print(bin[i]);
			
		}
		System.out.println("입니다");
		
	}

}
