package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "login/loginForm";
	}
}
