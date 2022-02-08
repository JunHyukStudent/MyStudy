package spring.vo;

import java.util.Date;

public class Board {
	private int qnaBoardNum;
	private int memberNum;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	private Date qnaBoardRegdate;
	private int qnaBoardCount;
	
	public Board() {}
	
	public Board(int memberNum, String qnaBoardTitle, String qnaBoardContent, Date qnaBoardRegdate,
			int qnaBoardCount) {
		this.memberNum = memberNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.qnaBoardCount = qnaBoardCount;
	}
	
	public int getQnaBoardNum() {
		return qnaBoardNum;
	}
	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}
	public void setQnaBoardTitle(String qnaBoardTitle) {
		this.qnaBoardTitle = qnaBoardTitle;
	}
	public String getQnaBoardContent() {
		return qnaBoardContent;
	}
	public void setQnaBoardContent(String qnaBoardContent) {
		this.qnaBoardContent = qnaBoardContent;
	}
	public Date getQnaBoardRegdate() {
		return qnaBoardRegdate;
	}
	public void setQnaBoardRegdate(Date qnaBoardRegdate) {
		this.qnaBoardRegdate = qnaBoardRegdate;
	}
	public int getQnaBoardCount() {
		return qnaBoardCount;
	}
	public void setQnaBoardCount(int qnaBoardCount) {
		this.qnaBoardCount = qnaBoardCount;
	}
}
