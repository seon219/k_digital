public class ZigzagTest2 {

	public static void main(String[] args) { // 2차원 배열 ㄹ모양으로 숫자 채우기2

		int[][] a = new int [4][6];
		int n = 0;
		int start = 0; // 2차원 배열에서 숫자가 채워지기 시작하는 열의 인덱스
		int end = a[0].length - 1; // 2차원 배열에서 숫자가 채워지는 마지막 열의 인덱스
		int sw = 1; // start부터 end까지 증가치로 사용할 변수
		
		
		for (int i = 0; i < a.length; i++) {
			for (int j = start; j != end + sw; j+=sw) { 
				// i = 0이면 end = 5, sw = 1, j = 6
				// i = 1이면 end = 0, sw = -1, j = -1
				a[i][j] = ++n;
			}
			
			int temp = start;
			start = end;
			end = temp;
			sw *= -1;
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
			System.out.printf("%2d ", a[i][j]);
			}
			System.out.println();
		}

	}
}
