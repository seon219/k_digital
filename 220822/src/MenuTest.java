import java.util.Scanner;

public class MenuTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int menu;

		while (true) { // 무한루프, 무한루프를 탈출할 수 있는 조건과 break를 이용해 탈출할 수 있어야 함
			do {
				System.out.println("============================================");
				System.out.println(" 1.입력  2.목록보기  3.수정  4.삭제  5.종료");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하세요: ");
				menu = scanner.nextInt();
			} while (menu < 1 || menu > 5);

			// 여기까지 왔다면 menu에 1 ~ 5 사이의 정수가 입력되었다는 것을 의미
			switch (menu) {
			case 1:
				System.out.println("입력");
				break;
			case 2:
				System.out.println("목록보기");
				break;
			case 3:
				System.out.println("수정");
				break;
			case 4:
				System.out.println("삭제");
				break;
/*
			case 5:
				System.out.println("프로그램을 종료합니다."); // 프로그램 강제종료 System.exit(0);
				break;
*/
			}
			
			if (menu == 5) {
				break;
			}
		}System.out.println("프로그램을 종료합니다.");
	}
}
