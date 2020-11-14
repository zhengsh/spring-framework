package cn.edu.cqvie.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Component
public class GoodsService {

	@Autowired
	private StockService stockService;

	public void test() {
		System.out.println("goodsService.test invoker! ");

		stockService.test();
	}
}
