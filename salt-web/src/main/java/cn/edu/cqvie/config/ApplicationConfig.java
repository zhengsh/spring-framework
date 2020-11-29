package cn.edu.cqvie.config;

import cn.edu.cqvie.service.GoodsService;
import cn.edu.cqvie.service.CoalStockService;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Configuration
@ComponentScan({"cn.edu.cqvie.service"})
@PropertySource(value = "classpath:/application.properties")
public class ApplicationConfig {

//	@Bean
//	//@Primary
//	@Order(-1)
//	public CoalStockService stockService200() {
//		return new CoalStockService();
//	}

	@Bean
	public CoalStockService coalStockService() {
		return new CoalStockService();
	}

	@Bean
	public String valStr() {
		return "@Bean valStr";
	}

	@Bean
	public String valStr2() {
		return "@Bean valStr2";
	}

	@Bean
	public GoodsService goodsService() {
		return new GoodsService();
	}

}
