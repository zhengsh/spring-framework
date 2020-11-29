package cn.edu.cqvie;

import cn.edu.cqvie.config.ApplicationConfig;
import cn.edu.cqvie.service.GoodsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
public class ApplicationContextTest {

	public static void main(String[] args) {

		//AnnotationConfigApplicationContext application =new AnnotationConfigApplicationContext();
		//application.register(ApplicationConfig.class);
		//application.refresh();
		//application.refresh();

		AnnotationConfigApplicationContext application =new AnnotationConfigApplicationContext(ApplicationConfig.class);
	    GoodsService goodsService = application.getBean("goodsService", GoodsService.class);
		System.out.println(goodsService);
		goodsService.test();

		//关闭 ioc 容器
		application.close();
	}
}
