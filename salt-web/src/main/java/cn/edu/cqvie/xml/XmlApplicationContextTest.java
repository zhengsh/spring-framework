package cn.edu.cqvie.xml;

import cn.edu.cqvie.service.GoodsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试 spring xml 方式初始化
 *
 * @author zhengsh
 * @date 2020-11-14
 */
public class XmlApplicationContextTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("classpath:spring.xml");
		GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
		System.out.println(goodsService);

		goodsService.test();
	}
}
