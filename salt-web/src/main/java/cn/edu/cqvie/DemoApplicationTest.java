package cn.edu.cqvie;

import cn.edu.cqvie.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class DemoApplicationTest {

	public static void main(String[] args) {
		// 创建容器
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 获取 UserService 对象
		UserService userService = applicationContext.getBean(UserService.class);
		// 执行 test 方法
		userService.test();
	}
}

@Configuration
@Import(UserService.class)
class AppConfig {

}

// UserSerivce 类
@Service
public class UserService {
	public String test() {
		return "test";
	}
}
