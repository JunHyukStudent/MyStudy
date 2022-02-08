package spring.vo;

public class AuthInfo {
	private int memberNum;
	private String memberName;
	
	public AuthInfo() {}

	public AuthInfo(int memberNum, String memberName) {
		this.memberNum = memberNum;
		this.memberName = memberName;
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
	
	
}
