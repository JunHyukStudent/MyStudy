package com.green.vo;

public class CourseVO {
	private String c_id;
	private String c_name;
	private int credit;
	private int c_lecturer;
	private int week;
	private int start_hour;
	private int end_hour;
	private String weekKR;
	private String c_lecturerKR;
	
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
	public int getC_lecturer() {
		return c_lecturer;
	}
	public void setC_lecturer(int c_lecturer) {
		this.c_lecturer = c_lecturer;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(int start_hour) {
		this.start_hour = start_hour;
	}
	public int getEnd_hour() {
		return end_hour;
	}
	public void setEnd_hour(int end_hour) {
		this.end_hour = end_hour;
	}
	public String getWeekKR() {
		return weekKR;
	}
	public void setWeekKR(String weekKR) {
		this.weekKR = weekKR;
	}
	public String getC_lecturerKR() {
		return c_lecturerKR;
	}
	public void setC_lecturerKR(String c_lecturerKR) {
		this.c_lecturerKR = c_lecturerKR;
	}
}
