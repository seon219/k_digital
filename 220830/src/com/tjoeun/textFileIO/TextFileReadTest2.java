package com.tjoeun.textFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TextFileReadTest2 {

	public static void main(String[] args) {

		Scanner scanner = null;
		
		String filepath = ".\\src\\com\\tjoeun\\textFileIO\\data\\input.txt";
		
		try {
			scanner = new Scanner(new File(filepath));
			
			while(scanner.hasNextLine()) {
				String str = scanner.nextLine().trim();
				System.out.println(str);
				System.out.println(Arrays.toString(str.split(" "))); //배열로 분리, 
				// 구분자가 공백일 때에는 split 사용, split은 구분자가 한가지여야지만 사용할 수 있음
				
				int i = 0;
				boolean b = false;
				double d = 0;
				String s = "";
				
				// String 변수에 저장된 문자열을 읽어들이는 Scanner
				// Scanner 클래스의 객체를 만들 때 생성자의 인수로 String 변수를 넘기면 String변수에 저장된 데이터를 읽어들임
				Scanner scan = new Scanner(str);
				// hasNext() 메소드는 스캐너로 지정된 문자열에서 공백을 경계로 읽어들일 데이터가 있으면 true, 없으면 false 리턴
				while (scan.hasNext()) {
					if (scan.hasNextInt()) { // Scanner로 읽을 데이터가 int면 true, 아니면 false
						i = scan.nextInt();						
					} else if (scan.hasNextBoolean()) {
						b = scan.nextBoolean();						
					} else if(scan.hasNextDouble()) {
						d = scan.nextDouble();						
					} else {
						s = scan.next().trim();						
					}
				}
			
				System.out.println("i: " + i);
				System.out.println("b: " + b);
				System.out.println("d: " + d);
				System.out.println("s: " + s);
			}
			
			System.out.println("파일에서 읽기 완료!");
		} catch (FileNotFoundException e) {
			System.out.println("디스크에 파일이 없습니다.");
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		
		
		
	}

}
