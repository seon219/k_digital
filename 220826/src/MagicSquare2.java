import java.util.Scanner;

public class MagicSquare2 { // 마방진 만들기

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		int row;
		while(true) {
			System.out.print("마방진을 출력할 행렬의 차수를 3이상인 홀수로 입력하세요: ");
			row = scanner.nextInt();
			
			if (row >= 3 && row % 2 ==1) {
				break;
			}
			System.out.println("3 이상인 홀수를 입력하세요: ");
		}
		
		int[][] a = new int [row][row];
		int i = 0, j = row / 2;
		
		for (int p = 1; p<= row * row; p++) {

			a[i][j] = p;
			
	
			if (p % row == 0) {	
				i++;
			} else {
				if (--i == -1) {					
					i = row-1;
				}
				if (++j == row) {
					j = 0;
				}
			}
			
		}
		for (i = 0; i < a.length; i++) { // 행
			for (j = 0; j < a[i].length; j++) { // 열
			System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}
	}
	

}
