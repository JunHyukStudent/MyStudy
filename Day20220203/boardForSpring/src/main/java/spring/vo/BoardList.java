package spring.vo;

import java.util.Date;

public class BoardList {
	private int qnaBoardNum;
	private String qnaBoardTitle;
	private String memberName;
	private Date qnaBoardRegdate;
	private int qnaBoardCount;
	
	public BoardList(int qnaBoardNum, String qnaBoardTitle, String memberName, Date qnaBoardRegdate,
			int qnaBoardCount) {
		super();
		this.qnaBoardNum = qnaBoardNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.memberName = memberName;
		this.qnaBoardRegdate = qnaBoardRegdate;
		this.qnaBoardCount = qnaBoardCount;
	}
	
	public int getQnaBoardNum() {
		return qnaBoardNum;
	}
	public String getQnaBoardTitle() {
		return qnaBoardTitle;
	}
	public String getMemberName() {
		return memberName;
	}
	public Date getQnaBoardRegdate() {
		return qnaBoardRegdate;
	}
	public int getQnaBoardCount() {
		return qnaBoardCount;
	}
	
	
}
