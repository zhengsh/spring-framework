package cn.edu.cqvie.aspect;


import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {

	@Pointcut("execution(* cn.edu.cqvie.service.*.*(..))")
	public void serviceOperation() {}


	@Before("cn.edu.cqvie.aspect.LogAspect.serviceOperation()")
	public void doServiceCheck() {
		System.out.println("doServiceCheck .....");
	}

	@After("cn.edu.cqvie.aspect.LogAspect.serviceOperation()")
	public void doReleaseLock() {
		System.out.println("doReleaseLock .....");
	}

	@AfterReturning(
			pointcut="cn.edu.cqvie.aspect.LogAspect.serviceOperation()",
			returning="retVal")
	public void doServiceCheck(Object retVal) {
		System.out.println("doServiceCheck ....." + retVal);
	}
}
