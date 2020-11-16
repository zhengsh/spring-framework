package cn.edu.cqvie.cglib0.test;

import cn.edu.cqvie.cglib0.beans.factory.SanFactoryBean;
import cn.edu.cqvie.cglib0.config.AppConfig;
import cn.edu.cqvie.cglib0.service.DogService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		DogService dogService = applicationContext.getBean("sanFactoryBean", DogService.class);
		System.out.println("dogService: " + dogService);
	}
}
