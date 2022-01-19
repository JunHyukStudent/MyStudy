package spring.main;

import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;
import spring.proxy.ExeTimeCalculator;

public class Main02 {

	public static void main(String[] args) {
		ExeTimeCalculator impeCalc = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println("impeCalc 계산 결과 : "+impeCalc.factorial(10));
		
		ExeTimeCalculator recCal = new ExeTimeCalculator(new RecCalculator());
		System.out.println("recCal 계산 결과 : "+recCal.factorial(10));
	}

}
