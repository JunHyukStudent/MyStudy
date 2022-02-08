package spring.vo;

import java.util.Date;

public class Comment {
	private int commentNum;
	private int qnaBoardNum;
	private String commentContent;
	private Date commentRegdate;
	
	public Comment() {}
	
	public Comment(int commentNum, int qnaBoardNum, String commentContent, Date commentRegdate) {
		this.commentNum = commentNum;
		this.qnaBoardNum = qnaBoardNum;
		this.commentContent = commentContent;
		this.commentRegdate = commentRegdate;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getQnaBoardNum() {
		return qnaBoardNum;
	}
	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentRegdate() {
		return commentRegdate;
	}
	public void setCommentRegdate(Date commentRegdate) {
		this.commentRegdate = commentRegdate;
	}
}
