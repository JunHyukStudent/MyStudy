package spring.vo;

public class MemberInfo {
	private int memberNum;
	private String memberId;
	private String memberName;
	private String memberEmail;
	private String memberPhone;
	
	public MemberInfo() {}
	
	public MemberInfo(int memberNum, String memberId, String memberName, String memberEmail, String memberPhone) {
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
	}
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	
}
