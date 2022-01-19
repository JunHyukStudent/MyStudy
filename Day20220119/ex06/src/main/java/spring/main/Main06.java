package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main06 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCTX03.xml");
		
		Calculator impeCalc = ctx.getBean("impeCalc",Calculator.class);
		impeCalc.factorial(10);
		impeCalc.factorial(10);

	}

}
