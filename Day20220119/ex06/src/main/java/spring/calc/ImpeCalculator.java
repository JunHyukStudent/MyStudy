package spring.calc;

public class ImpeCalculator implements Calculator{

	@Override
	public long factorial(long num) { // 재귀 없이 팩토리얼 구하는 법
		// 공통기능 : 구하는 데 걸리는 시간
		// 핵심기능 : 팩토리얼 구하는 방법
		
		//long start = System.currentTimeMillis();
		int result = 1;
		for(long i=1;i<=num;i++) {
			result*=i;
		}
		//long end = System.currentTimeMillis();
		
		//System.out.printf("ImpeCalculator.factorial(%d)실행 시간 : %d \n",num,(end-start));
		return result;
	}

}
