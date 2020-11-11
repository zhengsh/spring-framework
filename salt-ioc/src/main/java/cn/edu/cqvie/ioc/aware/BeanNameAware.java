package cn.edu.cqvie.ioc.aware;

/**
 * BeanName 设置
 *
 * @author zhengsh
 * @date 2020-11-11
 */
public interface BeanNameAware {

    /**
     * 回传 BeanName
     * @param beanName
     */
    void setBeanName(String beanName);
}
