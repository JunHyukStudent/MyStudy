package spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.AuthService;
import spring.validator.LoginCommandValidator;
import spring.vo.AuthInfo;
import spring.vo.LoginCommand;

@Controller
public class LoginController {
	
	private AuthService authservice;
	
	public void setAuthservice(AuthService authservice) {
		this.authservice = authservice;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String form(LoginCommand loginCommand,//model.addAttribute("loginCommand",new LoginCommand());
			@CookieValue(value="rememberEmail", required=false)Cookie rememberEmail) {
		// "rememberEmail"이름을 가진 쿠키가 있다면 쿠키 객체에 담아서 사용하세요.
		if(rememberEmail != null) {
			loginCommand.setEmail(rememberEmail.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		return "login/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String submit(LoginCommand loginCommand,Errors errors,
			HttpSession session, HttpServletResponse response) {
		// 1. 이메일과 비밀번호 입력했는지 검증
		new LoginCommandValidator().validate(loginCommand, errors);
		
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		// 2. 입력받은 이메일과 비밀번호 일치 여부를 따져봅시다.(서비스)
		try {
			AuthInfo ai = authservice.authenticate(loginCommand.getEmail(),loginCommand.getPassword());
		
			// 로그인 성공후 처리할 코드
			// 세션객체에 로그인 정보를 저장
			session.setAttribute("authInfo", ai);
			
			// 이메일 저장용 쿠키를 굽도록 합니다.
			Cookie rememberCookie
			 = new Cookie("rememberEmail",loginCommand.getEmail());
			
			rememberCookie.setPath("/");
			
			if(loginCommand.isRememberEmail()) {// 이메일 기억하기를 체크했는가?
				rememberCookie.setMaxAge(60*60*24*365);
			}else {
				rememberCookie.setMaxAge(0);
			}
			// 클라이언트에 쿠키 저장
			response.addCookie(rememberCookie);
			
			
			return "login/loginSuccess";
		}catch(IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");// 글로벌 에러 메시지
			return "login/loginForm";
		}
		
	}
}
