package com.tjoeun.memolist;

import java.util.Scanner;

public class MemoMain {

	private static MemoList memolist = new MemoList();
	
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
			case 1: // 입력
				insert();
				break;
			case 2: // 목록보기
				System.out.println(memolist);
				break;
			case 3: // 수정
				update();
				break;
			case 4: // 삭제
				delete();
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");


	}


	// 키보드로 수정할 글번호를 입력받아 수정할 글 1건을 얻어와 화면에 표시하고,
	// 비밀번호를 입력받아 memolist라는 Arraylist에 저장하는 메소드를 호출하는 메소드
	private static void update() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 글번호를 입력하세요: ");
		int idx = scanner.nextInt();
			
		MemoVO original = memolist.selectMemo(idx);
		
		if (original == null) { // 글이 존재하지 않을 때
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println("수정할 글 확인");
			System.out.println(original);
			System.out.print("수정할 글의 비밀번호를 입력하세요: ");
			scanner.nextLine(); // 키보드 버퍼를 비운다.
			String password = scanner.nextLine().trim();
			
			if (password.equals(original.getPassword())) {
				
				System.out.print("수정할 메모를 입력하세요: ");
				String memo = scanner.nextLine().trim();
				
				memolist.updateMemo(idx, memo);
				System.out.println(idx + "번 글 수정 완료!");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		
		
		
		
	}

	// 키보드로 삭제할 글번호를 입력받아 삭제할 글 1건을 얻어와 화면에 표시하고,
	// 비밀번호를 입력받아 memolist라는 Arraylist에 저장하는 메소드를 호출하는 메소드
	private static void delete() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 글번호를 입력하세요: ");
		int idx = scanner.nextInt();
		
		// memolist라는 Arraylist에 저장된 글 1건을 얻어오는 메소드를 실행하고 얻어온 결과를 MemoVO 클래스 객체에 저장
		MemoVO original = memolist.selectMemo(idx);
		//System.out.println(original);
		
		// 삭제할 글번호에 해당되는 글이 존재하면 글을 지우고,
		// 존재하지 않으면 글이 존재하지 않는다는 메시지를 출력
		if (original == null) { // 글이 존재하지 않을 때
			System.out.println(idx + "번 글이 존재하지 않습니다.");
		} else {
			System.out.println("삭제할 글 확인");
			System.out.println(original);
			System.out.print("삭제할 글의 비밀번호를 입력하세요: ");
			scanner.nextLine(); // 키보드 버퍼를 비운다.
			String password = scanner.nextLine().trim();
			
			
			// 삭제하기 위해 입력한 비밀번호(password)와 삭제할 글의 비밀번호(original.getPassword())를 비교
			if (password.equals(original.getPassword())) {
				// 비밀번호가 일치하므로 memolist라는 Arraylist에 저장된 메모를 삭제하는 메소드 실행
				memolist.deleteMemo(idx);
				System.out.println(idx + "번 글 삭제 완료!");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
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
		//System.out.println(vo);
		
		
		// MemoVO 클래스 객체를 memolist 클래스의 Arraylist에 저장하는 메소드
		//MemoList memolist = new MemoList(); // insert() 메소드가 종료되면 메모리에서 소멸
		memolist.addMemo(vo);
		System.out.println("저장완료!");
		System.out.println(memolist);
	}


}
