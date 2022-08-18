import java.util.Random;

public class DiceTest3 {

	public static void main(String[] args) {

		Random random = new Random();
		int count[] = new int[6];

		for (int i = 0; i < 10; i++) {

//			int dice = random.nextInt(6) + 1;
//			count[dice - 1]++;
//			System.out.print(dice + ", ");
			
			count[random.nextInt(6)]++;

		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(i+1 + "의개수: " + count[i]);
		}
	}
}
