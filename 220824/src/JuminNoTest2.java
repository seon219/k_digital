import java.util.Date;
import java.util.Scanner;

public class JuminNoTest2 {

	public static void main(String[] args) {

		// 주민번호를 입력받아 컴퓨터 날짜에 따른 만 나이 구하기
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요: ");
		String str = scanner.nextLine().trim();
		
		// 주민번호 8304221185600
		//System.out.println("생년: "+ str.substring(0, 2) + 1900); //831900
		//System.out.println(str.charAt(0)); //8
		//System.out.println(str.charAt(1)); //3
		//int year = 1900 + (str.charAt(0) - '0') * 10 + (str.charAt(1) - 48);
		//int year = (str.charAt(0) - '0') * 10 + (str.charAt(1) - 48);
		
		
//		Integer.parseInt(): int의 래퍼클래스, 인수로 지정된 문자열을 정수로 변환
//		Double.parseDouble(): 인수로 지정된 문자열을 실수로 변환
//		Boolean.parseBoolean(): 인수로 지정된 문자열을 논리값으로 변환
		int year = Integer.parseInt(str.substring(0, 2));
		
		
/*		if (str.charAt(6) <= '2') {
			year += 1900;		
		} else {
			year += 2000;					
		}
		System.out.println("태어난 해: " + year);
*/		
		
		//year = (str.charAt(6) <= '2' ? 1900 : 2000); 
		year += (str.charAt(6) <= '2' ? 1900 : 2000); 
		System.out.println("태어난 해: " + year);
		
		Date date = new Date();
		System.out.println("올해: " + (date.getYear()+1900));
		System.out.println("만 나이: " + ((date.getYear()+1900)-year));

	}

}
