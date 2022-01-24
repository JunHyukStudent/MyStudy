package spring.common;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spring.exception.MemberNotFoundException;

@ControllerAdvice("spring")
public class CommonExceptionHandler {//  예외처리 컨트롤러

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException(TypeMismatchException err) {
		return "exception/invalidate";
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public String handleMemberNotFoundException(MemberNotFoundException err) {
		return "exception/noMember";
	}
}
