package cn.edu.cqvie.ioc.bean;

/**
 * Bean 初始化信息
 *
 * @author zhengsh
 * @date 2020-11-091
 */
public interface InitializingBean {

    /**
     * 属性集合
     */
    void afterPropertiesSet();
}
