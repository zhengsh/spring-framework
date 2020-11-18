package cn.edu.cqive.mvc.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServlet;

public class DispatcherServlet extends HttpServlet {

	private AnnotationConfigApplicationContext ac;

	public DispatcherServlet(AnnotationConfigApplicationContext ac) {
		this.ac = ac;
	}
}
