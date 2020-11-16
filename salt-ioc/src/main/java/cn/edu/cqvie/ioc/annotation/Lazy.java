package cn.edu.cqvie.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ioc 是否懒加载
 *
 * @author zhengsh
 * @date 2020-11-091
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Lazy {

    String value() default "";
}
