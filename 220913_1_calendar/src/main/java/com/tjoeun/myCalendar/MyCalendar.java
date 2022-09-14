package com.tjoeun.myCalendar;


// 달력 작업에 필요한 메소드를 모아놓은 클래스
public class MyCalendar {

		// 연도를 인수로 넘겨받아 윤년, 평년을 판단해 윤년이면 true, 평년이면 false를 리턴하는 메소드
		// 논리값을 기억하는 변수나 논리값을 리턴하는 메소드의 이름은 "is"로 시작하는 것이 관행
		
		// 데이터를 기억하는 변수는 일반적으로 private을 사용하고, 처리하는 메서드는 일반적으로 public 사용
		// static은 static에서만 접근 가능
		
		public static boolean isLeapYear(int year) {
			// return값이 boolean이기 때문에 true, false 출력
			return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		}
		
		
		// 년, 월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
		public static int lastDay(int year, int month) {
			int[] m = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			m[1] = isLeapYear(year) ? 29 : 28;
			return m[month - 1];
		}
		
		
		// 년, 월, 일을 인수로 넘겨받아 1년 1월 1일부터 지날 날짜를 계산해서 리턴하는 메소드
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
		
		
		// 년, 월, 일을 인수로 넘겨받아 요일을 숫자로 계산해서 리턴하는 메소드
		// 일(0), 월(1), 화(2), 수(3), 목(4), 금(5), 토(6)
		public static int weekDay(int year, int month, int day) {

			return  totalDay(year, month, day) % 7;
		}
	
	
	
}
