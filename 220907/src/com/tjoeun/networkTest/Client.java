package com.tjoeun.networkTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client { // 클라이언트: 서버에서 제공하는 서비스를 사용

	public static void main(String[] args) {
		
		Socket socket = null; // 통신소켓
		Scanner scanner = null; // 클라이언트에서 전송되는 데이터를 읽는 스케너
		PrintWriter printWriter = null; // 클라이언트로 데이터를 전송하는 printWriter
		
		
		try {
			// 서버에 접속
			// 192.168.0.63
			System.out.println("192.168.0.63 서버의 10004번 포트로 접속시도");
			// new Socket(host, port): host => 서버의 ip 주소, port => 서버의 포트 번호
			socket = new Socket("192.168.0.63", 10004);
			
			
			// 서버에서 전송되는 데이터를 수신하기 위해 수신용 객체를 선언
			scanner  = new Scanner(socket.getInputStream());
			// 서버에서 전송된 데이터를 읽어 출력한다.
			System.out.println(scanner.nextLine());
			
			
			// 클라이언트에서 서버로 데이터를 전송하기 위해 전송용 객체를 생성
			printWriter = new PrintWriter(socket.getOutputStream());
			// 클라이언트에서 서버로 머시지를 전송
			printWriter.write("뭘 ㅅ다리고 그래 \n");
			printWriter.flush();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 서버와의 통신이 종료되면 통신에 사용한 소켓 객체를 닫는다
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
