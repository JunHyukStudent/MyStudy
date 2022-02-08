package spring.vo;

import java.util.Date;

public class BoardInfo {
	private int qnaBoardNum;
	private int memberNum;
	private String memberName;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	private Date qnaBoardRegdate;
	private int qnaBoardCount;
	
	public BoardInfo(int qnaBoardNum, int memberNum, String memberName, String qnaBoardTitle, String qnaBoardContent,
			Date qnaBoardRegdate, int qnaBoardCount) {
		this.qnaBoardNum = qnaBoardNum;
		this.memberNum = memberNum;
		this.memberName = memberName;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
