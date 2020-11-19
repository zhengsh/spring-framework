package cn.edu.cqvie.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
@Component
public class GoodsService implements InitializingBean, ApplicationContextAware {

	@Autowired
	private StockService stockService;

	public void test() {
		System.out.println("goodsService.test invoker! ");

		stockService.test();
	}

	@PostConstruct
	public void initXxx() {
		System.out.println("初始化 xxx");
	}

	@PreDestroy
	public void destroyXxx() {
		System.out.println("销毁方法 xxx");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化 。。。。。");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("GoodsService ApplicationContextAware");
	}

	public StockService getStockService() {
		return stockService;
	}

	public void setStockService(StockService stockService) {
		System.out.println("GoodsService#setStockService invoke!");
		this.stockService = stockService;
	}

}
