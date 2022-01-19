package spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean{
							// 빈 객체의 생성과 소멸시 작동할 메서드를 구현해주는 인터페이스
	private String host;

	public void setHost(String host) {  // 문자열 객체를 주입 받는다.
		this.host = host;
		System.out.println("Client.setHost() 실행");
	}
	
	public void send() {		// 실제 사용할 메서드
		System.out.println("Client.send() to "+host);  // 의존적
	}

	@Override
	public void destroy() throws Exception {
		// 빈 소멸시 작동할 메서드
		System.out.println("빈 소멸 : Client.destroy() 실행");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 빈이 초기화시 작동할 메서드
		System.out.println("빈 초기화 : Client.afterPropertiesSet() 실행");
	}
	
}
