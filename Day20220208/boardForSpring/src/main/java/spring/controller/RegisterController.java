package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.dao.MemberDao;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private MemberDao dao;
	
	public RegisterController(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/registerForm")
	public String registerForm(Model model) {
		model.addAttribute("formData",new RegisterRequest());
		return "register/registerForm";
	}

	@RequestMapping(value = "/registMember", method = RequestMethod.POST)
	public String registMember(@ModelAttribute("formData")RegisterRequest regReq) {
		if(!regReq.isPasswordEqualToConfirmPassword()) {
			return "register/registerForm";
		}
		dao.insert(regReq);
		return "main";
	}
}
