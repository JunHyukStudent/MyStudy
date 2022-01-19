package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.bean.Client2;
import spring.bean.Client3;

@Configuration
public class JavaConfig {

	@Bean(initMethod="connect", destroyMethod="close")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("웹서버3");
		return client2;
	}
	
	@Bean
	@Scope("prototype")  //프로토타입으로 작동
	public Client3 client3() {
		Client3 client3 = new Client3();
		client3.setHost("웹서버3");
		return client3;
	}
}
