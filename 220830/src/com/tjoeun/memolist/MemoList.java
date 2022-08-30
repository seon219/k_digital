package com.tjoeun.memolist;

import java.util.ArrayList;

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
		
		if(memolist.size() == 0) {// 저장된 메모가 없으면 메모가 없다는 메시지 출력
			
			str += "저장된 메모가 없습니다.";
			
		} else { // 저장된 메모가 있으면 마지막에 입력한 글부터 출력
			
			for (int i = memolist.size()-1; i >= 0; i--) {
				str += memolist.get(i);
			}
//			for (MemoVO vo : memolist) {
//				str += vo + "\n";
//			}	
		
		}
		return str;
	}
	
	// MemoMain 클래스에서 호출되는 memolist라는 Arraylist에 저장할 데이터가 저장된 MemoVO클래스 객체를 넘겨받아 memolist라는 Arraylist에 저장하는 메소드
	public void addMemo(MemoVO vo) {
		memolist.add(vo);
	}

	// MemoMain 클래스에서 호출되는 수정/삭제할 글번호를 넘겨받고 memolist라는 Arraylist에 저장된 메모 중에서 수정/삭제할 글번호에 해당되는 글 1건을 얻어와서 return하는 메소드
	public MemoVO selectMemo(int idx) {
		try {
			return memolist.get(idx-1);
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
	

}
