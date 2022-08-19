
public class Ranking {
	
	public static void main(String[] args) {
		
		int scr[] = {80, 100, 70, 100, 94, 95};
		// 석차를 기억하는 기억장소는 1로 초기화
		//int rank[] = {1, 1, 1, 1, 1};
		int rank[] = new int[scr.length];
		for (int i = 0; i<rank.length; i++) {
			rank[i] = 1;
		}
		
		for (int i = 0; i < scr.length-1; i++) {
			for (int j = i + 1; j < scr.length; j++) {
				// i 번째 점수가 크면 j번쨰 석차 증가, j번째 점수가 크면 i번째 석차 증가
				if (scr[i] < scr[j]) {
					rank[i]++;
				} else if (scr[i] > scr[j]) {
					rank[j]++;
				}
			}
			
		}
		
		
		for (int i = 0; i < scr.length; i++) {
			System.out.printf("%3d점은 %d등 입니다. ", scr[i], rank[i]);
			for (int j = 0; j < scr[i]/10; j++) {
				System.out.print("★");
				
			}
			if (scr[i] % 10 >= 5) {
				System.out.print("☆");
			}
			System.out.println();
		
		}
		
	}

}
