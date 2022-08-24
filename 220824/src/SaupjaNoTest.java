import java.util.Scanner;

public class SaupjaNoTest {

	public static void main(String[] args) {

		// 사업자등록번호를 입력받아 유효성 검사하기
		// 2208162517
		Scanner scanner = new Scanner(System.in);
		System.out.print("사업자등록번호를 입력하세요: ");
		String str = scanner.nextLine().trim();
		
		// 가중치
		String u = "137137135";
		int sum = 0;
		
		
		// 인덱스 0 ~ 7까지는 일의자리 숫자만 쓰고, 인덱스 8은 십의 자리와 1의 자리를 나누어 사용
		// 인덱스 0 ~ 8까지의 합계와 인덱스 9를 더한 값이 10의 배수이면 정상
		
		for (int i = 0; i < str.length()-1; i++) {
			
			//sum = Integer.parseInt(str.charAt(i) + "") * Integer.parseInt(u.charAt(i) + "") % 10;
			sum += (str.charAt(i) - '0') * (u.charAt(i) - 48) % 10;
		}
		sum += (str.charAt(8) - '0') * (u.charAt(8) - 48) / 10;
		//System.out.println(sum); // 인덱스 0 ~ 8 까지의 가중치
		
		sum += str.charAt(9) - 48;
//		if (sum % 10 == 0) {
//			System.out.println("정상");
//		} else {
//			System.out.println("오류");
//		}
		System.out.println(sum % 10 == 0 ? "정상" : "오류");
	}

}
