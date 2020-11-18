package cn.edu.cqive.mvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MapperHandler {

	/**
	 * 判断逻辑，是否支持当前适配器
	 *
	 * @param handler
	 * @return
	 */
	boolean support(Object handler);

	/**
	 * 处理逻辑，通过适配器来实现
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 */
	Object handle(HttpServletRequest request, HttpServletResponse response, Object handler);
}
