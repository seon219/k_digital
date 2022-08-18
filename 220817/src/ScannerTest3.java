import java.util.Scanner;

public class ScannerTest3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 한 글자만 입력받고 싶을 때
		System.out.print("continue?(y/n) ");
		char confirm = scanner.nextLine().charAt(0); // 전체에서 0번째 인덱스에 있는 문자만 선택
		System.out.println(confirm);
		
	}

}
