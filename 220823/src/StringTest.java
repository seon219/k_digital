
public class StringTest {

	public static void main(String[] args) {

//		 자바는 기본 자료형(boolean, byte, char, short, int, long, double)으로 만든 변수는
//		 일반 변수로 취급하고, 클래스로 만든 변수(객체)는 참조변수라고 함
//		 참조변수 : 데이터를 기억하는 변수가 아닌 데이터가 저장된 메모리의 주소를 기억하는 변수
		// 크기가 정해지지 않았기 때문에
		
		// 문자열 "AAA"가 처음 사용되므로 메모리 어딘가에 "AAA"를 만들고, 시작주소를 str1에 저장
		String str1 = "AAA";
		// 문자열 "AAA"가 이미 메모리에 생성되어있는 상태이므로 이미 생성되어있는 "AAA"주소를 str2에 저장
		String str2 = "AAA";
		
		if (str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");	
		}
		
		
		// new를 사용해서 만들면 메모리에 "AAA"의 존재여부와 관계없이 무주건 다시 만들어 시작주소를 str3에 저장
		String str3 = new String("AAA");
		
		if (str1 == str3) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");	
		}
		
		
//		결론 => 기본 자료형과 null을 제이한 클래스로 생성한 모든 객체는 "=="로 비교하지 않는다.
//		클래스로 생성한 객체는 equals() 메소드를 사용해서 비교
//		클래스로 생성한 객체를 "=="로 비교하면 객체에 저장된 내용을 비교하는 것이 아니고,
//		객체가 메모리에 생성된 주소를 비교한다.
		if (str1.equals(str3)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");	
		}
		
		
	}

}
