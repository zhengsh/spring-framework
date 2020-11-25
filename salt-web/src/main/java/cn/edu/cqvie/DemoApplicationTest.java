package cn.edu.cqvie;

import cn.edu.cqvie.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class DemoApplicationTest {

	public static void main(String[] args) {
		// 创建容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//场景1.重复刷新报错: GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once
		//applicationContext = new AnnotationConfigApplicationContext();
		//如果需要支持可以使用: applicationContext = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		//applicationContext.refresh();

		// 获取 UserService 对象
		UserService userService = applicationContext.getBean(UserService.class);
		// 执行 test 方法
		System.out.println(userService);
	}
}

@Configuration
@Import(UserService.class)
class AppConfig {

}

