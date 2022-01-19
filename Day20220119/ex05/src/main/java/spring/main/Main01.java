package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client;

public class Main01 {

	public static void main(String[] args) {
		Client client = new Client();
		client.send();
		System.out.println("------------------------------------");
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		// 스프링 설정파일을 읽어와서
		//    스프링 컨테이너 초기화 
		//			빈 객체 생성  => 빈 객체간의 의존 주입  => 빈 객체 초기화
		
		// 사용할 빈 객체를 불러와야 함
		Client client2 = ctx.getBean("client",Client.class);
		
		// 가져온 빈 객체를 사용
		client2.send();
		
		// 컨터이너를 종료  => 컨테이너 내부의 빈 객체는 소멸
		ctx.close();
		
		
	}

}
