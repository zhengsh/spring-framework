package cn.edu.cqive.mvc;

import cn.edu.cqive.mvc.config.ApplicationConfig;
import cn.edu.cqive.mvc.servlet.DispatcherServlet;
import cn.edu.cqvie.ioc.AnnotationConfigApplicationContext;
import cn.edu.cqvie.ioc.ApplicationContext;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 * @author ZAKJ_ASUS
 */
public class Application {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9090);

		// web应用可以添加绝对目录
		tomcat.addWebapp("/","/Users/zhengsh/cqvie.edu.cn/spring-framework/salt-mvc/src/main/webapp");
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DispatcherServlet.applicationContext = ac;

		tomcat.start();
		tomcat.getServer().await();
	}

}
