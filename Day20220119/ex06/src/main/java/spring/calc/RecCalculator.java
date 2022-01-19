package spring.calc;

public class RecCalculator implements Calculator{

	@Override
	public long factorial(long num) { // 재귀를 가지고 팩토리얼 구하는 방법
		// 공통기능 : 구하는 데 걸리는 시간
		// 핵심기능 : 팩토리얼 구하는 방법
		
		//long start = System.currentTimeMillis();
		try {
			if(num==0) {
				return 1;
			}else {
				return num*factorial(num-1);
			}
		}finally {
		//	long end = System.currentTimeMillis();
		//	System.out.printf("RecCalculator.factorial(%d)실행 시간 : %d \n",num,(end-start));
		}
		
	}

}
