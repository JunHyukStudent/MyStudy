package spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {  //공통 기능을 담을 객체
				// 시간 측정이라는 공통기능
	
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed(); // 핵심 기능으로 연결 시켜줄 메서드
			return result;
		}finally {
			long end = System.nanoTime();
			
			// 1. 핵심 기능을 수행하는 메서드의 이름??
			Signature sig = joinPoint.getSignature(); // 핵심 기능을 가진 메서드의 정보
			String methodName = sig.getName();  //핵심 기능을 하는 메서드 이름
			
			// 2. 핵심 기능을 가진 메서드가 소속된 객체
			joinPoint.getTarget();
			// 해당 객체의 이름
			String className = joinPoint.getTarget().getClass().getSimpleName(); 
			
			// 3. 핵심 기능을 가진 메서드가 전달 받는 매개값
			joinPoint.getArgs(); 
			String argumentName = Arrays.toString(joinPoint.getArgs());
			
			System.out.printf("%s.%s(%s)실행 시간 : %d\n",
					className,methodName,argumentName,(end-start));
			
		}
	}

}
