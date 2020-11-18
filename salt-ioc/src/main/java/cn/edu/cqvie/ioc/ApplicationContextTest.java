package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.config.AppConfig;
import cn.edu.cqvie.ioc.service.OrderService;

/**
 * IOC 上下文测试
 *
 * @author zhengsh
 * @date 2020-11-11
 */
public class ApplicationContextTest {

    /**
     * 测试 bean 获取
     */
    public void getBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        System.out.println(orderService);
        orderService.test();
    }
}
