package com.tjoeun.textFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReadTest {

	public static void main(String[] args) {

		Scanner scanner = null;

		// 파일의 경로와 이름 설정
//		String filepath = ".\\src\\com\\tjoeun\\textFileIO\\data\\out.txt";
		// 텍스트 파일을 읽어오지 못할 경우, 텍스트 파일 인코딩을 ANSI에서 UTF-8로 변경하면 읽어들일 수 있음
		String filepath = ".\\src\\com\\tjoeun\\textFileIO\\data\\in.txt";

		try {

			// Scanner 클래스 객체를 만들 때 생성자로 System.in을 넘겨주면 키보드로 입력받는 스캐너가 만들어짐
			// 텍스트 파일에서 데이터를 입력받는 스캐너를 만드려면 읽어들이려는 텍스트파일의 경로와,
			// 이름으로 File 클래스 객체를 만들어 Scanner 생성자로 넘겨줘야 함
//			File file = new File(filepath); // 파일의 경로와 이름을 이용해서 File객체를 만든다
//			scanner = new Scanner(file);
			scanner = new Scanner(new File(filepath));

			// 텍스트 파일에서 더 이상 읽어들일 데이터(줄)가 없을 때까지 반복하여 읽어들인다.
			// hasNextLine() 메소드는 스캐너로 지정된 파일에서 읽어들일 데이터가 있으면 true, 없으면 false 리턴
			while (scanner.hasNextLine()) {

				String str = scanner.nextLine().trim();
				if (str.length() != 0) {
					System.out.println(str);
				}
			}
			
			System.out.println("텍스트 파일에서 읽기 완료!");
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} finally {
			// 출력 용도로 사용되는 PrintWriter 객체는 작업이 완료되면 반드시 close() 메소드를 실행해서 파일은 닫아야 하지만,
			// 입력 용도로 사용하는 Scanner 객체는 파일을 닫지 않아도 정상적으로 처리됨
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
