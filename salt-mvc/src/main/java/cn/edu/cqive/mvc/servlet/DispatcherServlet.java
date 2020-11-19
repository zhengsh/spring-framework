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
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * 事件派发器，servlet
 *
 * @author zhengsh
 * @date 2020-11-18
 */
public class DispatcherServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = -2083503801443301445L;

	private Collection<HandlerMapping> handlerMappings;
	private Collection<HandlerAdapter> handlerAdapters;

	public ApplicationContext applicationContext;

	public DispatcherServlet() {

	}

	public DispatcherServlet(ApplicationContext applicationContext) {
		//组件的初始化
		this.applicationContext = applicationContext;
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
				String uri = req.getRequestURI();
				if (uri != null && uri.length() > 3) { //*.do 结尾所以最少长度为3
					Object handler = hm.getHandlerMapping(uri.substring(0, uri.length() - 3));
					if (handler != null) {
						return handler;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void init() throws ServletException {
		super.init();
		Map<String, HandlerMapping> handlerMappingMaps = applicationContext.getBeansOfType(HandlerMapping.class);
		Map<String, HandlerAdapter> handlerAdapterMaps = applicationContext.getBeansOfType(HandlerAdapter.class);

		handlerMappings = handlerMappingMaps.values();
		handlerAdapters = handlerAdapterMaps.values();

		System.out.println("DispatcherServlet 被加载了 。。。。。。。");
	}
}
