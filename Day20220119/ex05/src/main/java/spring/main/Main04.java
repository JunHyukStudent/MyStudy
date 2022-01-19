package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client3;

public class Main04 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// 사용할 빈 객체를 불러와야 함
		Client3 client3_1 = ctx.getBean("client3",Client3.class);
		Client3 client3_2 = ctx.getBean("client3",Client3.class);
		
		System.out.println("(client3_1 == client3_2) => "+(client3_1==client3_2));

		
	}

}
