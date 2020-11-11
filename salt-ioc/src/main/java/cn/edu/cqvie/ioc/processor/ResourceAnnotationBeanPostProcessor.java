package cn.edu.cqvie.ioc.processor;

import cn.edu.cqvie.ioc.annotation.Component;

/**
 * bean 的后置处理器
 *
 * @author zhengsh
 * @date 2020-11-11
 */
@Component
public class ResourceAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Resource Before Initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Resource After Initialization");
        return bean;
    }
}
