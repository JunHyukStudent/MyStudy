package spring.vo;

import java.util.Date;

public class BoardAdminList {
	private int qnaBoardNum;
	private String qnaBoardTitle;
	private String memberName;
	private Date qnaBoardRegdate;
	private int qnaBoardCount;
	private boolean commentYN;
	
	public BoardAdminList() {}
	
	public BoardAdminList(int qnaBoardNum, String qnaBoardTitle, String memberName, Date qnaBoardRegdate,
			int qnaBoardCount) {
		this.qnaBoardNum = qnaBoardNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.memberName = memberName;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.qnaBoardCount = qnaBoardCount;
	}
	public int getQnaBoardNum() {
		return qnaBoardNum;
	}
	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}
	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}
	public void setQnaBoardTitle(String qnaBoardTitle) {
		this.qnaBoardTitle = qnaBoardTitle;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public boolean isCommentYN() {
		return commentYN;
	}
	public void setCommentYN(boolean commentYN) {
		this.commentYN = commentYN;
	}
}
