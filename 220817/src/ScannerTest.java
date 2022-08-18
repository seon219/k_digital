import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		// 변수(variable) : 프로그램에서 처리할 데이터(상수)를 저장(기억)하는 저장(기억)장소
		// 변수 이름 : 영문자, 숫자, 특수문자(_)만 사용하여 만들 수 있고, 첫 글자는 반드시 문자로 시작
		// 자바에서 변수 선언 후 사용하기 전 초기화하기
		// 예약어 : 변수 이름으로 사용하면 안됨(print)
		
		// 자료형 + 변수이름; => 변수만 선언, 변수에 쓰레기값(무슨 값이 들어있는지 알 수 없음)
		// 자료형 + 변수이름 = 초기치 => 변수를 선엉하고 초기치로 초기화
		
		// "=" : 오른쪽의 데이터를 왼쪽의 기억장소에 대입(할당, 배정) 시키는 의미
		// "=" : 대입문, 할당문, 배정문,  "==" : 같음표시
		
		// int num = 0;
		int num;
		num = 100;
		System.out.println(num);
		
		
		// 객체만들기 : 클래스이름 + 객체(클래스로 만든 변수)이름 = new + 생성자(클래스 이름과 같음)()
		// 				(설계도)	 (제품)								  (옵션)
		
		// 키보드로 입력받는 스캐너
		Scanner scanner = new Scanner(System.in); 
		
		// 키보드로 입력받은 데이터를 변수에 저장
		System.out.print("주소: ");
		
		// 클래스(기본 자료형x)
		/////// 문자열 데이터 .next() : 한 단어 입력, .nextLine() : 한 줄 입력
		// 스캐너를 키보드로 입력받는 경우 바로 변수에 저장되지 않고, 키보드 버퍼라는 임시 기억장소에 저장된 후, 읽어들이는 메소드가 실행될 때 변수에 저장
		// nextLine()은 키보드 버퍼가 비어있으면 입력을 기다리며 대기하지만, 키보드 버퍼가 비어있지 않으면 버처의 내용을 끝까지 읽어들임
		String addr = scanner.nextLine();
		System.out.print("이름: ");
		String name = scanner.nextLine();
		
		System.out.println(name + "님은 " + addr+ "에 삽니다.");
	}

}
