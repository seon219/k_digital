package com.tjoeun.memolist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MemoList { // 메모 목록을 기억하는 클래스

	private ArrayList<MemoVO> memolist = new ArrayList<>();

	public ArrayList<MemoVO> getMemolist() {
		return memolist;
	}

	public void setMemolist(ArrayList<MemoVO> memolist) {
		this.memolist = memolist;
	}

	@Override
	public String toString() {
		String str = "";

		if (memolist.size() == 0) {// 저장된 메모가 없으면 메모가 없다는 메시지 출력

			str += "저장된 메모가 없습니다.";

		} else { // 저장된 메모가 있으면 마지막에 입력한 글부터 출력

			for (int i = memolist.size() - 1; i >= 0; i--) {
				str += memolist.get(i);
			}
//			for (MemoVO vo : memolist) {
//				str += vo + "\n";
//			}	

		}
		return str;
	}

	// MemoMain 클래스에서 호출되는 memolist라는 Arraylist에 저장할 데이터가 저장된 MemoVO클래스 객체를 넘겨받아
	// memolist라는 Arraylist에 저장하는 메소드
	public void addMemo(MemoVO vo) {
		memolist.add(vo);
	}

	// MemoMain 클래스에서 호출되는 수정/삭제할 글번호를 넘겨받고 memolist라는 Arraylist에 저장된 메모 중에서 수정/삭제할
	// 글번호에 해당되는 글 1건을 얻어와서 return하는 메소드
	public MemoVO selectMemo(int idx) {
		try {
			return memolist.get(idx - 1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	public void deleteMemo(int idx) {
		memolist.remove(idx - 1);

		// 글 삭제 후 인덱스가 변경되므로 인덱스에 맞춰서 글번호를 다시 붙여줌
		// Arraylist를 사용하기 때문에 발생되는 현상
		// Arraylist는 앞의 데이터가 지워지면 뒤에 데이터가 앞으로 인덱스가 당겨지는 특징

		// 글 삭제 후 글번호를 다시 붙여준다
		for (int i = 0; i < memolist.size(); i++) {
			memolist.get(i).setIdx(i + 1);
		}

		// 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록 count의 값을 수정
		MemoVO.count = memolist.size();
	}

	public void updateMemo(int idx, String memo) {

		memolist.get(idx - 1).setMemo(memo);
	}

	// MemoMain 클래스에서 호출되는 텍스트 파일의 이름을 넘겨받아 memolist Arraylist에 저장된 데이터를 텍스트 파일로
	// 출력하는 메소드
	public void writeMemo(String filename) {

		PrintWriter printWriter = null;

		// String filepath = ".\\src\\com\\tjoeun\\textFileIO\\memolist\\" + filename +
		// ".txt";
		String filepath = String.format(".\\src\\com\\tjoeun\\memolist\\%s.txt", filename);
		// System.out.println(filepath);
		try {
			printWriter = new PrintWriter(filepath);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			// memolist에 저장된 데이터를 공백으로 구분해서 1줄로 연결해서 출력

			for (int i = 0; i < memolist.size(); i++) {
				// System.out.println(memolist.get(i));
				MemoVO vo = memolist.get(i);
				String str = "";
				str += vo.getIdx() + " "; // 후에 데이터 식별을 위해 한칸 띄어써줌
				str += vo.getName().replace(" ", "`") + " ";
				str += vo.getPassword() + " ";
				str += vo.getMemo().replace(" ", "`") + " "; // 입력받은 글에 공백이 있을 때, 나중에 공백을 기준으로 읽어들이기 위해 공백을 문자로 바꿔준다.
				str += sdf.format(vo.getWriteDate());
				System.out.println(str);
				printWriter.write(str + "\n");

			}

//			==			
//			// 향상된 for(자료형 변수이름 : 배열의 이름)
//			for(MemoVO vo : memolist) {
//				String str = String.format(" %d %s %s %s %s", vo.getIdx(), vo.getName(), vo.getPassword(), vo.getMemo().replace(" ", "`"), sdf.format(vo.getWriteDate()));
//				System.out.println(str);
//				printWriter.write(str + "\n");
//			}

			System.out.println(filename + ".txt에 저장 완료!");
		} catch (FileNotFoundException e) {
			System.out.println("파일 또는 경로 이름이 올바르지 않습니다.");
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}

	}

	public void readMemo(String filename) {

		Scanner scanner = null;

		try {
			String filepath = String.format(".\\src\\com\\tjoeun\\memolist\\%s.txt", filename);
			scanner = new Scanner(new File(filepath)); // 익명으로 사용

			while (scanner.hasNextLine()) { // 텍스트 파일에 저장된 데이터를 마지막 줄까지 읽어서 memolist Arraylist에 저장

				String str = scanner.nextLine().trim(); // 텍스트 파일의 데이터 1줄 읽기
				// 읽어들일 데이터 1줄을 공백을 경계로 읽어서 각각의 변수에 저장
				System.out.println(Arrays.toString(str.split(" ")));

				Scanner scan = new Scanner(str);

				int count;
				int idx = scan.nextInt();
				String name = scan.next().replace("`", " "); // 공백 경계이기 때문에 next로 받음
				String password = scan.next();
				String memo = scan.next().replace("`", " ");
				String temp = scan.nextLine().trim();

//				// 텍스트 파일에서 읽어들인 문자열로 변환되서 저장된 날짜 데이터를 Date 클래스 객체를 사용해서 날짜 데이터로 변환
//				int year = Integer.parseInt(temp.substring(0,4)) - 1900;
//				int month = Integer.parseInt(temp.substring(5,7)) -1;
//				int day = Integer.parseInt(temp.substring(8,10));
//				int hour = Integer.parseInt(temp.substring(11,13));
//				int min = Integer.parseInt(temp.substring(14,16));
//				int sec = Integer.parseInt(temp.substring(17,19));
//				Date writedate = new Date(year, month , day, hour, min, sec);
//				System.out.println(writedate);

				// split() 메소드의 구분자를 "."로 지정하면 제대로 작동되지 않음
				// split() 메소드에서 "."을 구분자라면 "\\." 또는 "[.]" 형태로 구분자를 지정
				String[] date = temp.split("\\.");
				int year = Integer.parseInt(date[0]) - 1900;
				int month = Integer.parseInt(date[1]) - 1;
				int day = Integer.parseInt(date[2]);
				int hour = Integer.parseInt(date[3]);
				int min = Integer.parseInt(date[4]);
				int sec = Integer.parseInt(date[5]);
				Date writedate = new Date(year, month, day, hour, min, sec);

//				// 각각의 변수에 저장된 데이터를 MemoVO 클래스 객체를 만들어 넣어준다.
//				MemoVO vo = new MemoVO();
//				vo.setIdx(idx);
//				vo.setName(name);
//				vo.setPassword(password);
//				vo.setMemo(memo);
//				vo.setWriteDate(writedate);
				
				
				// MemoVO에서 새로운 생성자를 만들어줌
				MemoVO vo = new MemoVO(idx, name, password, memo, writedate);

				// MemoVO 클래스 객체에 저장도니 데이터를 momolist Arraylist에 저장
				memolist.add(vo);

			}
			System.out.println(filename + ".txt 파일에서 읽기 완료!");

		} catch (FileNotFoundException e) {
			System.out.println(filename + ".txt 파일이 존재하지 않습니다.");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
