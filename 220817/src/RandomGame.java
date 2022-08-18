import java.util.Random;
import java.util.Scanner;

public class RandomGame {

	public static void main(String[] args) {
		
		// 가위 1, 바위 2, 보 3
		Random random = new Random();
		int cpu = random.nextInt(3) + 1;
		//System.out.println("cpu: " + cpu);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("가위(1), 바위(2), 보(3): ");
		int user = scanner.nextInt();
		
		// 이기는 경우 1,2/2,3/3,1
		// 지는 경우 1,3/2,1/3,2
		// 비기기는 경우 1,1/2,2/3,3
		if ((cpu == 1 && user == 2) || (cpu == 2 && user == 3) || (cpu == 3 && user == 1)) {
			System.out.println("이겼습니다!");
		} else if ((cpu == 1 && user == 3) || (cpu == 2 && user == 1) || (cpu == 3 && user == 2)) {
			System.out.println("졌습니다.");
		} else {
			System.out.println("비겼습니다.");
		}
		
//		if (cpu == user) {
//			System.out.println("비겼습니다.");
//		} else if ((cpu == 1 && user == 2) || (cpu == 2 && user == 3) || (cpu == 3 && user == 1)) {
//			// 논리곱이 논리합보다 먼저이므로 () 사용하지 않아도 됨
//			System.out.println("이겼습니다!");
//		} else {
//			System.out.println("졌습니다.");
//		}
		
		System.out.println("cpu: " + cpu);
	}
}
