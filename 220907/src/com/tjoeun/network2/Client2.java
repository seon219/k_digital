package com.tjoeun.network2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {

		Socket socket = null;
		PrintWriter printWriter = null;
		Scanner scanner = null; //서버에서 전송되는 메시지를 읽는 스캐너
		Scanner scan = null; // 서버로 전송할 메시지를 입력하는 스캐너
		
		
		try {
			socket = new Socket("192.168.0.63", 10004);
			System.out.println("192.168.0.63 서버에 10004번 포트로 접속합니다.");
			System.out.println("접속 성공: " + socket);
			
			
			// 송수신에 사용할 객체 선언
			printWriter = new PrintWriter(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());
			scan = new Scanner(System.in);
						
			
			// 서버에서 넘어온 메시지를 출력
			System.out.println(scanner.nextLine());
			
			
//			==========================================================
			// 키보드로 입력한 메시지 또는 서버에서 전송받은 메시지가 "BYE"면 통신 종료
			String msg = "";
			do {
				// 서버로 전송할 메시지를 입력받는다.
				System.out.print("client >>");
				msg = scan.nextLine().trim();
				// 입력받은 메시지를 서버로 전송
				printWriter.write(msg + "\n");
				printWriter.flush();
				// 입력한 메시지가 "BYE"면 통신 종료 => 반복문 탈출
				if (msg.toUpperCase().equals("BYE")) {
					break;
				}
//				================== 클라이언트가 서버로 "BYE"전송===============
				
				
				// 서버에서 전송받은 메시지 출력
				msg = scanner.nextLine().trim();
				System.out.println("server >>" + msg);
				// 서버에서 전송받은 메시지가 "BYE"면 통신 종료
			} while (!msg.toUpperCase().equals("BYE"));
//			==================서버에서 전송한 "BYE"로 통신 종료===============
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}

	}

}
