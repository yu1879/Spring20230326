package spring.core.session05.aop;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyLoggerAspect {
	// @Before(value = "execution(* *(..))")
//	@Before(value = "pt()")
	@Pointcut(value = "execution(* spring.core.session05.aop.CalcImpl.*(..))")
	public void pt() {
	}

	@Pointcut(value = "execution(* spring.core.session05.aop.CalcImpl.div(..))")
	public void pt2() {
	}

	@Before(value = "pt() ")
	public void beforeAdvice(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		System.out.printf("呼叫前置通知-方法名稱:%s 方法參數:%s\n", methodName, Arrays.toString(args));
	}

	@After(value = "pt()")
	public void afterAdvice(JoinPoint joinpoint) {
//		String methodName = joinpoint.getSignature().getName();
//		Object[] args = joinpoint.getArgs(); 
		System.out.printf("呼叫後置通知\n");
	}

	@AfterThrowing(value = "pt()", throwing = "ex")
	public void afterThrowingAdvice(Exception ex) {
		System.out.printf("呼叫異常通知-ex:%s\n", ex);

	}

	@AfterReturning(value = "pt()", returning = "result")
	public void afterReturningAdvice(Object result) {
		System.out.printf("呼叫返回通知-result:%s\n", result);

	}
}
