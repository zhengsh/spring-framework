package cn.edu.cqvie.ioc.processor;

/**
 * Bean 增强器
 *
 * @author zhengsh
 * @date 2020-11-11
 */
public interface BeanPostProcessor {
    /**
     * 前置初始化方法
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 后置初始化方法
     *
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);

}
