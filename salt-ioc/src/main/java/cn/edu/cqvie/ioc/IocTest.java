package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.config.AppConfig;

public class IocTest {

    public static void main(String[] args) {
        IocApplicationContext applicationContext = new IocApplicationContext(AppConfig.class);
        Object userService = applicationContext.getBean("userService");
        System.out.println(userService);

    }
}
