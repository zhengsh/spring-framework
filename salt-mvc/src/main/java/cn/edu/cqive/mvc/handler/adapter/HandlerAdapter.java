package cn.edu.cqive.mvc.handler.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 事件适配器接口
 *
 * @author zhengsh
 * @date 2020-11-18
 */
public interface HandlerAdapter {

	/**
	 * 判断是否支持
	 *
	 * @param handler
	 * @return
	 */
	boolean supports(Object handler);

	/**
	 * 处理方法
	 *
	 * @param request
	 * @param response
	 * @param object
	 * @return
	 */
	Object handle(HttpServletRequest request, HttpServletResponse response, Object object);

}
