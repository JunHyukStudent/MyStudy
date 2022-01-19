package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.calc.Calculator;
import spring.config.JavaConfig;

public class Main05 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		long tenFactorial1 = impeCalc.factorial(10);
		System.out.println("impeCalc.factorial(10) = "+tenFactorial1);
		
		
		Calculator recCalc = ctx.getBean("recCalc",Calculator.class);
		long tenFactorial2 = recCalc.factorial(10);
		System.out.println("recCalc.factorial(10) = "+tenFactorial2);
	}
}
