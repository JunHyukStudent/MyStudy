package spring.main;

import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

public class Main01 {

	public static void main(String[] args) {
		ImpeCalculator impeCal = new ImpeCalculator();
		long fiveFactorial1 = impeCal.factorial(5);
		
		RecCalculator recCal = new RecCalculator();
		long fiveFactorial2 = recCal.factorial(5);
		
		System.out.println("fiveFactorial1의 결과 : "+fiveFactorial1);
		System.out.println("fiveFactorial2의 결과 : "+fiveFactorial2);

	}

}
