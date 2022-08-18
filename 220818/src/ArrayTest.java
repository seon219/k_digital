import java.util.Arrays;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		// 배열 : 같은 이름으로 여러개의 기억장소를 만드는 것. 기억장소 구분은 인덱스(첨자) 이용
		// 배열은 삽입/삭제보다 그를 위한 데이터 옮기기에 시간이 더 오래걸리기 때문에 데이터의 변화가 거의 없을 때 사용하기 좋음
		// 반복문과 같이 사용
		
		// 배열 선언
		// 자료형[] 배열이름 = new 자료형[첨자] // 첨자로 지정한 크기만큼 배열을 만듬
		// 자료형 배열이름[] = new 자료형[첨자]
		
		// 자바는 변수는 초기화 해야 하지만, 배열은 자동(기본) 초기화
		// 숫자는 0, 문자는 공백, 논리값(boolean)은 거짓(false), 기본 자료형을 제외한 나머지(클래스로 만든 객체(string))는 null로 초기화
		int[] data = new int[5]; // 배열만 만듬
		System.out.println(Arrays.toString(data)); // 배열 전체를 보여줌
		
		// 배열을 선언하고 초기치로 초기화
		// 자료형[] 배열이름 = {초기치}; // 초기치로 지정된 데이터의 개수만큼 배열을 선언하고 초기화
		String name[] = {"홍길동", "임꺽정", "장길산", "일지매", "손오공"}; // 배열을 만들고 그 안에 초기값 설정
		System.out.println(Arrays.toString(name));
		
		System.out.println(name[0]); // name 인덱스의 0번째 데이터 출력
		System.out.println(name[1]); 
		System.out.println(name[2]); 
		System.out.println(name[3]);
		System.out.println("==========================================");
		
		
		for (int i = 0; i < 4; i++) {
			System.out.println("name[" + i + "] " + name[i]);
		}
		System.out.println("==========================================");

		
		// 배열이름.length : 배열의 크기를 얻어옴
		System.out.println("배열의 크기: " + name.length);
		
		for (int i = 0; i < name.length; i++) {
			System.out.println("name[" + i + "] " + name[i]);
		}
		System.out.println("==========================================");

		
		// 향상된 for : 배열 전체를 대상으로 작업할 경우 사용하면 편리
		// for (배열의자료형 변수이름 : 배열이름) {
		//		반복할 문장;
		// }
		
		// name 배열 0번째 인덱스에 저장된 데이터가 str 변수에 저장된 후 반복을 시작
		// name 배열의 마지막 인덱스에 저장된 str 변수에 저장한 후 처리하면 반복이 종료
		for(String str : name) { 
			System.out.println(str);
		}
		
	}

}
