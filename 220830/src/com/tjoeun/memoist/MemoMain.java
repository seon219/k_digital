package com.tjoeun.memoist;

import java.util.Scanner;

public class MemoMain {

	public static void main(String[] args) {

//		MemoVO memo1 = new MemoVO("홍길동", "1234", "안녕");
//		System.out.println(memo1);
//		MemoVO memo2 = new MemoVO("임꺽정", "1111", "2등");
//		System.out.println(memo2);
//		MemoVO memo3 = new MemoVO("장길산", "3333", "3등");
//		System.out.println(memo3);

		Scanner scanner = new Scanner(System.in);
		int menu = 0;

		while (menu != 5) {

			while (true) {
				System.out.println("===========================================");
				System.out.println("1.입력  2.목록보기  3.수정  4.삭제  5.종료");
				System.out.println("===========================================");
				System.out.print("원하는 메뉴를 선택하세요.");
				menu = scanner.nextInt();

				if (menu >= 1 && menu <= 5) {
					break;
				}

				System.out.println("\n메뉴는 1 ~ 5 사이로 입력해야 합니다.");
			}

			switch (menu) {
			case 1:
				System.out.println("입력");
				insert();
				break;
			case 2:
				System.out.println("목록보기");
				break;
			case 3:
				System.out.println("수정");
				break;
			case 4:
				System.out.println("삭제");
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");


	}

	// private 현재 클래스 전용 메소드
	// 키보드로 이름, 비밀번호, 메모를 입력받아 MemoVO 클래스 객체에 저장하고,
	// ArrayList에 저장하는 메소드를 호출하는 메소드
	private static void insert() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("게시판에 저장할 글 입력");
		System.out.print("이름: ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine().trim();
		System.out.print("메모: ");
		String memo = scanner.nextLine().trim();
				
		
		MemoVO vo = new MemoVO(name, password, memo);
		System.out.println(vo);
		
		
	}

}
