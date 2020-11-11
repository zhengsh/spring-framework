package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.config.AppConfig;
import cn.edu.cqvie.ioc.service.OrderService;
import org.junit.jupiter.api.Test;

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
    @Test
    public void getBean() {
        AnnotationApplicationContext applicationContext = new AnnotationApplicationContext(AppConfig.class);
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        System.out.println(orderService);
        orderService.test();
    }
}
