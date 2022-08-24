import java.util.Scanner;

public class JuminNoTest {

	public static void main(String[] args) {

		//int a = 2147483647; // int의 범위
		//long jumin = 8304221185600l; // long타입임을 알려주기 위해 숫자 뒤에 l(L) 붙여주기
		
		// 주민등록번호 13자리를 -없이 받아서 남/여 인지 판단
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요: ");
		String str = scanner.nextLine().trim();
		
		
		//System.out.println(str.charAt(6)); // 1
		//System.out.printf("%d \n", (int) str.charAt(6)); //49
		//숫자와 문자는 표현 방법이 다름
		//문자 '1'(0110001)과 숫자1(0000001)은 다른 데이터로 취급
		
		
		if (str.charAt(6) == '1' || str.charAt(6) == '3') {
			System.out.println("남자입니다.");
		} else {
			System.out.println("여자입니다.");
		}
		
		if ((int)str.charAt(6) - '0' == 1 || (int)str.charAt(6) - 48 == 3) {
			System.out.println("남자입니다.");
		} else {
			System.out.println("여자입니다.");
		}
		
		if ((int)str.charAt(6) % 2 == 1) {
			System.out.println("남자입니다.");
		} else {
			System.out.println("여자입니다.");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
