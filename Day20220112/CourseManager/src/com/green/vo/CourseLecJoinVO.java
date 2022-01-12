package com.green.vo;

public class CourseLecJoinVO {
	private String c_id;
	private String c_name;
	private int credit;
	private String l_name;
	private int week;
	
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getWeek() {
		String weekKR = "";
		switch(week) {
		case 1:
			weekKR="월";
			break;
		case 2:
			weekKR="화";
			break;
		case 3:
			weekKR="수";
			break;
		case 4:
			weekKR="목";
			break;
		case 5:
			weekKR="금";
			break;
		case 6:
			weekKR="토";
			break;
		}
		return weekKR;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	
}
