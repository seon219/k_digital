import java.util.Arrays;
import java.util.Random;

public class CardShuffle {

	public static void main(String[] args) {
		
//		// 두 기억장소에 저장된 값 교환하기
//		int a = 3, b = 4;
//		System.out.println("a = " + a + "b = " + b);
//
//		int c = a;
//		a = b;
//		b = c;		
//		
//		System.out.println("a = " + a + "b = " + b);
		
		
		// cards라는 int형 배열을 만들고 0 ~ 51로 초기화
		int card[] = new int[52];
		for (int i = 0; i < card.length; i++) {
			card[i] = i;
			//System.out.println(card[i]); // for문 안에서 확인할 때
		}
		// System.out.println(Arrays.toString(card)); // for문 밖에서 확인할 때
		
		
		// 카드 출력에 사용할 숫자와 무늬를 기억하는 배열을 만든다
		String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] sym = {"◆", "♠", "♣", "♥"}; // string, char 둘 다 가능
		
		// 섞기 전 상태 출력
		for (int i = 0; i < card.length; i++) {
			//System.out.printf("%2d  ", card[i]); 
			//System.out.printf("%2d  ", card[i] % 13);
			//System.out.printf("%2s  ", num[card[i] % 13]); // num이 string이므로 %s로 바꿔줘야 함 // 숫자만
			//System.out.printf("%s  ", sym[card[i] / 13]); // 무늬만
			System.out.printf("%s%s  ", sym[card[i] / 13], num[card[i] % 13]);
			
			// 숫자 13개 출력하고 줄 바꾸기
			if ((i + 1) % 13 == 0) {
			System.out.println();
			}
		}
		System.out.println("============================================ 섞기전");

		
		// 섞기
		// card[0]와 card[1] ~ [51] 사이의 랜덤한 위치를 선택해서 값을 교환
		Random random = new Random();
		for (int i = 0; i <= 1000000; i++) {
			int rcard = random.nextInt(51) + 1;
			
			int temp = card[0];
			card[0] = card[rcard];
			card[rcard] = temp;

		}
		for (int i = 0; i < card.length; i++) {
			System.out.printf("%s%s  ", sym[card[i] / 13], num[card[i] % 13]);
			
			// 숫자 13개 출력하고 줄 바꾸기
			if ((i + 1) % 13 == 0) {
			System.out.println();
			}
		}
		System.out.println("============================================ 섞은후");
			
			
			
			
			
				
		
		
	}
}
