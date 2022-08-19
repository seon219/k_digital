
public class StarTest {

	public static void main(String[] args) {
		
		// *
		// **
		// ***
		// ****
		// *****
		
		for (int i = 0; i < 5; i++) { //행(세로)
			for (int j = 0; j <= i; j++) { //열(가로)
				System.out.print("*");		
			}
			System.out.println();
		}
		System.out.println("==================");
		
		
		// *****
		// ****
		// ***
		// **
		// *
		
		for (int i = 0; i < 5; i++) { 
			//for (int j = 5; j > i; j--) { 
			for (int j = 0; j <= 4-i; j++) { 
				System.out.print("*");		
			}
			System.out.println();
		}
		System.out.println("==================");
		
		
		//     *
		//    **
		//   ***
		//  ****
		// *****
		
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j <= 3-i; j++) { 
				System.out.print("_");		
			}
			for (int j = 0; j <= i; j++) { 
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==================");
		
		
		// *****
		//  ****
		//   ***
		//    **
		//     *
		
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j <= i-1; j++) {
				System.out.print("_");		
			}
			for (int j = 0; j <= 4-i; j++) { 
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println("==================");
		
		
		// *       *
		// **     **
		// ***   ***
		// **** ****
		// *********
		
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j <= i; j++) { 
				System.out.print("*");
			}
			for (int j = 0; j < 7-i*2; j++) { 
				System.out.print("_");
			}
			for (int j = 0; j <= i; j++) { 
				if (j == 4) {
					break;
				}
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==================");
		
	}
}
