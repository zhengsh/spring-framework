package cn.edu.cqvie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
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
public class GoodsService implements IGoodsService {

	@Qualifier("coalStockService")
	@Autowired
	private IStockService stockService;

	//@Lazy
	//@Qualifier("valStr")
	//@Autowired(required = true)
	@Value("${test.val}")
	private String valStr;

	private IStockService stockService200;

	//@Qualifier("stockService200")
	//@Autowired
	public void setStockService200(IStockService stockService200) {
		this.stockService200 = stockService200;
	}

	public GoodsService() {
	}

	@Override
	public void test() {
		System.out.println("goodsService.test invoker! ");
		System.out.println("goodsService.test valStr! " + valStr);
		stockService.test();
	}

	/**
	 * 初始化方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("int invoke!");
	}

	/**
	 * 销毁方法方法
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("destroy invoke!");
	}
}
