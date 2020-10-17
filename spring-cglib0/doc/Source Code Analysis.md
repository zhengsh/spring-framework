Spring 源码分析

Spring 5.1.x 

1.Spring 是什么？

Spring 框架

1.1 Spring 的特征
1.核心技术：依赖注入、事件处理
2.测试：
3.数据访问：
4.Sping MVC 和Spring WebFlux Web 框架
5.集成：
6.支持多种语言：Kotlin , Groovy

1.2 Spring  核心技术
控制反转、和 AOP  是 Spring 提供的两大核心技术
1.2.1 Spring IOC 和Bean 简介
控制反转（IoC）的Spring 框架，IoC 也可以称作依赖注入 DI , 在这个过程中通过构造函数参数，工厂方法的参数或者在对象实例构造或则从工厂方法返回后再对象实例属性上设置的属性来定义他们的依赖项（即他们使用的其他都西昂），然后容器在创建Bean的过程中去设置 注入的依赖项。这个过程基本上与 Bean 本身相反（因此称为控制反转），它使用类的直接构造或者服务定位模式等机智来控制其依赖项的实例化或者位置。
在 org.springframework.beans 和 org.springframework.context 包是 Spring 框架的 ioc 容器的基础。该 BeanFactory 界面提供了一种高级配置机制能够管理任何类型的对象 ApplicationContext 的子接口 BeanFactory 。 它增加了：
与Spring的Aop共嗯那个的轻松集成
消息资源处理（用于国际化）
消息发布
应用层特定的上下文，例如：WebApplicationContext用于Web应用程序中。
简而言之，BeanFactory 提供了配置框架的基本功能，并且 ApplicationContext 增加了更多针对企业的功能。 该ApplicationContext 一个完整的 BeanFactory 的超集， 并且在 Spring ioc 容器描述本章独占使用，有关详细的 BeanFactory, 而不是 ApplicationContext ， 看到的 beanFactory。
在Spring 中，够称应用程序主干并且由 Spring IoC 容器管理的对象称为 Bean，Bean 是由 Spring Ioc 容器实例化，组装和管理的都西昂，否则，Bean 仅仅是应用程序中许多对象之一，Bean 以及其之间的依赖关系反映在容器使用的配置元数据中。
