package cn.edu.cqive.mvc;

import cn.edu.cqive.mvc.config.ApplicationConfig;
import cn.edu.cqive.mvc.servlet.DispatcherServlet;
import cn.edu.cqvie.ioc.AnnotationConfigApplicationContext;
import cn.edu.cqvie.ioc.ApplicationContext;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author ZAKJ_ASUS
 */
public class Application {

	public static void main(String[] args) throws InterruptedException, LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9009);
		Context appContext = tomcat.addContext("/",
				"/Users/zhengsh/cqvie.edu.cn/spring-framework/salt-mvc/src/main/webapp");

		ApplicationContext ac =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		tomcat.addServlet(appContext, "dispatcherServlet", new DispatcherServlet(ac));
		tomcat.start();
		tomcat.getServer().wait();
	}
}
