package cn.edu.cqive.mvc.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 * 请求处理
 *
 * @author zhengsh
 * @date 2020-11-17
 */
public @interface RequestMapping {

	/**
	 * 请求地址
	 *
	 * @return
	 */
	@AliasFor("path")
	String value() default "";

	/**
	 * 请求类型
	 *
	 * @return
	 */
	RequestMethod[] method() default {};
}
