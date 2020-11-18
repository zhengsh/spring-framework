package cn.edu.cqvie.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 测试 PostProcessor
 *
 * @author zhengsh
 * @date 2020-11-15
 */
@Component
public class TestBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanPostProcessor, ApplicationContextAware {

	public TestBeanPostProcessor() {
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if ("goodsService".equals(beanName)) {
			System.out.println("实例化前 。。。。。");
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if ("goodsService".equals(beanName)) {
			System.out.println("实例化后 。。。。。");
		}
		return true;
	}

	/**
	 * 初始化前
	 *
	 * @param bean     the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("goodsService".equals(beanName)) {
			System.out.println("初始化前（属性填充） 。。。。。");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("goodsService".equals(beanName)) {
			System.out.println("初始化后（属性填充） 。。。。。");
		}
		return bean;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware");
	}
}
