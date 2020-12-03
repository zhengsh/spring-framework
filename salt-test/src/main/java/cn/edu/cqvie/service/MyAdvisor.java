package cn.edu.cqvie.service;

import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MyAdvisor implements PointcutAdvisor {
	@Override
	public Pointcut getPointcut() {
		NameMatchMethodPointcut methodPointcut = new NameMatchMethodPointcut();
		methodPointcut.setMappedName("test");
		return methodPointcut;
	}

	@Override
	public Advice getAdvice() {
		return new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("方法执行之前");
			}
		};
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}
}
