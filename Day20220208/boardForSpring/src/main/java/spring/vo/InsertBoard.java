package spring.vo;

public class InsertBoard {
	private int memberNum;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	
	public InsertBoard() {}
	
	public InsertBoard(String qnaBoardTitle, String qnaBoardContent) {
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
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
	
}
