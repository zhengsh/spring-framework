package cn.edu.cqvie.cglib0.test;

import cn.edu.cqvie.cglib0.domain.Dog;
import cn.edu.cqvie.cglib0.domain.Tom;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * IOC 测试
 *
 * @author zhengsh
 */
public class IocTest {

	public static void main(String[] args) {

		//通过 BeanDefinition API 来进行 Bean 的声明
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		//1. BeanDefinition注册bean
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(Dog.class);
		beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		applicationContext.registerBeanDefinition("d", beanDefinition);

		applicationContext.refresh();//刷新容器
		System.out.println(applicationContext.getBean("d"));

		//2.AnnotatedBeanDefinitionReader 注册 bean
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(applicationContext);
		reader.register(Tom.class);
		System.out.println(applicationContext.getBean("tom"));

		//3.XmlBeanDefinitionReader 通过 xml 定义 bean

		//4. ClassPathBeanDefinitionScanner 通过包名扫描 bean 信息
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(applicationContext);
		scanner.scan("cn.edu.cqvie.cglib0.service");

		//applicationContext.refresh();//刷新容器
		System.out.println(applicationContext.getBean("dogService"));

	}
}
