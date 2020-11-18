package cn.edu.cqive.mvc;

import cn.edu.cqive.mvc.config.ApplicationConfig;
import cn.edu.cqive.mvc.servlet.DispatcherServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MvcStart {

	public static void main(String[] args) throws InterruptedException, LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9009);
		Context appContext = tomcat.addContext("/",
				"/Users/zhengsh/cqvie.edu.cn/spring-framework/salt-mvc/src/main/webapp");

		AnnotationConfigApplicationContext ac =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		tomcat.addServlet(appContext, "dispatcherServlet", new DispatcherServlet(ac));
		tomcat.start();
		tomcat.getServer().wait();
	}
}
