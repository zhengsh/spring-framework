package cn.edu.cqive.mvc.annotation;

/**
 * 请求处理响应 json 参数
 *
 * @author zhengsh
 * @date 2020-11-17
 */
public @interface ResponseBody {
	String value() default "";
}
