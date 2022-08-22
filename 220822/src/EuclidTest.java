import java.util.Scanner;

public class EuclidTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 2개를 입력하세요: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		// 입력받은 숫자 2개를 큰 수, 작은 수로 판단
		int big, small;
		
		if (a > b) {
			big = a;
			small = b;
		} else {
			big = b;
			small = a;
		} //System.out.println("큰 수: " + big + ", 작은 수: " + small);
		
		while (true) {
			
			// 큰수를 작은수로 나눈 나머지 계산
			int r = big % small;
			// 큰수를 작은수로 나눠 떨어지면 무한루프 탈출
			if (r == 0) {
				break;
			}
			// 큰수를 작은수로 나눠 떨어지면 큰수를 기억하던 기억장소에는 작은수를,
			// 작은수를 기억하던 기억장소에는 나머지를 넣어줌
			big = small;
			small = r;

		}
		System.out.println("최대공약수: " + small + ", 최소공배수: " + a * b / small);
	}

}
