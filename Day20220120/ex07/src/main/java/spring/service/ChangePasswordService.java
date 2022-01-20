package spring.service;

import org.springframework.transaction.annotation.Transactional;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

public class ChangePasswordService {//암호를 변경하기 위한 기능을 담당하는 클래스
	
	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Transactional    //해당 메서드는 하나의 논리적 작업 영역으로 취급
	public void changepassword(String email, String oldPwd, String newPwd) {
		// 비밀번호 변경전 해당 계정이 있는지 체크
		Member member = memberDao.selectByEmail(email);
		
		if(member ==null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPwd, newPwd); //객체 안 비밀번호 변경
		
		memberDao.update(member);  //DB 업데이트
	}
	
}
