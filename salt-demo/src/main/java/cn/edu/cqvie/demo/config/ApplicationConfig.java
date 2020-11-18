package cn.edu.cqvie.demo.config;

import cn.edu.cqvie.demo.service.StockService;
import org.springframework.context.annotation.*;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Configuration
@ComponentScan("cn.edu.cqvie.demo.service")
//@Import(TestBeanPostProcessor.class)
public class ApplicationConfig {

	@Bean
	public StockService stockService200() {
		return new StockService();
	}
}
