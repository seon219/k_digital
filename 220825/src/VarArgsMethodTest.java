
public class VarArgsMethodTest {

	public static void main(String[] args) {
		
		// 같은(비슷한) 기능을 실행하는 메소드의 인수가 서로 다를 경우,
		// 많은 수의 메소드 오버로딩이 필요 (메서드를 매번 다시 만들어야 함)
		System.out.println("sum(1, 2) = " + sum(1, 2));
		System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
		System.out.println("sum(1, 2, 3, 4) = " + sum(1, 2, 3, 4));
		System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
		
		
		// 메소드의 인수를 배열로 구현하면 많은 수의 오버로딩이 필요 없지만, 
		// 인수를 배열로 선언하고 선언한 배열에 초기치를 지정해서 전달해야하는 번거로움이 있음
		System.out.println("sum(1, 2) = " + sum(new int[] {1, 2}));
		System.out.println("sum(1, 2, 3) = " + sum(new int[] {1, 2, 3}));
		System.out.println("sum(1, 2, 3, 4) = " + sum(new int[] {1, 2, 3, 4}));
		System.out.println("sum(1, 2, 3, 4, 5) = " + sum(new int[] {1, 2, 3, 4, 5}));
	
		
		// 위 두가지 방법의 단점을 해결하는 가장 좋은 방법은 가변인수를 만들어 사용하는 방법
		System.out.println("total(1, 2, 3, 4, 5) = " + total(1, 2, 3, 4, 5));
		System.out.println("total(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) = " + 
				total(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
	}


	// 메소드 오버로딩 : 같은 이름을 가지는 서로 다른 기능을 실행하는 메소드가 여러개 나올 수 있음
	// 메소드 이름이 같으면 인수의 개수로 메소드를 식별, 인수의 개수도 같으면 인수의 데이터 타입으로 메소드 식별
	private static int sum(int i, int j) {
		return i + j;
	}

	
	private static int sum(int i, int j, int k) {
		return i + j + k;
	}
	
	
	private static int sum(int i, int j, int k, int l) {
		return i + j + k + l;
	}
	
	
	private static int sum(int i, int j, int k, int l, int m) {
		return i + j + k + l + m;
	}

	
	// 위의 4개의 메소드는 인수를 모두 변수로 받고 있기 때문에 많은 수의 오버로딩 필요
	// 인수를 배열로 받으면 많은 수의 오버로딩이 필요 없음
	private static int sum(int[] data) {
		int total = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		return total;
	}
	
	
	// 가변 인수를 사용하는 메소드 => 가변 인수는 자료형 뒤에 "..."을 쓰고 뒤에 배열 이름을 입력
	// 매소드 이름을 sum이라고 하면 인수의 개수(data 1개), 데이터 타입(배열) 모두 같으므로 메소드를 사용할 수 없음
	// 가변인수는 인수 목록의 맨 마지막에 딱 1번만 사용가능
	private static int total(int ... data) {
		int total = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		return total;
	}
	
	
	
	
	
	
	
}
