package cn.edu.cqvie.mvc.handler;


import cn.edu.cqvie.mvc.annotation.Controller;
import cn.edu.cqvie.mvc.annotation.RequestMapping;
import cn.edu.cqvie.mvc.method.RequestMappingInfo;
import cn.edu.cqvie.ioc.annotation.Component;
import cn.edu.cqvie.ioc.processor.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * 请求处理绑定 json 参数
 *
 * @author zhengsh
 * @date 2020-11-17
 */
@Component
public class AnnotationHandlerMapping extends AbstractHandlerMapping implements BeanPostProcessor {

	private static Map<String, RequestMappingInfo> map = new HashMap<>();

	@Override
	public Object getHandlerMapping(String requestURI) {
		return map.get(requestURI);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {

		return null;
	}

	/**
	 * Bean 里面会有多个处理器
	 *
	 * @param bean
	 * @param beanName
	 * @return
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		//1. 首先需要是被 @Controller 修饰
		if (bean.getClass().isAnnotationPresent(Controller.class)) {
			Method[] methods = bean.getClass().getDeclaredMethods();
			for (Method m : methods) {
				RequestMappingInfo rmi = createRequestMappingInfo(m, bean);
				map.put(rmi.getUrl(), rmi);
			}
		}
		return true;
	}

	private RequestMappingInfo createRequestMappingInfo(Method m, Object bean) {
		RequestMappingInfo requestMappingInfo = new RequestMappingInfo();
		if (m.isAnnotationPresent(RequestMapping.class)) {
			requestMappingInfo.setMethod(m);
			requestMappingInfo.setUrl(m.getDeclaredAnnotation(RequestMapping.class).value());
			requestMappingInfo.setObject(bean);
		}
		return requestMappingInfo;
	}
}
