package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.annotation.Component;
import cn.edu.cqvie.ioc.annotation.ComponentScan;
import cn.edu.cqvie.ioc.annotation.Lazy;
import cn.edu.cqvie.ioc.annotation.Scope;
import cn.edu.cqvie.ioc.bean.BeanDefinition;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * ioc 启动类
 *
 * @author zhengsh
 * @date 2020-11-091
 */
public class IocApplicationContext {

	/**
	 * Bean 定义集合
	 */
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	/**
	 * 单例池
	 */
	private Map<String, Object> singletonObjects = new HashMap<>();

	public IocApplicationContext(Class<?> configClass) {

		//扫描
		scan(configClass);

		//创建非懒加载的单实例bean
		createNonLazySingleton();
	}

	/**
	 * 创建非懒加载的单实例 bean
	 */
	private void createNonLazySingleton() {
		for (String beanName : beanDefinitionMap.keySet()) {
			BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
			if ("singleton".equals(beanDefinition.getScope()) && !beanDefinition.isLazy()) {
				Object bean = createBean(beanDefinition);
				singletonObjects.put(beanName, bean);
			}
		}
	}

	private Object createBean(BeanDefinition beanDefinition) {
		Class<?> beanClass = beanDefinition.getBeanClass();
		try {
			Object instance = beanClass.getDeclaredConstructor().newInstance();
			//todo
			return instance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void scan(Class<?> configClass) {
		if (configClass.isAnnotationPresent(ComponentScan.class)) {
			ComponentScan cs = configClass.getAnnotation(ComponentScan.class);
			for (String path : cs.value()) {
				path = path.replace(".", "/");

				ClassLoader classLoader = this.getClass().getClassLoader();
				URL resource = classLoader.getResource(path);
				assert resource != null;
				File file = new File(resource.getFile());
				for (File f : Objects.requireNonNull(file.listFiles())) {
					String s = f.getAbsolutePath();
					if (s.endsWith(".class")) {
						s = s.substring(s.indexOf("cn"), s.indexOf(".class"));
						s = s.replace("\\", ".");
						System.out.println(s);
					}
					try {
						Class<?> clazz = classLoader.loadClass(s);
						System.out.println(clazz);
						if (clazz.isAnnotationPresent(Component.class)) {

							Component component = clazz.getAnnotation(Component.class);
							String beanName = component.value();
							if ("".equals(beanName)) {
								String fileName = f.getName();
								beanName = fileName.substring(0, 1).toLowerCase() + fileName.substring(1, fileName.indexOf(".class"));
							}

							BeanDefinition beanDefinition = new BeanDefinition();
							beanDefinition.setBeanClass(clazz);
							//这里是一个Bean
							//判断是否是懒加载
							if (clazz.isAnnotationPresent(Lazy.class)) {
								beanDefinition.setLazy(true);
							}
							//是否是单例
							if (clazz.isAnnotationPresent(Scope.class)) {
								Scope scope = clazz.getAnnotation(Scope.class);
								String value = scope.value();
								if (!"".equals(value.trim())) {
									beanDefinition.setScope(value);
								}
								beanDefinition.setScope("singleton");
							} else {
								beanDefinition.setScope("singleton");
							}
							beanDefinitionMap.put(beanName, beanDefinition);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 通过 BeanName 获取 Bean 实例
	 *
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		if (!beanDefinitionMap.containsKey(beanName)) {
			throw new NullPointerException();
		} else {
			BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
			if ("singleton".equals(beanDefinition.getScope())) {
				//单例池
				return singletonObjects.get(beanName);
			} else if ("prototype".equals(beanDefinition.getScope())) {
				return createBean(beanDefinitionMap.get(beanName));
			}
		}
		return null;
	}

}
