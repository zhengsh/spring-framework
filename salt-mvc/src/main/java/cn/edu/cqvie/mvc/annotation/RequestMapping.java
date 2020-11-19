package cn.edu.cqvie.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求处理
 *
 * @author zhengsh
 * @date 2020-11-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequestMapping {

	/**
	 * 请求地址
	 *
	 * @return
	 */
	String value() default "";

	/**
	 * 请求类型
	 *
	 * @return
	 */
	RequestMethod[] method() default {};
}
