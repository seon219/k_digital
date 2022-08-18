import java.util.Scanner;

public class ScannerTest2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = scanner.nextInt();
		// enter 값도 키보드 버퍼 값으로 들어감
		
		// nextInt(), nextDouble() 등 문자열이 아닌 데이터를 읽어들이는 메소드는 메소드 자신이 읽어들일 데이터만 읽음 => 마지막 엔터키는 읽어들이지 않음
		// 따라서 키보드 버퍼를 비우기 위한 코드 필요
		scanner.nextLine();
		
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		
		System.out.println(name + "님은 " + age + "살 입니다.");
		System.out.println(name + "님은 내년에 " + (age + 1) + "살 입니다.");
		
		
		
		
		
	}
}
