
DispatcherServlet
 -- DefaultServlet 
 -- JspServlet

视图解析器：

web.xml 中两组配置的区别：

classpath:   class 路径 （不找jar 包）
classpath*:  class 路径

/*    匹配所有资源，优先级较高
/     匹配所有资源
*.jsp 匹配 jsp 文件后缀的资源

源码分析
1. Servlet 初始化过程和
2. DispatcherServlet 如何工作
