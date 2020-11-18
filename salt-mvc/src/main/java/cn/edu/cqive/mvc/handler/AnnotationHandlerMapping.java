package cn.edu.cqive.mvc.handler;


import cn.edu.cqvie.ioc.annotation.Component;
import cn.edu.cqvie.ioc.processor.BeanPostProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 请求处理绑定 json 参数
 *
 * @author zhengsh
 * @date 2020-11-17
 */
@Component
public class AnnotationHandlerMapping extends AbstractHandlerMapping implements BeanPostProcessor {

	@Override
	public Object getHandlerMapping(String requestURI) {
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		if (bean.)
		return null;
	}
}
