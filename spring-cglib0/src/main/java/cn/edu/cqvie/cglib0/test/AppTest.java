package cn.edu.cqvie.cglib0.test;

import cn.edu.cqvie.cglib0.service.XService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		XService bean = ac.getBean(XService.class);

		System.out.println(bean);
		//System.out.println(bean.getyService());
	}
}
@ComponentScan("cn.edu.cqvie.cglib0.service")
@Configuration
@EnableAspectJAutoProxy
class AppConfig {

}
