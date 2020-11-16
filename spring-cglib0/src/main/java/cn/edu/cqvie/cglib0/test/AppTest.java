package cn.edu.cqvie.cglib0.test;

import cn.edu.cqvie.cglib0.config.AppConfig;
import cn.edu.cqvie.cglib0.service.DogService;
import cn.edu.cqvie.cglib0.service.XService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhengsh
 */
public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DogService dogService = context.getBean("dogService", DogService.class);
		System.out.println(dogService);

		dogService = context.getBean("dogService", DogService.class);
		System.out.println(dogService);
	}
}
