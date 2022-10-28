package com.tjoeun.fileupload;

public class FileVO {

	private int idx;
	private String filename;
	private String filerealname;
	private int downloadcount;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilerealname() {
		return filerealname;
	}
	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	public int getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(int downloadcount) {
		this.downloadcount = downloadcount;
	}
	
	
	@Override
	public String toString() {
		return "FileVO [idx=" + idx + ", filename=" + filename + ", filerealname=" + filerealname + ", downloadcount="
				+ downloadcount + "]";
	}
	
}

