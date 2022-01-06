package com.green.vo;

public class CommentVO {
	private int C_code;
	private int B_code = 1;
	private String C_user;
	private String C_comment;
	private String C_password;
	private String C_regDate;
	
	public int getC_code() {
		return C_code;
	}
	public void setC_code(int c_code) {
		C_code = c_code;
	}
	public int getB_code() {
		return B_code;
	}
	public void setB_code(int b_code) {
		B_code = b_code;
	}
	public String getC_user() {
		return C_user;
	}
	public void setC_user(String c_user) {
		C_user = c_user;
	}
	public String getC_comment() {
		return C_comment;
	}
	public void setC_comment(String c_comment) {
		C_comment = c_comment;
	}
	public String getC_password() {
		return C_password;
	}
	public void setC_password(String c_password) {
		C_password = c_password;
	}
	public String getC_regDate() {
		return C_regDate;
	}
	public void setC_regDate(String c_regDate) {
		C_regDate = c_regDate;
	}
}
