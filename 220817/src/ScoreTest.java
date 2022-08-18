import java.util.Scanner;

public class ScoreTest {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("java 점수: ");
		int java = scanner.nextInt();
		System.out.print("jsp 점수: ");
		int jsp = scanner.nextInt();
		System.out.print("spring 점수: ");
		int spring = scanner.nextInt();
		
		
//		System.out.print("3과목 점수를 입력하세요: ");
//		int java = scanner.nextInt();
//		int jsp = scanner.nextInt();
//		int spring = scanner.nextInt();

		
		
		int total = java + jsp + spring;
		double avg = (double) total / 3;
		//double avg = total / 3.;
		
//		System.out.println("총점: " + total + "점, 평균: " + avg);
		System.out.printf("총점: %3d점, 평균: %6.2f점 \n", total, avg);
		
//		// 평균이 90이상이면 A
//		if (avg >= 90) {
//			System.out.println("A"); }
//		// 평균이 90미만이고 80이상이면 B
//		if (avg >= 80 && avg < 90) {
//			System.out.println("B"); }
//		// 평균이 80미만이고 70이상이면 C
//		if (avg >= 70 && avg < 80) {
//			System.out.println("C"); }
//		// 평균이 70미만이고 60이상이면 D
//		if (avg >= 60 && avg < 70) {
//			System.out.println("D"); }
//		// 평균이 60미만이면 F
//		if (avg < 60) {
//			System.out.println("F"); }
		
		
		if (avg >= 90) {
			System.out.println("A");
		} else if (avg >= 80) {
			System.out.println("B"); 
		} else if (avg >= 70) {
			System.out.println("C");
		} else if (avg >= 60) {
			System.out.println("D"); 
		} else {
			System.out.println("F"); 
		}
		
		
		
		
		
	}

}
