package cn.edu.cqvie.ioc;

/**
 * IOC 上下文
 *
 * @author zhengsh
 * @date 2020-11-11
 */
public interface ApplicationContext {

    /**
     * 通过 beanName 获取 Bean 实例对象
     *
     * @param beanName bean 的名称
     * @return Bean 实例对象
     */
    Object getBean(String beanName);
}
