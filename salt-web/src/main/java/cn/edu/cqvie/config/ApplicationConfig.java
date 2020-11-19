package cn.edu.cqvie.config;

import cn.edu.cqvie.service.StockService;
import org.springframework.context.annotation.*;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Configuration
@ComponentScan("cn.edu.cqvie.service")
@PropertySource(value="classpath:/application.properties")
//@Import(TestBeanPostProcessor.class)
public class ApplicationConfig {

	@Bean
	public StockService stockService200() {
		return new StockService();
	}

	@Bean
	public String valStr() {
		return "@Bean valStr";
	}
}
