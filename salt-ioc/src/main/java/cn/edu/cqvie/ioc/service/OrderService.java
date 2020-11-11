package cn.edu.cqvie.ioc.service;

import cn.edu.cqvie.ioc.annotation.Autowired;
import cn.edu.cqvie.ioc.annotation.Component;
import cn.edu.cqvie.ioc.aware.BeanNameAware;
import cn.edu.cqvie.ioc.bean.InitializingBean;
import cn.edu.cqvie.ioc.service.UserService;

/**
 * 订单业务
 *
 * @author zhengsh
 * @date 2020-11-091
 */
@Component
public class OrderService implements BeanNameAware, InitializingBean {

    @Autowired
    private UserService userService;
    private String beanName;

    public void test() {
        userService.test();
        System.out.println("order test");
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        //验证 bean 信息
        if (userService == null) {
            System.out.println("userService is null");
        }
    }
}
