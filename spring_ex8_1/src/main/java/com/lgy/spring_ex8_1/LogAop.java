package com.lgy.spring_ex8_1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println("@@@# start===> " + signatureStr);
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("@@@# end===> " + signatureStr);
		}
		return obj;
	}
}