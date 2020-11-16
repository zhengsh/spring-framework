package cn.edu.cqvie.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier("stockService")
	private StockService stockService;

	public GoodsService() {
	}


	public StockService getStockService() {
		return stockService;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public void test() {
		//stockService.test();
		System.out.println("goods test method invoke!");
		System.out.println(stockService);
	}
}
