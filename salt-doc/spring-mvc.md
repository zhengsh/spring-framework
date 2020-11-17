
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
