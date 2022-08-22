import java.util.Scanner;

public class EuclidTest2 { // 정보처리기사 실기 2010년 1회 1.알고리즘

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 2개를 입력하세요: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int r = 1;

		int high, low;
				
		if (a > b) {
			high = a;
			low = b;
		} else {
			high = b;
			low = a;
		} 
		
		while (r > 0) {
			
			r = high % low;

			high = low;
			low = r;

		}
		System.out.println("최대공약수: " + low + ", 최소공배수: " + a * b / low);
	}

}
