package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.annotation.*;
import cn.edu.cqvie.ioc.aware.BeanNameAware;
import cn.edu.cqvie.ioc.bean.BeanDefinition;
import cn.edu.cqvie.ioc.bean.InitializingBean;
import cn.edu.cqvie.ioc.processor.BeanPostProcessor;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

/**
 * ioc 启动类
 *
 * @author zhengsh
 * @date 2020-11-091
 */
public class AnnotationApplicationContext implements ApplicationContext {

    private Class configClass;
    /**
     * Bean 定义集合
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    /**
     * 单例池
     */
    private Map<String, Object> singletonObjects = new HashMap<>();
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public AnnotationApplicationContext(Class configClass) {
        this.configClass = configClass;

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
                Object bean = createBean(beanDefinition, beanName);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition, String beanName) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Object instance = beanClass.getDeclaredConstructor().newInstance();

            //前置方法
            for (BeanPostProcessor bpp : beanPostProcessors) {
                bpp.postProcessBeforeInitialization(instance, beanName);
            }

            //填充属性
            for (Field field : beanClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    //byType, byName
                    Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }
            //获取 spring 的 beanName 信息
            if (instance instanceof BeanNameAware) {
                BeanNameAware aware = (BeanNameAware) instance;
                aware.setBeanName(beanName);
            }

            //获取 bean 的初始化信息 (一般用来对属性进行验证)
            if (instance instanceof InitializingBean) {
                InitializingBean initializingBean = (InitializingBean) instance;
                initializingBean.afterPropertiesSet();
            }

            //后置方法
            for (BeanPostProcessor bpp : beanPostProcessors) {
                bpp.postProcessAfterInitialization(instance, beanName);
            }
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

    private void scan(Class configClass) {
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan cs = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String[] values = cs.value();
            for (String path : values) {
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
                        Class clazz = classLoader.loadClass(s);
                        System.out.println(clazz);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            //扫描过程中创建 BeanPostProcessor 实例
                            if (clazz.isAssignableFrom(BeanPostProcessor.class)) {
                                BeanPostProcessor beanPostProcessor = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                beanPostProcessors.add(beanPostProcessor);
                            }

                            Component component = (Component) clazz.getAnnotation(Component.class);
                            String beanName = component.value();
                            if ("".equals(beanName)) {
                                beanName = f.getName();
                                beanName = beanName.substring(0, beanName.indexOf(".class"));
                                beanName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
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
                                Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                                String value = scope.value();
                                if (!"".equals(value.trim())) {
                                    beanDefinition.setScope(value);
                                } else {
                                    beanDefinition.setScope("singleton");
                                }
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
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
    @Override
    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new NullPointerException();
        } else {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                //单例池
                Object bean = singletonObjects.get(beanName);
                if (bean == null) {
                    bean = createBean(beanDefinition, beanName);
                    singletonObjects.put(beanName, bean);
                }
                return bean;
            } else if ("prototype".equals(beanDefinition.getScope())) {
                return createBean(beanDefinitionMap.get(beanName), beanName);
            }
        }
        return null;
    }

}
