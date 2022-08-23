import java.util.Scanner;

public class WeekDayTest {

	public static void main(String[] args) {
		// 요일을 계산할 년, 월, 일을 입력받는다
		Scanner scanner = new Scanner(System.in);
		System.out.print("요일을 계산할 년, 월, 일을 입력하세요: ");
		int year = scanner.nextInt();
		int month = scanner.nextInt();
		int day = scanner.nextInt();

		// 서기 1년 1월 1일부터 요일을 계산하기 위해 입력한 날짜까지 지난 날짜 수를 계산
		// 계산된 날짜를 7로 나눈 나머지가 0이면 일요일, 1이면 월요일, ... , 6이면 토요일
		// 서기 1년 1월 1일부터 입력한 날짜의 전년도 12월 31일까지 지난 날짜를 계산
//		int sum = (year - 1) * 365;
//		for (int i = 1; i < year; i++) {
//			if ((i % 4 == 0) && (i % 100 != 0) || (i % 400 == 0)) {
//				sum++;
//			} 
//		}

		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;


		// 전년도 12월 31까지 지난 날짜에 전달까지 지난 날짜를 더한다.
		// 1, 3, 5, 7, 8, 10, 12 => 31일
		// 4, 6, 9, 11 => 3일
		// 2 => 윤년이면 29일, 평년이면 28일

/*		for (int i = 1; i < month; i++) {
			switch(month){
			case 2:
				sum += (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
				break;
			case 4: case 6: case 9: case 11:
				sum += 30;
				break;
			//case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			default:
				sum += 31;
				break;
		}
		*/
		
		// 각 달의 마지막 날짜를 기억하는 배열을 선언
		int[] a = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 2월의 마지막 날짜 확정
		a[1] = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 29 : 28;
		for (int i = 1; i < month; i++) {
			sum += a[i - 1];
		}
		
		
		// 전달까지 지난 날짜에 1을 더한다.
		sum += day;
		
		System.out.println(sum);
		System.out.println(sum % 7);
		
		
		// 요일 출력
		switch(sum % 7) {
		case 0: System.out.println("일요일"); break;
		case 1: System.out.println("월요일"); break;
		case 2: System.out.println("화요일"); break;
		case 3: System.out.println("수요일"); break;
		case 4: System.out.println("목요일"); break;
		case 5: System.out.println("금요일"); break;
		case 6: System.out.println("토요일"); break;
		}
		
		String[] week = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		System.out.println(week[sum % 7]);
		
		
	}

}
