package com.tjoeun.memolist;

import java.util.ArrayList;
import java.util.Scanner;

// 데이터를 테이블에 저장, 테이블에 저장된 데이터의 수정, 삭제 및 조회작업 실행하기 전에,
// 필요한 전처리 작업을 실행하는 클래스

public class MemoService {

	
	// 데이터를 입력받아 DAO클래스로 넘겨주는 메소드
	public static void insert() {
		
		// 전처리
		// 테이블에 저장할 데이터를 입력받는다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scanner.nextLine().trim();
		System.out.print("비밀번호: ");
		String password = scanner.nextLine().trim();
		System.out.print("메모 : ");
		String memo = scanner.nextLine().trim();
		
		
		// 입력받은 데이터를 MemoVO클래스 객체를 만들어 저장
		MemoVO vo = new MemoVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMemo(memo);
		
		
		// 입력받은 데이터를 테이블에 저장하는 DAO 클래스의 메소드 호출
		boolean result = MemoDAO.insert(vo);
		
		
		// 후처리
		if (result) {
			System.out.println(name + "님 글 저장완료!");
		} else {
			System.out.println("저장실패..");
		}
		
		
	}

	
	
	// 테이블에 저장된 메모 목록을 글번호(idx)의 내림차순(최신글순)으로 얻어오는 DAO 클래스의 메소드를 호출하는 메소드
	public static void select() {
		
		
		// 테이블에 저장된 메모 목록을 얻어온다.
		ArrayList<MemoVO> list = MemoDAO.select();
		//System.out.println(list);
		
		
		// 얻어온 메모 목록을 출력
		if (list == null || list.size() == 0) {
			System.out.println("테이블에 저장된 메모가 없습니다.");
		} else {
			for(MemoVO vo : list)
			System.out.println(vo);
		}					
		
	}



	// 삭제할 글번호를 입력받고 비밀번호 확인 후 글 삭제하는 DAO 클래스에 메소드 호출
	public static void delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 글 번호를 입력하세요: ");
		int idx = scanner.nextInt();
		
		// 테이블에서 삭제할 글을 얻어오는 DAO클래스의 메소드 호출
		MemoVO original = MemoDAO.selectByIdx(idx);
		//System.out.println(original);
		
		if (original != null) {
			System.out.println("삭제할 메모 확인");
			System.out.println(original);
			
			// 메모를 삭제하기 위해 비밀번호를 입력한다.
			scanner.nextLine(); // 키보드 버퍼 비우기
			System.out.print("비밀번호를 입력하세요: ");
			String password = scanner.nextLine().trim();
			
			// 삭제할 글의 비밀번호와, 입력한 비밀번호 비교
			if (original.getPassword().equals(password)) {
				
				// 비밀번호가 일치하면 메모를 삭제하는 DAO 클래스의 메소드 호출
				
				MemoDAO.delete(idx);
				System.out.println(idx + "번 메모 삭제 완료!");
				
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
			
		}else {
			System.out.println(idx + "번 메모는 존재하지 않습니다.");
		}

	}



	
	public static void update() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 글 번호를 입력하세요: ");
		int idx = scanner.nextInt();
		
		// 테이블에서 수정할 글을 얻어오는 DAO클래스의 메소드 호출
		MemoVO original = MemoDAO.selectByIdx(idx);
		//System.out.println(original);
		
		if (original != null) {
			System.out.println("수정할 메모 확인");
			System.out.println(original);
			
			// 메모를 수정하기 위해 비밀번호를 입력한다.
			scanner.nextLine(); // 키보드 버퍼 비우기
			System.out.print("비밀번호를 입력하세요: ");
			String password = scanner.nextLine().trim();
			
			// 수정할 글의 비밀번호와, 입력한 비밀번호 비교
			if (original.getPassword().equals(password)) {
				
				// 수정할 메모를 입력받는다
				System.out.print("수정할 메모를 입력하세요: ");
				String memo = scanner.nextLine().trim();
				
				// 비밀번호가 일치하면 메모를 수정하는 DAO 클래스의 메소드 호출
				MemoDAO.update(idx, memo);
				System.out.println(idx + "번 메모 수정 완료!");
				
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
			
			
		}else {
			System.out.println(idx + "번 메모는 존재하지 않습니다.");
		}
	}
	
	
	
	
	

}
