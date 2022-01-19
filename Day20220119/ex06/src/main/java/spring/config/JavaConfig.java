package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aspect.ExeTimeAspect2;
import spring.calc.Calculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

@Configuration
@EnableAspectJAutoProxy   //  <aop:aspectj-autoproxy />
public class JavaConfig {

	@Bean
	public ExeTimeAspect2 ExeTimeAspect() { 
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator impeCalc() {
		return new ImpeCalculator();
	}
	
	@Bean
	public Calculator recCalc() {
		return new RecCalculator();
	}
	
}
