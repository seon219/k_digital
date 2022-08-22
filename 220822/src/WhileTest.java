
public class WhileTest {

	public static void main(String[] args) {
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1 ~ 10의 합계 : "  + sum);

		
//		while (조건식) {
//			조건식의 결과가 참인 동안 반복할 문장;
//		}
		sum = 0;
		int i = 1;
		while (i <= 10) {
			//sum += i;
			//i++;
			sum += i++;
		}
		System.out.println("1 ~ 10의 합계 : "  + sum);
		
		
//		반복으로 최초 진입시 조건이 거짓이더라도 {}을 한 번은 실행 -> while은 조건이 거짓이면 종료
//		do {
//			조건식의 결과가 참이 동안 반복할 문장;
//		} while (조건식);
		sum = 0;
		i = 1;
		do {
			sum += i;
		} while (i <= 10);
		System.out.println("1 ~ 10의 합계 : "  + sum);
		
	}

}
