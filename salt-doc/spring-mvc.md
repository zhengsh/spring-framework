# Spring MVC 基础

## servlet 核心类介绍

web 服务器原理

Servlet 生命周期
- init(ServletConfig config)         初始化       
- service(ServletRequest req, ServletResponse res)  处理请求
- destroy()  销毁
    
GenericServlet 是 实现了 Servlet  的一个模板方法类
- 将 ServletConfig 局部变量设置为全局变量
    
HttpServlet 继承了 GenericServlet 
- 针对 http 请求定制的 servlet 可以处理 get/post
- 实现了 service(..) 方法的
- 子类要求 ：doGet、doPost、doPut、doDelete 需要实现一个
- 注意：service 方法不能被重写， 如果上述的4个方法没有被重写的话，就会报 401 或者 405

DispatcherServlet
 -- DefaultServlet （默认缺省的解析）
 -- JspServlet     Jsp

视图解析器：

web.xml 中两组配置的区别：

classpath:   class 路径 （不找jar 包）
classpath*:  class 路径

/*    匹配所有资源，优先级较高
/     匹配所有资源
*.jsp 匹配 jsp 文件后缀的资源

源码分析
1. Servlet 初始化过程
  - tomcat 启动过程 核心类： org.apache.catalina.startup.Tomcat 
  method: addWebapp
  LifecycleListener 监听器: ContextConfig
  StandardServer
  StandardContext 
      Container -> Engine 
  - 模板类 LifecycleBase， 使用模板的类有：StandardServer, StandardService
  - webConfig() 在里面，
  fireLifecycleEvent() 发布监听， 通过监听器将 Servlet 包装成了一个 Wrapper 存入 context 中
  
  - Wrapper 外观模式
  
  - 核心方法: startInternal(); // 启动容器
2. DispatcherServlet 如何工作

Tomcat 的层级

Server  --> Service --> Connector Engine (addChild) --> context (servlet 容器)

## servlet 和 spring 实现简单的 web 框架
1. 目标分析

- 使用内嵌的 tomcat 做为 servlet 容器
- 打开 ioc 扫描， 后置处理器 
    1. @Controller 普通的 bean
    2. 通过映射器，将 url, bean 映射
    3. 实现处理器. Spring mvc 处理
       1. servlet service（） 路径映射  /  if...else...
       2. Controller      handleRequest (Controller 处理器)调用 handleRequest 
       3. HttpRequestHandler handleRequest  (HttpRequestHandler 处理器)调用 handleRequest 
       4. @Controller @RequestMapping(url)方法 反射执行  路由 url, method 反射执行
- 适配器
    统一处理的接口
    判断适配是否成功 Object 处理器 instanceof Controller
    执行处理逻辑    (Controller 处理器) 调用 HttpRequestHandler
- json 数据转换 序列化 @ResponseBody

- 参数绑定 @RequestParam (value )

不加注解， 参数是怎们注入的 默认 asm
    
- 处理器：业务处理器组件 （通常是一个类或者一个方法）实现 url 和资源的映射关系

- SPI 机制
在启动过程中回去扫描特定目录，相对路径（META-INF/services + 接口全限定名): 实现类

- Servlet 3.0 的核心是实现 ServletContainerInitializer ba 调用 onStartup

## Spring 的启动过程和核心类
1. Spring mvc 和 Spring Context
- 子容器可以查找父容器，父容器不能查找子容器

### ContextLoaderListener
1. 

### DispatcherServlet