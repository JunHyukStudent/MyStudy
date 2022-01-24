package spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.MemberDao;
import spring.vo.ListCommand;
import spring.vo.Member;

@Controller
public class MemberListController {

	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/member/list")
	public String list(
			@ModelAttribute("cmd")ListCommand listCommand,Errors errors,Model model) {
		
		if(errors.hasErrors()) { // 날짜 형식 오류 :  typeMismatch
			return "member/memberList";
		}
		
		if(listCommand.getFrom()!=null && listCommand.getTo()!=null) {
			List<Member> memberList= 
					dao.selectByRegDate(
							listCommand.getFrom(),
							listCommand.getTo());
			
			model.addAttribute("members",memberList);
		}
		
		return "member/memberList";
	}
	
}
