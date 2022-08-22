import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int data[] = {8, 3, 4, 9, 1};
		
		for (int i = 0; i < data.length-1; i++) {
			for (int j = 0; j < data.length-1-i; j++) {
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;

					System.out.println((i + 1) +"회전결과: " + Arrays.toString(data));
				}
			}
			//System.out.println((i + 1) +"회전결과: " + Arrays.toString(data));
		}
	}
}
