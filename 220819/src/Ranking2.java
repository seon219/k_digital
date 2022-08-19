
public class Ranking2 {
	
	public static void main(String[] args) {
		
		int scr[] = {80, 100, 70, 100, 90};
		// 석차를 기억하는 기억장소는 1로 초기화
		//int rank[] = {1, 1, 1, 1, 1};
		int rank[] = new int[scr.length];
		for (int i = 0; i<rank.length; i++) {
			rank[i] = 1;
		}
		
		for (int i = 0; i < scr.length; i++) {
			for (int j = 0; j < scr.length; j++) {
				// 내림차순 석차 ( 큰 점수가 1등)
				if (scr[i] < scr[j]) {
					rank[i]++;
				}
			}
			
		}
		
		for (int i = 0; i < scr.length; i++) {
			System.out.printf("%3d점은 %d점 입니다. \n", scr[i], rank[i]);
		
		}
		
	}

}
