package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.ChangePasswordService;
import spring.validator.ChangePwdCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.ChangePwdCommand;

@Controller
@RequestMapping("edit/changePassword")
public class ChangePwdController {

	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(ChangePwdCommand changePwdCommand,HttpSession session) {
		/*
		 * AuthInfo ai = (AuthInfo)session.getAttribute("authInfo"); if(ai==null) {
		 * return "redirect:/login"; }
		 */
		
		return "edit/changePwdForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(ChangePwdCommand changePwdCommand,Errors errors,HttpSession session) {
		//1. 검증
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		//2. 현재 로그인된 이메일 정보 알아오기
		AuthInfo ai = (AuthInfo)session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(
					ai.getEmail(),
					changePwdCommand.getCurrentPassword(),
					changePwdCommand.getNewPassword());
			
			return "edit/changedPwd";
			
		}catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword","notMatching");
			return "edit/changePwdForm";
		}
		
	}
	
	
	
}
