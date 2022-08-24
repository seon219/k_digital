import java.util.Arrays;
import java.util.Scanner;

public class StringMethod {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		String str = "    tjoeunit    ";
//		 length(): 문자열을 구성하는 문자의 개수를 얻어옴
		System.out.println("문자개수: " + str.length());
		
		
		str = "    tjoeunit    ";
//		 trim(): 문자열 앞, 뒤의 불필요한 공백을 제거
		System.out.println("공백을 제거한 문자개수: " + str.trim().length());
		
		
//		System.out.print("문자열 입력: ");
//		// 데이터 입력 단계에서 불필요한 공백을 제거하고 입력받으러면 trim()메소드 사용
//		String name = scanner.nextLine().trim();
		
		
		str = "tjoeunit";
//		 charAt(index): 문자에서 지정된 index번째 위치의 문자를 얻어온다.
//		 index는 0부터 시작
		System.out.println("6번째 문자: " + str.charAt(5));
		
		
//		// 키보드로 1문자만 입력받으려면 charAt() 메소드 사용
//		char ch = scanner.nextLine().charAt(0);
//		System.out.println(ch);
		
		
		str = "TjoeunIT";
//		toUpperCase() 메소드는 영문자를 무조건 대문자로 변환
//		toLowerCase() 메소드는 영문자를 무조건 소문자로 변환
		System.out.println("무조건 대문자로" + str.toUpperCase());
		System.out.println("무조건 소문자로" + str.toLowerCase());
		
		
		System.out.println("==========================================");

		
		str = "8304221185600";
//		 substring(a) : 문자열의 a번째 인덱스부터 문자열의 끝까지
//		 substring(a, b) : 문자열의 a번째 인덱스의 문자부터 b-1번째 인덱스의 문자까지
		System.out.println("주민등록번호 뒷자리: "+ str.substring(6));
		System.out.println("생년: "+ str.substring(0, 2));
		System.out.println("월: "+ str.substring(2, 4));
		System.out.println("일: "+ str.substring(4, 6));

		
		System.out.println("==========================================");
		
		
		str = "itTjoeunit";
//		 indexOf(): 문자열의 왼쪽부터 검색해서 인수로 지정한 문자열이 최초로 나타나는 인덱스 얻어오기
//		 lastIndexOf(): 문자열의 오른쪽부터 검색해서 인수로 지정한 문자열이 최초로 나타나는 인덱스 얻어오기
		System.out.println(str.indexOf("it"));
		System.out.println(str.lastIndexOf("it"));
		// 인수로 지정된 문자열이 없으면 -1 리턴
		// 실행결과가 0이상이면 인수로 지정된 문자열이 포함되었다는 의미로 사용가능
		System.out.println(str.indexOf("It"));
		System.out.println(str.lastIndexOf("IT"));
		
		
		System.out.println("==========================================");

		
		str = "itTjoeunit";
//		 contains(): 문자열에 인수로 지정한 문자열이 포함되어있으면 true, 없으면 false 리턴
		System.out.println(str.contains("it"));
		System.out.println(str.contains("It"));
		
		
		str ="abc 123 가나다";
//		 split("구분자"): 문자열을 구분자와 경게로 나눠서 배열로 리턴
		System.out.println(str.split(" ").length);
		System.out.println(str.split(" ")[0]);
		for (String s : str.split(" ")) {
			System.out.println(s);
		}

		
		str = "itTjoeunit";
//		replace(a, b): 문자열의 모든 a를 b로 치환
		System.out.println(str.replace("i", "아이"));
		
		
		System.out.println("==========================================");
		
		// -n개- 별로 바꾸기
		str = "123-4567-12345";
//		for (String s : str.split("-")) {
//			System.out.println(str.replace(str.split("-")[1], "*"));
//		}
		
		System.out.println("앞쪽 '-'의 index: " + str.indexOf('-'));
		System.out.println("뒤쪽 '-'의 index: " + str.lastIndexOf('-'));
		String code = str.substring(str.indexOf('-') + 1, str.lastIndexOf('-'));
		System.out.println(code.length());
		
		String newCode = "";
		newCode += str.substring(0, str.indexOf('-') + 1);
		System.out.println(newCode);
//		for (int i = 0; i < code.length(); i++) {
//			newCode += "*";
//		}
		
//		repeat(): 문자열을 인수로 지정한 개수만큼 반복
		newCode += "*".repeat(code.length());
		newCode += str.substring(str.lastIndexOf('-'));
		System.out.println(newCode);
		
		
		String[] newCode2 = str.split("-");
		System.out.println(Arrays.toString(newCode2));
		System.out.printf("%s-%s-%S", newCode2[0], "*".repeat(newCode2[1].length()), newCode2[2]);
		
		
		
		
		
	}

}