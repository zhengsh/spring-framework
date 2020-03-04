package cn.edu.cqvie.cglib0.test;

import cn.edu.cqvie.cglib0.aspect.ServiceAspect;
import cn.edu.cqvie.cglib0.domain.Dog;
import cn.edu.cqvie.cglib0.service.DogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.List;

public class AopTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		DogService dog = context.getBean(DogService.class);
		List<Dog> li = dog.query();
		System.out.println(li);
	}

	@Configuration
	@EnableAspectJAutoProxy
	@Import({DogService.class, ServiceAspect.class})
	static class Config {
	}
}
