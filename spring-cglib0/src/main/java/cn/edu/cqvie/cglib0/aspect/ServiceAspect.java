package cn.edu.cqvie.cglib0.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

	@Pointcut("execution( * cn.edu.cqvie.cglib0.service..*.*(..))")
	private void anyOldTransfer() {

	}

	@Before("anyOldTransfer()")
	public void advice() {
		System.out.println("--------------");
	}
}
