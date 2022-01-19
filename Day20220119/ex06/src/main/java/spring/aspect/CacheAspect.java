package spring.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	
	private Map<Long,Object> cache = new HashMap<>(); // 임시로 저장할 공간
	
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		Long num = (Long)joinPoint.getArgs()[0];
		
		if(cache.containsKey(num)) {
			System.out.printf("CacheAspect.Cache에서 구함 [%d]\n",num);
			return cache.get(num);
		}
		Object result = joinPoint.proceed(); //핵심 메서드 구동
		cache.put(num, result);
		System.out.printf("CacheAspect.Cache에 추가 [%d]\n",num);
		return result;
	}
}
