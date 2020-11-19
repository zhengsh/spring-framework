package cn.edu.cqvie.mvc.config;


import cn.edu.cqvie.ioc.annotation.ComponentScan;

/**
 * 应用信息配置
 *
 * @author zhengsh
 */
@ComponentScan({
		"cn.edu.cqvie.mvc.controller",
		"cn.edu.cqvie.mvc.handler",
		"cn.edu.cqvie.mvc.handler.adapter"})
public class ApplicationConfig {
}
