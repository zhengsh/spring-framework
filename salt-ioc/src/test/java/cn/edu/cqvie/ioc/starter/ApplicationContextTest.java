//package cn.edu.cqvie.ioc.starter;
//
//import cn.edu.cqvie.ioc.config.ApplicationConfig;
//import cn.edu.cqvie.ioc.service.GoodsService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
///**
// * 测试 spring
// *
// * @author zhengsh
// * @date 2020-11-14
// */
//public class ApplicationContextTest {
//
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext applicationContext =
//				new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		GoodsService goodsService = applicationContext.getBean("goodsService", GoodsService.class);
//		System.out.println(goodsService);
//	}
//}
