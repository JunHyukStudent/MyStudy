package spring.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

@Controller
public class MemberDetailController {

	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/member/detail/{id}")
	public String detail(@PathVariable("id") Long memberId, Model model) {
		// 특정 누군가의 정보를 보고 싶은것(특정 게시물의 구체적 내용을 알고 싶은 것)
		// 특정 누군가를 식별할 수 있는 정보 : id => memberId
		
		Member member = dao.selectById(memberId);
		
		if(member==null) { //id로 조회된 정보가 없을 때
			throw new MemberNotFoundException(); 
		}
		
		model.addAttribute("member",member);
		
		return "member/memberDetail";
	}
	
	
//	@ExceptionHandler(TypeMismatchException.class)
//	public String handleTypeMismatchException(TypeMismatchException err) {
//		return "member/invalidate";
//	}
//	
//	@ExceptionHandler(MemberNotFoundException.class)
//	public String handleMemberNotFoundException(MemberNotFoundException err) {
//		return "member/noMember";
//	}
	
	
	
	
}
