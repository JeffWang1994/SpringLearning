# 第5章 构建Spring Web应用程序
    Spring MVC  
    映射请求到Spring控制器  
    透明地绑定表单参数  
    校验表单提交  

## 5.1 Spring MVC
    Q：什么Spring MVC ？
    A：Spring MVC (Model, View, Controller).
        Spring将web的框架变成一个足球运动，将<请求>在调度Servlet(Dispatcher Servlet), 处理器映射(Handler Mapping)，控制器(Controller)和视图解析器(View Resolver)之间移动.
    Q：这么复杂的运动是怎么样的呢？
    A：1. <请求>离开浏览器，带着URL和参数，到达DispatcherServlet(在我看来就是一个路由)
       2. DispatcherServlet的任务就是将<请求>发送给 Controller。这个Controller 是用户自己写的，主要用于处理请求。那么调度Servlet发给谁，就需要处理器映射(Handler Mapping)。Handler Mapping根据URL来确定下一站是哪个Controller。
       3. Controller收到<请求>之后，卸下<请求>的负载(用户提交的表单信息等), 业务逻辑处理
       4. Controller的业务逻辑处理完之后，就会产生<模型(model)>，并将<模型和视图名>打包发送给DispatcherServlet。此处为什么不直接将模型和视图绑在一起，为了松耦合。
       5. DispatcherServlet又会把<模型和视图名>发给视图解析器(view resolver)，视图解析器会将逻辑视图名匹配一个特定的视图实现, JSP。
       6. 最后DispatcherServlet就把视图的实现(JSP)发送给浏览器。
    Q：如此复杂的结构，能否精简一点？
    A：个人理解：Spring围绕着DispatchServlet有三条路。
        1. 第一条路：客户端浏览器<-->DispatchServlet. -->传入<请求>, <--传出<视图>
        2. 第二条路：Controller<-->DispatchServlet. -->传入<模型>, <--传出<请求>
        3. 第三条路：视图解析器<-->DispatchServlet. -->传入<视图>, <--传出<模型>
=======
### 个人理解
Q：如何搭建SpringMVC？
A：搭建SpringMVC就好像搭桥连接三个岛。
1. 要建立好中枢连接点, DispatcherServlet.
        在WebAppInitializer.java中，设置getServletMappings()，这是将URL路径(比如"/","/login")映射到DispatcerServlet上。
        然后，配置两套配置类。
        getRootConfigClasses()和getServletConfigClasses()。
        RootConfig用于配置ContextLoaderListener创建的上下文中的用于驱动中间层和数据层的Bean。
        ServletConfig用于配置DispatcherServlet应用上下文中的Bean。
2. 配置WebConfig---其中包含视图解析器.
    1. 启动Spring MVC @Configuration + @EnableWebMvc
    2. 启动组件扫描 @ComponentScan("spittr.web")
    3. 配置JSP视图解析器 InternalResourceViewResolver()
        1. resolver.setPrefix("JSP在哪个文件夹下")
        2. resolver.setSuffix(".jsp")
       3. setExposeContextBeansAsAttributes(ture)
       4. return resolver
    4. 配置静态资源的处理 DefaultServletHandlerCondigurer
        对静态资源的请求会转发到Servlet容器的默认Servlet上。
    配置RootConfig
        启动组件扫描 @Configuration + @ComponentScan(...)
        这个以后再说，这里不是重点。
3. 建立后端的岛——控制器Controller.
    > 控制器只是方法上加了@RequestMapping注解的类。
    所以最简单的控制器编写就是POJO，最后在类和方法上加注解:
        @Controller
        @RequestMapping(value="/", method=GET) 
4. 建立前端的岛---视图JSP.
    正常编写你想要的视图页面。



## Sorry,这么就没有更新，因为这本书中的Spittr，我一直没有跑通～编译成功，但是无法登陆localhost:8080/spittr/
>>>>>>> 13ce8387fbc87cf3567ec9a00ef2b9149f4ba161
