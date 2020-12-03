package cn.edu.cqvie.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * 饮料库存
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Component
@Order(1)
public class DrinkStockService implements IStockService {

	public DrinkStockService() {
		System.out.println("DrinkStockService 被加载了 。。。。。。。" );
	}

	@Override
	public void test() {
		System.out.println("stockService.test invoker! ");
	}
}
