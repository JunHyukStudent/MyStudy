package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.bean.Client2;
import spring.config.JavaConfig;

public class Main03 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
		 = new AnnotationConfigApplicationContext(JavaConfig.class);

		// 스프링 설정파일을 읽어와서
		//    스프링 컨테이너 초기화 
		//			빈 객체 생성  => 빈 객체간의 의존 주입  => 빈 객체 초기화
		//												init-method="사용할 메서드 이름"
		
		// 사용할 빈 객체를 불러와야 함
		Client2 client2 = ctx.getBean("client2",Client2.class);
		
		// 가져온 빈 객체를 사용
		client2.send();
		
		// 컨터이너를 종료  => 컨테이너 내부의 빈 객체는 소멸   => detroy-method="사용할 메서드 이름"
		ctx.close();
	}

}
