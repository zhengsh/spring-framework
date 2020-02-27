package cn.edu.cqvie.cglib0.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Dog dog = context.getBean(Dog.class);
		System.out.println(dog);
	}

	static class Dog {

	}

	@Configuration
	static class Config {

		@Bean
		public Dog dog() {
			return new Dog();
		}
	}
}
