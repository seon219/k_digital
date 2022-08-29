package com.tjoeun.memoist;

import java.util.ArrayList;

public class MemoList {
	
	private ArrayList<MemoVO> memolist = new ArrayList<>();

	public ArrayList<MemoVO> getMemolist() {
		return memolist;
	}

	public void setMemolist(ArrayList<MemoVO> memolist) {
		this.memolist = memolist;
	}

	@Override
	public String toString() {
		return "MemoList [memolist=" + memolist + "]";
	}
	
	public void addMomo(MemoVO memo) {
		memolist.add(memo);
	}
	

}
