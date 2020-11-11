package cn.edu.cqvie.ioc.config;

import cn.edu.cqvie.ioc.annotation.ComponentScan;

/**
 * ioc 扫描范围定义
 *
 * @author zhengsh
 * @date 2020-11-091
 */
@ComponentScan({"cn.edu.cqvie.ioc.service", "cn.edu.cqvie.ioc.processor"})
public class AppConfig {

}
