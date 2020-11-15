package cn.edu.cqvie.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Configuration
@ComponentScan("cn.edu.cqvie.spring.service")
@Import(TestBeanPostProcessor.class)
public class ApplicationConfig {
}
