
# Spring 深入解析Spring

## Spring Ioc 的简单实现

## Spring 的核心概念(一)

## Spring 的核心概念(二)
ApplicationContext#getBean 方法
* 通过 beanName 或者 beanType 获取 bean 实例

InstantiationAwareBeanPostProcessor

## Spring 的依赖注入
1. Spring 的几种注入方法
- 手动注入
  * setter 注入
  * 构造方法注入
- 自动注入
  * xml 自动注入
  * @Autowired 自动注入
    set 方法
    属性
    构造方法

注入的话，其实也是对象的初始化

2. AutowiredAnnotationBeanPostProcessor 解析
