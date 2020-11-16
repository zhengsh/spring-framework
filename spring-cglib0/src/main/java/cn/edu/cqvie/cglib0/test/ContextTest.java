package cn.edu.cqvie.cglib0.test;

import cn.edu.cqvie.cglib0.aspect.ServiceAspect;
import cn.edu.cqvie.cglib0.domain.Dog;
import cn.edu.cqvie.cglib0.service.DogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Spring 容器测试
 *
 * @author zhengsh
 * @date 2020-03-02
 */
public class ContextTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Dog dog = context.getBean(Dog.class);
		System.out.println(dog);
	}

	@Configuration
	static class Config {

		@Bean
		public Dog dogService() {
			return new Dog();
		}
	}
}
