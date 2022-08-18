import java.util.Random;

public class DiceTest2 {

	public static void main(String[] args) {

		// 주사위를 10번 굴려서 발생된 눈의 개수 세기
		Random random = new Random();
		// int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0;
		// 주사위 눈의 개수를 기억할 배열 선언만 => 0으로 자동 초기화
		// count[0] => 1의 개수, count[1] => 2의 개수,...
		int count[] = new int[6];

		for (int i = 0; i < 10; i++) {

			// 주사위 눈을 무작위로 발생
			int dice = random.nextInt(6) + 1;

			// 무작위로 발생된 주사위 눈의 개수 세기
//			switch (dice) {
//			case 1:
//				count[0]++; break;
//			case 2:
//				count[1]++; break;
//			case 3:
//				count[2]++; break;
//			case 4:
//				count[3]++; break;
//			case 5:
//				count[4]++; break;
//			case 6:
//				count[5]++;
//			}
			count[dice - 1]++;
			
			System.out.print(dice + ", ");

		}

		// 주사위 눈 개수 출력
		System.out.print("\n");
//		System.out.println("1의개수: " + count[0]);
//		System.out.println("2의개수: " + count[1]);
//		System.out.println("3의개수: " + count[2]);
//		System.out.println("4의개수: " + count[3]);
//		System.out.println("5의개수: " + count[4]);
//		System.out.println("6의개수: " + count[5]);
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(i+1 + "의개수: " + count[i]);
		}
	}
}
