package cn.edu.cqvie.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Component
@Order(2)
public class StockService implements BaseService {

	public void test() {
		System.out.println("stockService.test invoker! ");
	}
}
