package cn.edu.cqvie.mvc.annotation;

import cn.edu.cqvie.ioc.annotation.Component;

import java.lang.annotation.*;

/**
 * mvc bean
 *
 * @author zhengsh
 * @date 2020-11-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Controller {
}
