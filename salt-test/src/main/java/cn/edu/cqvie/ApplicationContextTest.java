package cn.edu.cqvie;

import cn.edu.cqvie.config.ApplicationConfig;
import cn.edu.cqvie.domain.User;
import cn.edu.cqvie.mapper.UserMapper;
import cn.edu.cqvie.service.IGoodsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试 spring
 *
 * @author zhengsh
 * @date 2020-11-14
 */
public class ApplicationContextTest {

	static {
		//该设置用于输出cglib动态代理产生的类
		//System.setProperty(DebuggingCalssWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
		//该设置用于输出jdk动态代理产生的类 默认在com/sun/proxy 目录下
		//System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
	}

	public static void main(String[] args) {

		//1. 场景1, 测试重复刷新
		//AnnotationConfigApplicationContext application =new AnnotationConfigApplicationContext();
		//application.register(ApplicationConfig.class);
		//application.refresh();
		//application.refresh();

		AnnotationConfigApplicationContext application =new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IGoodsService goodsService = application.getBean("goodsService", IGoodsService.class);

		//System.out.println(goodsService);
		//goodsService.test();

		// 场景2. BeanFactory 数据操作
		UserMapper userMapper = application.getBean("userMapper", UserMapper.class);
		userMapper.insert(new User());

		//关闭 ioc 容器
		//application.close();
	}
}
