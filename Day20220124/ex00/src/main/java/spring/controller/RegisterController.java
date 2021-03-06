package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exception.AlreadyExistingMemberException;
import spring.service.MemberRegisterService;
import spring.validator.RegisterRequestValidator;
import spring.vo.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	// step1==============================================================================================
	
	//@RequestMapping("/register/step1") // http://localhost:8090/ex00 /register/step1
	@RequestMapping("/step1")  //  => /register/step1
	public String handlerStep1() {
		return "register/step1"; // /WEB-INF/views/ register/step1 .jsp
	}
	
	// step2==============================================================================================
	
	//@RequestMapping("/register/step2")
//	@RequestMapping(value="/register/step2", method=RequestMethod.POST) //POST방식으로 요청이 들어왔을 때만 작동
//	public String handleStep2(HttpServletRequest request) {  // 방법1 : Request객체에서 직접 데이터를 받아오기
//		String agreeParam = request.getParameter("agree");
//		
//		if(agreeParam == null || !agreeParam.equals("true")) {
//			return "register/step1";
//		}
//		
//		return "register/step2";
//	}
	
	// step2 - POST==============================================================================================
	//@RequestMapping(value="/register/step2", method=RequestMethod.POST) //POST방식으로 요청이 들어왔을 때만 작동
	@RequestMapping(value="/step2", method=RequestMethod.POST) //  => /register/step2
	public String handlerStep2(  // 방법2 : @RequestParam어노테이션을 이용해서 데이터 받아오기
			@RequestParam(value="agree", defaultValue="false")Boolean agree,
			Model model) { 
		
		// 데이터를 보내주기 위한 모델 객체를 얻어와야 한다.
		if(!agree) {
			return "register/step1";
		}

		model.addAttribute("formData",new RegisterRequest());
		// 오류 방지를 위한 빈 formData를 전달
		
		return "register/step2";
	}
	
	// step2 - GET==============================================================================================
	@RequestMapping(value="/step2", method=RequestMethod.GET)
	public String handlerStep2Get() {
		//return "register/step1"; // 주소창에는  step2로 보여짐 , 보여지는 페이지는 step1
		
		return "redirect:register/step1";// 주소창에는  step1로 보여짐 , 보여지는 페이지는 step1
		//return "redirect:http://localhost:8090/ex00/register/step1"; // 전체주소를 입력해서 리다이렉트 할수 있다.
	}
	
// step3==============================================================================================
	
	// 클라이언트로 부터 데이터를 읽어오는 방법 1 
//	@RequestMapping(value="/step3")
//	public String handlerStep3(HttpServletRequest request) {
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String confirmPassword = request.getParameter("confirmPassword");
//		
//		// 읽어온 데이터 처리
//		
//		return "register/step3";
//	}
	
	// 클라이언트로 부터 데이터를 읽어오는 방법 2
//	@RequestMapping(value="/step3")
//	public String handlerStep3(HttpServletRequest request,
//			@RequestParam(value="email")String email,
//			@RequestParam(value="name")String name
////			@RequestParam(value="password")String password,
////			@RequestParam(value="confirmPassword")String confirmPassword
//			) {
//		String password = request.getParameter("password");
//		String confirmPassword = request.getParameter("confirmPassword");
//		// 읽어온 데이터 처리
//		
//		return "register/step3";
//	}
	
	// 클라이언트로 부터 데이터를 읽어오는 방법 3 :  커맨드 객체를 사용하는 방법 (빈=자바빈=커맨드객체)
	// 클라이언트로부터 얻어오는 이름(name)과 객체안에 필드 이름이 일치해야함 
	// 각 필드의 set메서드가 존재해야 한다.
	@RequestMapping(value="/step3")
	public String handlerStep3(@ModelAttribute("formData") RegisterRequest regReq,Errors errors) {
						// 데이터를 읽어와서 커맨드객체에 담아서 사용
						// 데이터를 내보낼때도 커맨드 객체를 사용할 수 있다. 내보내진 커맨드 객체의 이름을 바꾸고 싶다면 어노테이션을 사용
						//																@ModelAttribute("이름")
		// 읽어온 데이터 처리
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {// 에러 체크후 에러가 발견되었다면
			return "register/step2"; 
		}
		
		
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";   
		}
	}
}
















