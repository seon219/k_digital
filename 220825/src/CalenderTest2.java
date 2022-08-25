import java.util.Date;
import java.util.Scanner;

// 실제 달력을 출력할 클래스
public class CalenderTest2 {

	public static void main(String[] args) {
		
		// 새로운 변수를 만들어 접근
//		MyCalender myCalender = new MyCalender();
//		System.out.println(myCalender.isLeapYear(2022));
		
		// static으로 만들었기 때문에 클래스 뒤에 .으로 접근 가능
//		System.out.println(MyCalender.isLeapYear(2022));
		
		
		Scanner scanner = new Scanner(System.in);
		int year = 0;
		int month = 0;
		
		
		System.out.print("(1) 이번달 달력보기, (2) 입력해서 달력보기 : ");
		int menu = scanner.nextInt();
		switch(menu) {
		case 1:
			Date date = new Date();
			year = date.getYear()+1900;
			month = date.getMonth()+1;
			break;
		case 2:
			System.out.print("달력을 출력할 년, 월을 입력하세요: ");
			year = scanner.nextInt();
			month = scanner.nextInt();
			
		}
		
		System.out.println("============================");
		System.out.printf("        %4d년 %2d월\n", year, month);
		System.out.println("============================");
		System.out.println(" 일  월  화  수  목  금  토 ");
		System.out.println("============================");
		
// 		전달 날짜 출력하기
		int week = MyCalender.weekDay(year, month, 1); // 달의 1일
		int start = 0;
		if (month == 1) {
			start = MyCalender.lastDay(year - 1, 12) - week; // 1월 
			
		} else {
			start = MyCalender.lastDay(year, month - 1) - week; // 2 ~ 12월 
		}
		for (int i = 1; i <= week; i++) {
				System.out.printf(" %2d ", ++start);
		}		
				
		
		
		// 1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력
		for(int i = 1; i <= MyCalender.lastDay(year, month); i++) {
			System.out.printf(" %2d ", i);
			// 출력한 날짜(i)가 토요일이면 줄을 바꾼다.
			// 출력한 날짜(i)가 달의 마지막날짜가 아니면 줄을 바꾼다.
			if (MyCalender.weekDay(year, month, i) == 6 && i != MyCalender.lastDay(year, month)) {
				System.out.println();
			}
		}
		
		
		// 다음달 날짜 출력하기
		if (month == 12) {
			week = MyCalender.weekDay(year + 1, 1, 1); // 12월
		} else {
			week = MyCalender.weekDay(year, month + 1, 1);
		}
		// 마지막 요일이 토요일이면 다음달 날짜 출력 안함
		if (week != 0) {
			start = 0;
			for (int i = week; i <= 6; i++) {
				System.out.printf(" %2d ", ++start);
			}
		}

		System.out.println("\n============================");
		
		
		
		
		
	}
}
