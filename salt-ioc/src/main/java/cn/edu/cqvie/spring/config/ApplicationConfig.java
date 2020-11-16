package cn.edu.cqvie.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Configuration
@ComponentScan("cn.edu.cqvie.spring.service")
public class ApplicationConfig {
	//@Import(BeanInstantiationAwareBeanPostProcessor.class)
}
