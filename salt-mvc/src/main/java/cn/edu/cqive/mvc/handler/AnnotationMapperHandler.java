package cn.edu.cqive.mvc.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 请求处理绑定 json 参数
 *
 * @author zhengsh
 * @date 2020-11-17
 */
public class AnnotationMapperHandler implements MapperHandler {
	@Override
	public boolean support(Object handler) {
		return false;
	}

	@Override
	public Object handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		return null;
	}
}
