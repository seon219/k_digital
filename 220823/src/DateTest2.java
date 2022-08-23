import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest2 {

	public static void main(String[] args) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) a h:mm:ss.SSS");
		System.out.println(sdf.format(date));
		
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(sdf.format(date2));
		
		Date date3 = new Date("1983/04/22");
		System.out.println(sdf.format(date3));
		
		// Data 클래스 객체에 년도를 저장할 때는 1900을 빼서 넣어야 하고
		// 월을 저장할 때는 1을 빼서 넣어야 함
		Date date4 = new Date(2023 - 1900, 3 - 1, 27);
		System.out.println(sdf.format(date4));
		
		Date date5 = new Date(122, 7, 23, 14, 2);
		System.out.println(sdf.format(date5));
		
		Date date6 = new Date(122, 7, 23, 14, 2, 55);
		System.out.println(sdf.format(date6));
		
		System.out.println("==========================================");

		Scanner scanner = new Scanner(System.in);
		System.out.print("년, 월, 일을 입력하세요: ");
		int y = scanner.nextInt() - 1900;
		int m = scanner.nextInt() - 1;
		int d = scanner.nextInt();
		
		Date date7 = new Date(y, m, d);
		System.out.println(sdf.format(date7));
		
		date7.setYear(123);
		System.out.println(sdf.format(date7));
		
		// set 수정
		// get 가져옴
		
	}

}
