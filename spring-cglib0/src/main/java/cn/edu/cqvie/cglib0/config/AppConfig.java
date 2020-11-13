package cn.edu.cqvie.cglib0.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhengsh
 */
@ComponentScan({"cn.edu.cqvie.cglib0.service","cn.edu.cqvie.cglib0.beans.factory"})
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
}
