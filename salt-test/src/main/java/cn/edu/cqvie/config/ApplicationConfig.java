package cn.edu.cqvie.config;

import cn.edu.cqvie.aspect.LogAspect;
import cn.edu.cqvie.service.GoodsService;
import cn.edu.cqvie.service.CoalStockService;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Configuration
@EnableAspectJAutoProxy
@Import({LogAspect.class, MyBatisConfig.class})
@ComponentScan({"cn.edu.cqvie.service", "cn.edu.cqvie.mapper"})
@MapperScan(value = "cn.edu.cqvie.mapper", annotationClass = Mapper.class)
//@PropertySource(value = "classpath:/config.properties")
public class ApplicationConfig {

	// @Bean
	// @Primary
	// @Order(-1)
	public CoalStockService stockService200() {
		return new CoalStockService();
	}

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


	// 基于 Bean 的后置处理器
	// @Bean
	public BeanNameAutoProxyCreator creator() {
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("userService");
		beanNameAutoProxyCreator.setInterceptorNames("myAdvisor");
		return beanNameAutoProxyCreator;
	}

	// 定义了 Advisor 过后  DefaultAdvisorAutoProxyCreator
	// 回自动去查找 BeanPostProcessor
	// @Bean
	public DefaultAdvisorAutoProxyCreator creator1() {
		DefaultAdvisorAutoProxyCreator creator
				= new DefaultAdvisorAutoProxyCreator();
		return creator;
	}

}
