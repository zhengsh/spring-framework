package cn.edu.cqive.mvc.config;


import cn.edu.cqvie.ioc.annotation.ComponentScan;

/**
 * 应用信息配置
 *
 * @author zhengsh
 */
@ComponentScan({
		"cn.edu.cqive.mvc.controller",
		"cn.edu.cqive.mvc.handler",
		"cn.edu.cqive.mvc.handler.adapter"})
public class ApplicationConfig {
}
