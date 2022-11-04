package com.tjoeun.register;

public class RegisterVO {

	private String userid;
	private String userpassword;
	private String username;
	private int userage;
	private String usergender;
	private String useremail;
	
	
	public RegisterVO() { }
	public RegisterVO(String userid, String userpassword, String username, int userage, String usergender,
			String useremail) {
		super();
		this.userid = userid;
		this.userpassword = userpassword;
		this.username = username;
		this.userage = userage;
		this.usergender = usergender;
		this.useremail = useremail;
	}

	
	public String getUserid() {return userid;}
	public void setUserid(String userid) {this.userid = userid;}

	public String getUserpassword() {return userpassword;}
	public void setUserpassword(String userpassword) {this.userpassword = userpassword;}

	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public int getUserage() {return userage;}
	public void setUserage(int userage) {this.userage = userage;}

	public String getUsergender() {return usergender;}
	public void setUsergender(String usergender) {this.usergender = usergender;}

	public String getUseremail() {return useremail;}
	public void setUseremail(String useremail) {this.useremail = useremail;}

	
	@Override
	public String toString() {
		return "RegisterVO [userid=" + userid + ", userpassword=" + userpassword + ", username=" + username
				+ ", userage=" + userage + ", usergender=" + usergender + ", useremail=" + useremail + "]";
	}
	
	
}
