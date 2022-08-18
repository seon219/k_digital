import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("3과목 점수를 입력하세요: ");
		int java = scanner.nextInt();
		int jsp = scanner.nextInt();
		int spring = scanner.nextInt();

		int total = java + jsp + spring;
		double avg = (double) total / 3;

		System.out.println("총점: " + total + "점, 평균: " + avg);

		//key에는 정수를 기억하는 변수, 연산 결과가 정수인 수식 사용 (JDK 1.7부터 문자열(char, string) 사용 가능)
		//switch (key) {
		//	 case value: //":" 주의
		//		key와 value가 일치하면 실행할 문장;
		//		...;
		//		[break] // 생략 가능
		//	...
		//	[default: // 기타 등등 케이스
		//		key와 일치하는 value가 없으면 실행할 문장;
		//		...;
		//		(break;)
		//}

//		switch((int) avg / 10) {
//			case 10: //case 9:
//				System.out.println("A");
//				break; // 제어문(if 제외)의 {}블록을 탈출
//			case 9:
//				System.out.println("A");
//				break;
//			case 8:
//				System.out.println("B");
//				break;
//			case 7:
//				System.out.println("C");
//				break;
//			case 6:
//				System.out.println("D");
//				break;
//			//case 5: case 4: case 3: case 2: case 1: case 0:
//			default:
//				System.out.println("F");	
//		}

		// 평균이 100점이면 참잘했어요 A
		switch ((int) avg / 10) {
		case 10:
			System.out.println("참잘했어요.");
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		// case 5: case 4: case 3: case 2: case 1: case 0:
		default:
			System.out.println("F");

		}

	}
}
