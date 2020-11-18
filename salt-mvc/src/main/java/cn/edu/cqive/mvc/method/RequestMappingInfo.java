package cn.edu.cqive.mvc.method;

import java.lang.reflect.Method;

/**
 * 请求和映射关系对象
 *
 * @author zhengsh
 * @date 2020-11-18
 */
public class RequestMappingInfo {

	/**
	 * 相对地址
	 */
	private String url;

	/**
	 * 调用的方法信息
	 */
	private Method method;

	/**
	 * 当前类
	 */
	private Object object;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
