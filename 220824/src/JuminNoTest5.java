import java.util.Scanner;

public class JuminNoTest5 {

	public static void main(String[] args) {

		// 주민번호를 입력받아 유효성 검사하기3
		// 인덱스를 8로 나눈 나머지에 +2하면 인덱스
		// 8304221185600
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민등록번호를 '-'없이 입력하세요: ");
		String str = scanner.nextLine().trim();
		
		//String u = "234567892345";
		int sum = 0;
		
		
		for (int i = 0; i < str.length()-1; i++) {
			
			//sum = Integer.parseInt(str.charAt(i) + "") * Integer.parseInt(u.charAt(i) + "");
			//sum = Integer.parseInt(str.charAt(i) + "") * (i < 8 ? i + 2 : i - 6);
			sum = Integer.parseInt(str.charAt(i) + "") * (i % 8 + 2);
			
			//sum += (str.charAt(i) - '0') * (u.charAt(i) - 48);
		}
		//System.out.println(sum); //143
		
		// 주민번보의 각 자리 숫자와 가중치를 곱한 합계를 11로 나눈 나머지를 11에서 뺀다.
		// 뺀 결과가 10 이상이면 10의 자리는 버리고 1의 자리만 취한다.
		
		int n = (11 - sum % 11) % 10;
		//System.out.println(n);
		
//		if (n == (str.charAt(12) - '0')) {
//			System.out.println("유효한 주민등록번호입니다.");
//		} else {
//			System.out.println("유효하지 않은 주민등록번호입니다.");
//		}
	
		System.out.println(n == (str.charAt(12) - '0') ? "정상" : "오류");
		
	}

}
