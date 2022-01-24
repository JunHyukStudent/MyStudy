package spring.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckIntercepter extends HandlerInterceptorAdapter{//implements HandlerInterceptor{
					//					HandlerInterceptor :  인터페이스 => 기능을 구현하도록 강제
					//					어댑터클래스 => 인터페이스를 구현한 클래스 => 기능은 없는 클래스
					//					상속받아서 만들면 기능을 강제로 구현할 필요없이 필요한 기능 구현해서 사용하면 된다.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인이 안되어 있으면 로그인 부터 처리하세요.
		HttpSession session = request.getSession();
		Object ai = session.getAttribute("authInfo");
		
		if(ai!=null) {// 로그인 되어있는 상태
			return true;  // 그냥 진행하면 됩니다.
		}
		
		response.sendRedirect(request.getContextPath()+"/login");
		//						localhost:8090/ex00     /login
		return false;

	}

	
}
