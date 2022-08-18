import java.util.Scanner;

public class LeapYearTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("윤년, 평년을 판단할 년도를 입력하세요: ");
		int year = scanner.nextInt();

//		// 윤년, 평년 판별식
//		// 년도가 4로 나눠 떨어지고(&&), 100으로 나눠 떨어지지 않거나(||) 400으로 나눠 떨어지면 윤년
//
//		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
//			System.out.println(year + "년은 윤년입니다.");
//		} else {
//			System.out.println(year + "년은 평년입니다.");
//		}
//		// true, false로 계산
//		// true && false = false
//		// true || false = true
//
//		
//		// 삼항 연산자(?:)
//		// 조건식을 비교한 후 참/거짓일 떄 실행할 문장이 각각 한 문장일 때
//		// 형식 : 조건식 ? 참일 때 실행할 문장 : 거짓일 때 실행할 문장
//		System.out.println(year + "년은 " + (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "윤" : "평") + "년입니다. -삼항");
//		System.out.printf("%d년은 %s년입니다. -printf \n", year, year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "윤" : "평"); // %s 문자열로 ""사용
//		System.out.printf("%d년은 %c년입니다. -printf \n", year, year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? '윤' : '평'); // %c 문자로 ''사용
		
		
		
		// 프로그램에서 여러변 사용되는 값은 코드 수정시 원활하게 바꾸기 위해 변수로 저장해서 사용
		// true, false를 구별할 수 있는 boolean 사용
		// 논리값을 기억하는 변수나 return 타입이 논리값인 메소드의 이름은 is로 시작
		boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		
		
		if (isLeapYear) {
			System.out.println(year + "년은 윤년입니다. 1");
		} else {
			System.out.println(year + "년은 평년입니다. 1");
		}
		
		
		System.out.println(year + "년은 " + (isLeapYear ? "윤" : "평") + "년입니다. 2");
		System.out.printf("%d년은 %s년입니다. 3 \n", year, isLeapYear ? "윤" : "평"); 
		System.out.printf("%d년은 %c년입니다. 3 \n", year, isLeapYear ? '윤' : '평'); 
		
	}

}
