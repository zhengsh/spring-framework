package cn.edu.cqive.mvc.handler.adapter;

import cn.edu.cqive.mvc.annotation.RequestBody;
import cn.edu.cqive.mvc.annotation.RequestParam;
import cn.edu.cqive.mvc.annotation.ResponseBody;
import cn.edu.cqive.mvc.method.RequestMappingInfo;
import cn.edu.cqvie.ioc.annotation.Component;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * 事件适配器
 *
 * @author zhengsh
 * @date 2020-11-18
 */
@Component
public class AnnotationMapperHandlerAdapter extends AbstractMapperHandlerAdapter {

	/**
	 * 检查是否支持
	 *
	 * @param handler
	 * @return
	 */
	@Override
	public boolean supports(Object handler) {
		return handler instanceof RequestMappingInfo;
	}

	/**
	 * 参数绑定
	 *
	 * @param request
	 * @param response
	 * @param object
	 * @return
	 */
	@Override
	public Object handle(HttpServletRequest request, HttpServletResponse response, Object object) {
		RequestMappingInfo rmi = (RequestMappingInfo) object;
		// 获取携带的参数
		Map<String, String[]> paramMap = request.getParameterMap();
		Method method = rmi.getMethod();
		// 获取方法参数
		Parameter[] parameters = method.getParameters();

		Object[] params = new Object[method.getParameterTypes().length];
		for (int i = 0; i < parameters.length; i++) {
			for (Map.Entry<String, String[]> e : paramMap.entrySet()) {
				if (e.getKey() == null) {
					continue;
				}
				//检查参数绑定是否匹配
				if (parameters[i].getAnnotation(RequestParam.class) != null
						&& e.getKey().equals(parameters[i].getAnnotation(RequestParam.class).value())) {
					params[i] = e.getValue()[0];
					//jdk1.8 通过反射获取方法名, 之前的版本通过 asm 实现
				} else if (e.getKey().equals(parameters[i].getName())) {
					params[i] = e.getValue()[0];
				}

				//todo @RequestBody
			}

			//绑定 request, response
			if (ServletRequest.class.isAssignableFrom(parameters[i].getType())) {
				params[i] = request;
			}
			if (ServletResponse.class.isAssignableFrom(parameters[i].getType())) {
				params[i] = response;
			}
		}
		try {
			Object result = method.invoke(rmi.getObject(), params);

			//转发到json
			if (result instanceof String) {
				if (((String) result).startsWith("forward:")) {
					request.getRequestDispatcher(((String) result).split(":")[1]).forward(request, response);
				} else {
					response.sendRedirect(((String) result).split(":")[1]);
				}
			} else {
				//如果被 @RequestBody 修饰，那么就返回 json 即对返回参数进行序列化
				if (method.isAnnotationPresent(ResponseBody.class)) {
					return JSON.toJSONString(result);
				}
			}
			return result;
		} catch (IllegalAccessException | ServletException | IOException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
