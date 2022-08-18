import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {

		// Math.random() : 0이상이고 1미만인 무작위 수 발생
		System.out.println(Math.random()); // 0 ~ 1 사이의 실수
		System.out.println(Math.random() * 6); // 0 ~ 5 사이의 실수
		System.out.println((int) (Math.random() * 6)); // 0 ~ 5 사이의 정수
		System.out.println((int) (Math.random() * 6) + 1); // 1 ~ 6 사이의 정수

		// Random 클래스
		Random random = new Random();
		System.out.println(random.nextDouble()); // 0 ~ 1 사이의 실수
		System.out.println(random.nextInt()); // 무작위 양의 정수, 음의 정수
		System.out.println(random.nextInt(45)); // 0~44 사이의 난수
		System.out.println(random.nextInt(45) + 1); // 1~45 사이의 난수

	}

}
