package cn.edu.cqive.mvc.servlet;

import cn.edu.cqive.mvc.handler.HandlerMapping;
import cn.edu.cqive.mvc.handler.adapter.HandlerAdapter;
import cn.edu.cqvie.ioc.AnnotationConfigApplicationContext;
import cn.edu.cqvie.ioc.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

/**
 * 事件派发器，servlet
 *
 * @author zhengsh
 * @date 2020-11-18
 */
public class DispatcherServlet extends HttpServlet {

	private Collection<HandlerMapping> handlerMappings;
	private Collection<HandlerAdapter> handlerAdapters;

	private ApplicationContext applicationContext;

	public DispatcherServlet(ApplicationContext applicationContext) {
		//组件的初始化
		this.applicationContext = applicationContext;

		Map<String, HandlerMapping> handlerMappingMaps = applicationContext.getBeansOfType(HandlerMapping.class);
		Map<String, HandlerAdapter> handlerAdapterMaps = applicationContext.getBeansOfType(HandlerAdapter.class);

		handlerMappings = handlerMappingMaps.values();
		handlerAdapters = handlerAdapterMaps.values();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object handleMapping = getHandlerMapping(req);
		if (handleMapping == null) {
			System.out.println("未匹配到对应的 HandlerMapping ");
			return;
		}

		HandlerAdapter handlerAdapter = getHandlerAdapter(handleMapping);
		if (handlerAdapter == null) {
			System.out.println("未匹配到对应的 HandlerAdapter ");
			return;
		}

		Object result = handlerAdapter.handle(req, resp, handleMapping);
		PrintWriter writer = resp.getWriter();
		writer.println(result);
		writer.flush();
		writer.close();
	}

	private HandlerAdapter getHandlerAdapter(Object handleMapping) {
		if (this.handlerAdapters != null) {
			for (HandlerAdapter adapter : this.handlerAdapters) {
				if (adapter.supports(handleMapping)) {
					return adapter;
				}
			}
		}
		return null;

	}

	private Object getHandlerMapping(HttpServletRequest req) {
		if (this.handlerMappings != null) {
			for (HandlerMapping hm : this.handlerMappings) {
				Object handler = hm.getHandlerMapping(req.getRequestURI());
				if (handler != null) {
					return handler;
				}
			}
		}
		return null;
	}
}
