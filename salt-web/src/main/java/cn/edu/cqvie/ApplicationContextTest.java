package cn.edu.cqvie;

import cn.edu.cqvie.config.ApplicationConfig;
import cn.edu.cqvie.service.BaseService;
import cn.edu.cqvie.service.GoodsService;
import cn.edu.cqvie.service.StockService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
public class ApplicationContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GoodsService goodsService = applicationContext.getBean("goodsService", GoodsService.class);
		System.out.println(goodsService);

		goodsService.test();

		// bean 的关闭，手动销毁
		applicationContext.close();

		//applicationContext.registerShutdownHook(); // jvm -- hook

		// 通过 @Order 进行排序
		List<BaseService> list = new ArrayList<>();
		list.add(new StockService());
		list.add(new GoodsService());

		list.sort(new AnnotationAwareOrderComparator());
		System.out.println(list);
	}
}
