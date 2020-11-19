package cn.edu.cqive.mvc;

import cn.edu.cqive.mvc.config.ApplicationConfig;
import cn.edu.cqive.mvc.servlet.DispatcherServlet;
import cn.edu.cqvie.ioc.AnnotationConfigApplicationContext;
import cn.edu.cqvie.ioc.ApplicationContext;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletContext;

/**
 * @author ZAKJ_ASUS
 */
public class Application {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9090);

		// web应用可以添加绝对目录
		Context context = tomcat.addWebapp("/", "/Users/zhengsh/cqvie.edu.cn/spring-framework/salt-mvc/src/main/webapp");
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Wrapper wrapper = tomcat.addServlet(context, "dispatcherServlet", new DispatcherServlet(ac));
		wrapper.setLoadOnStartup(1);//如果不设置，默认懒加载
		wrapper.addMapping("/");

		tomcat.start();
		tomcat.getServer().await();
	}

}
