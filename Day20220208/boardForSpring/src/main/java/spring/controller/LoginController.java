package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.dao.LoginDao;
import spring.vo.AuthInfo;
import spring.vo.LoginRequest;
import spring.vo.MemberInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
	LoginDao dao;
	public LoginController(LoginDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}
	
	@RequestMapping("/loginMember")
	public String loginMember(LoginRequest logReq,HttpSession session) {
		AuthInfo authInfo = dao.login(logReq.getLoginId(),logReq.getLoginPwd());
		
		if(authInfo == null) {
			return "login/loginForm";
		}
		
		session.setAttribute("authInfo", authInfo);
		return "redirect:/";
	}
	
	@RequestMapping("/loginInfo")
	public String loginInfo(HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		int memberNum = authInfo.getMemberNum();
		
		MemberInfo memberInfo = dao.selectByMemberNum(memberNum);
		
		model.addAttribute("memberInfo",memberInfo);
		
		return "/login/loginInfo";
	}
}
