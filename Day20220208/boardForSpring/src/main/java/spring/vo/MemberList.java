package spring.vo;

public class MemberList {
	private int memberNum;
	private String memberId;
	private String memberName;
	
	public MemberList(){};
	
	public MemberList(int memberNum, String memberId, String memberName) {
		this.memberNum = memberNum;
		this.memberId = memberId;
		this.memberName = memberName;
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
	
	
}
