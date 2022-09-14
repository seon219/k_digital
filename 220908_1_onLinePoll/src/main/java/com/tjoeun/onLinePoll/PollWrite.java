package com.tjoeun.onLinePoll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PollWrite {

	// 텍스트 파일에 저장할 데이터가 저장된 ArrayList를 넘겨받아 텍스트 파일로 저장하는 메소드
	public static void pollWrite(String filepath, ArrayList<String> poll) {
		
		// ArrayList에 저장된 데이터를 텍스트 파일로 출력하기 위해 PrintWriter 클래스 객체 선언
		PrintWriter printWriter = null;
		
		try {
			// ArrayList에 저장된 데이터를 텍스트 파일로 출력할 PrintWriter 클래스 객체 생성
			printWriter = new PrintWriter(filepath);
			
			// ArrayList에 저장된 데이터의 개수만큼 반복하여 텍스트 파일로 출력
			for (String str : poll) {
				printWriter.write(str + "\r\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 텍스트 파일 출력에 사용한 객에를 닫는다.
			// 출력 객체를 닫지 않으면 파일로 출력한 데이터가 저장되지 않는다.
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
		
	}
	
	
	
	
}
