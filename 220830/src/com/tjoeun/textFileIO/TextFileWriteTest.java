package com.tjoeun.textFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileWriteTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PrintWriter printWriter = null;
		
		// 파일 경로와 이름을 설정
		// 경로 지정방식은 절대경로 지정방식과 상대경로 지정방식이 있음
		// 절대경로는 작업중인 파일이 위치한 디스크 드라이브의 최상위(root) 폴더(디렉토리)부터 파일이 위치한 폴더까지의 경로
		// 상대경로는 작업중인 파일이 포함된 프로젝트 이름의 (".")폴더부터 작업중인 파일이 위치한 폴더까지의 경로
		// python이나 c/c++의 "."은 화면에 열려있는 파일이 위치한 폴더를 의미하지만 java의 "."은 파일이 포함된 프로젝트 이름의 폴더 의미
		// 경로 지정시 경로와 경로, 경로와 파일을 구분하는 "\"가 에러가 발생되면 "\\"나 "/"로 수정
		
		
		// 절대경로
		//String filepath = "D:\\k_digital\\workspace\\220830\\src\\com\\tjoeun\\textFileIO\\data\\out.txt";
	
		// 상대경로
		String filepath = ".\\src\\com\\tjoeun\\textFileIO\\data\\out.txt";

		
		try {
			printWriter = new PrintWriter(filepath);
			scanner = new Scanner(System.in);
			
			// QUIT가 입력될 때까지 반복하며 키보드로 입력한 데이터를 파일에 저장
			while (true) {
				// 텍스트 파일에 저장할 데이터를 키보드로 입력받기
				System.out.print(">>> ");
				String str = scanner.nextLine().trim();
				
				// 입력받은 내용이 "QUIT"인 경우 무한루프를 탈출
				if (str.toUpperCase().equals("QUIT")) {
					break;
				}
				// 키보드로 입력받은 내용을 텍스트 파일에 저장
				// write() 메소드를 사용해서 PrintWriter 클래스 객체로 생성한 파일에 출력
				// write() 메소드로 출력할 때 \n을 입력했음에도 텍스트 파일에서 줄이 변경되지 않으면 \r\n 사용
				// \n : new Line, 줄을 바꾼다.
				// \r : carriage return, 커서를 그 줄의 맨 앞으로 보낸다.
				if (str.length() != 0) {
					printWriter.write(str + "\n"); 
				}
			}
			
			System.out.println("텍스트 파일에 저장 완료!");
			//printWriter.close();
			
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} finally {
			if (printWriter != null) {
				// 출력 파일은 출력 작업이 완료되면 반드시 파일을 닫아야 정상적으로 파일이 생성됨
				printWriter.close();				
			}
		}
		
		
		
	}

}
