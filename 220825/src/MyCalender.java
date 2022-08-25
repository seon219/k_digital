// 달력 작업에 사용할 메소드를 모아놓은 클래스
public class MyCalender {

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	
	// 마지막 날짜를 리턴하는 메소드
	public static int lastDay(int year, int month) {
		int[] m = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month - 1];
	}
	
	
	// 1년 1월 1일부터 지날 날짜를 계산해서 리턴하는 메소드
	public static int totalDay(int year, int month, int day) {
		// 전 년도까지 날짜
		int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		// 전달까지 날짜
		for (int i = 1; i < month; i++) {
			sum += lastDay(year, i);
		}
		// 오늘까지 날짜
		return sum + day;
	}
	
	
	//  요일을 숫자로 계산해서 리턴하는 메소드
	// 일(0), 월(1), 화(2), 수(3), 목(4), 금(5), 토(6)
	public static int weekDay(int year, int month, int day) {

		return  totalDay(year, month, day) % 7;
	}
}
