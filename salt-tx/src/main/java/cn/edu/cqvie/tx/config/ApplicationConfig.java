package cn.edu.cqvie.tx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 应用配置
 *
 * @author zhengsh
 * @date 2020-11-13
 */
@Configuration
@ComponentScan(basePackages = "cn.edu.cqvie.tx.service")
public class ApplicationConfig {
}
