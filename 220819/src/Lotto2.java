import java.util.Random;

public class Lotto2 {

	public static void main(String[] args) {
		
		// 추첨기를 만든다
		int powerball[] = new int[69];
		
		
		// 추첨기에 공을 넣는다.
		// 흰공 1 ~ 69 => 5개
		// 빨간공 1 ~ 26 => 1개
		for (int i = 0; i < powerball.length; i++) {
			powerball[i] = i + 1;
		}
		show(powerball);
		
		
		// 섞는다.
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			int r = random.nextInt(68) + 1;
			int temp = powerball[0];
			powerball[0] = powerball[r];
			powerball[r] = temp;
		}
		show(powerball);
		
		// 1등 번호를 출력한다.
		System.out.print("흰공 번호: ");
		for (int i = 0; i < 5; i++) {
			System.out.printf("%02d ", powerball[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.print("빨간공 번호: " + (random.nextInt(25) + 1));
		
	}

	private static void show(int[] powerball) {
		for (int i = 0; i < powerball.length; i++) {
			System.out.printf("%02d ", powerball[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n ===================================");
	}
}
