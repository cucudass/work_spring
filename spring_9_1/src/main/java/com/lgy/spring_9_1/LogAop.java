package com.lgy.spring_9_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//공통기능 클래스
@Aspect
public class LogAop {
	//공통기능이 적용되는범위
	@Pointcut("within(com.lgy.spring_9_1.*)")
	private void pointCutMethod() {}
	
	//메소드 실행 전/후, 예외처리 포함해서 공통기능 실행
	@Around("pointCutMethod()")
	public Object loggerAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr+" is start");
		long st = System.currentTimeMillis();
		Object obj = null;

		try {
			obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr+" is finish");
			System.out.println(signatureStr+"의 경과시간 "+(et-st));
		}
	}
}