package spring.printer;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter {
	
	private MemberDao memDao;
	private MemberPrinter printer;
	
	//Setter메서드를 통해서 주 객체를 주입받는다.
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
	
		if(member == null) {
			System.out.println("데이터없음!");
			return;
		}
		
		printer.print(member);
		System.out.println();
			
	}

	
}
