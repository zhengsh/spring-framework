package cn.edu.cqvie.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Log1Aspect {


	@Pointcut("execution(* cn.edu.cqvie.service.IGoodsService.*(..))")
	public void serviceOperation1() {

	}

	@Before("cn.edu.cqvie.aspect.Log1Aspect.serviceOperation1()")
	public void doServiceCheck1() {
		System.out.println("doServiceCheck1 .....");
	}

	@After("cn.edu.cqvie.aspect.Log1Aspect.serviceOperation1()")
	public void doReleaseLock1() {
		System.out.println("doReleaseLock1 .....");
	}
}
