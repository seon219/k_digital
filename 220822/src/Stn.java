
public class Stn {

	public static void main(String[] args) {
		
		int[] data = {1, 2, 3, 4, 5};
		
/*		// 최대값을 기억할 기억장소는 아주 작은 값을, 최소값을 기억할 기억장소는 아주 큰 값을 초기치로 지정
		int min = 100;
		int max = 0;
		
		for(int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			} 
			if (data[i] < min) {
				min = data[i];
			}
		}
		//최대값과 최소값을 기억할 기억장소에 각각 데이터가 저장된 배열의 0번째 인덱스 요소를 초기치로 지정
*/		
	
		
/*		int min = data[0];
		int max = data[0];
		
		
		// i가 1부터 시작하는 이유는 최대값과 최소값을 기억할 변수에 배열의 0번째 인덱스 값을 초기치로 저장.
		// 자기 자신끼리 비교해봐야 최대/최소 값을 판별하는데 전혀 도움이 되지 않기 때문
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			} else if (data[i] < min) {
				min = data[i];
			}
		}
		System.out.println("최대값: " + max + ", 최소값: " + min);
*/		

		
		for (int i = 0; i < data.length-1; i++) {
			
			boolean flag = true;
			
			for (int j = 0; j < data.length-1-i; j++) {
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
					
					flag = false;
				}
			}
			if (flag = true) {
				break;
			}
		}
		
		// 최소값과 최대값을 제외한 나머지 데이터의 평균
/*		// 데이터가 정렬되지 않은 경우: (전체 데이터의 합계 - 최대값 - 최소값) / (데이터의 개수 - 2)
		int sum = 0;
		
		for (int i = 0; i <data.length; i++) {
			sum += data[i];
		}
		double avg = (sum - min - max) / (double) (data.length - 2);
*/
		
		
		// 데이터가 정렬 된 경우:
		// 0번째 인덱스와 마지막 인덱스를 제외한 데이터의 합계 / (데이터의 개수 - 2)
		int sum = 0;
		for (int i = 1; i <data.length-1; i++) {
			sum += data[i];
		}
		double avg = sum / (double) (data.length - 2); // 산술 평균
		System.out.println("최대값과 최소값을 제외한 데이터의 평균(데이터가 정렬된 경우): " + avg);
		
		double stn = 0.0;
		for (int i = 1; i < data.length-1; i++) {
			// 최대값과 최소값을 제외한 각 데이터에서 평균을 뺀 편차
			double temp = data[i] - avg;
			// 최대값과 최소값을 제외한 각 데이터에서 평균을 뺀 편차의 제곱
			//stn += temp * temp;
			stn += Math.pow(temp, 2);
		}
		
		// 분산
		double var = stn / (data.length - 2);
		System.out.println("최대값과 최소값을 제외한 나머지 데이터의 분산: " + var);
		//double std = Math.pow(var, 0.5);
		double std = Math.sqrt(var);
		System.out.println("최대값과 최소값을 제외한 나머지 데이터의 표준편차: " + std);
		
	}
	
}
