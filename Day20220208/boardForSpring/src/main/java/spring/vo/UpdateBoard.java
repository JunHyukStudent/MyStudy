package spring.vo;

public class UpdateBoard {
	private int qnaBoardNum;
	private String qnaBoardTitle;
	private String qnaBoardContent;
	
	public UpdateBoard() {}
	
	public UpdateBoard(int qnaBoardNum, String qnaBoardTitle, String qnaBoardContent) {
		this.qnaBoardNum = qnaBoardNum;
		this.qnaBoardTitle = qnaBoardTitle;
		this.qnaBoardContent = qnaBoardContent;
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

	public String getQnaBoardContent() {
		return qnaBoardContent;
	}

	public void setQnaBoardContent(String qnaBoardContent) {
		this.qnaBoardContent = qnaBoardContent;
	}
	
	
}
