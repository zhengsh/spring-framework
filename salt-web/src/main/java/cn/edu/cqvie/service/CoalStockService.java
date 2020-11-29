package cn.edu.cqvie.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 汽车库存
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Component
@Order(2) //控制组件的加载顺序
public class CoalStockService implements IStockService {

	public CoalStockService() {
		System.out.println("CoalStockService 被加载了 。。。。。。。" );
	}

	@Override
	public void test() {
		System.out.println("stockService.test invoker! ");
	}
}
