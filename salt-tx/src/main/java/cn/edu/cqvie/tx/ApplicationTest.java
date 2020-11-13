package cn.edu.cqvie.tx;

import cn.edu.cqvie.tx.config.ApplicationConfig;
import cn.edu.cqvie.tx.config.DataSourceConfig;
import cn.edu.cqvie.tx.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类
 *
 * @author zhengsh
 * @date 2020-11-13
 */
public class ApplicationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(DataSourceConfig.class, ApplicationConfig.class);
		PersonService personService = applicationContext.getBean(PersonService.class);
		System.out.println(personService);
		personService.test();
	}
}
