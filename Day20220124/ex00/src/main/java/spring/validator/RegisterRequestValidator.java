package spring.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.vo.RegisterRequest;

public class RegisterRequestValidator implements Validator{
	//		커맨드 객체에 전달된 값이 올바른 가 체크하기 위한 클래스
	//			사용 위치 : 컨트롤러

	@Override
	public boolean supports(Class<?> clazz) { 
		// 전달 받은 객체가 검증하고자 하는 객체로 변환이 가능한지 체크	
		return RegisterRequest.class.isAssignableFrom(clazz);
	}
	
	
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		String regex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";// 규격화된 형식
		pattern = Pattern.compile(regex);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//				검사 대상 객체,      검사 결과를 담은 에러 객체

		RegisterRequest regReq = (RegisterRequest)target;
		
		if(regReq.getEmail()==null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			// 정규식 체크 기능 => 문자열 규격이 일치하는 가를 따져보기위한 형식
			// 이메일 형식 => xxxx@xxx.xxx
			// 전화번호 형식 => ooo-oooo-oooo
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		
		// 자주 사용되는 검증 에러 코드 : 널인가?, 비었는가? 를 체크하는 검증용 객체
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		//								name 필드가 널인가, 비었는가를 체크해서 해당되면 errors객체에 required 에러코드를 저장
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}

}
