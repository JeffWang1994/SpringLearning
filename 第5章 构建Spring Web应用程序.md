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
    Q：这样看就很清楚，所以DispatchServlet很重要呀～怎么实现呢？
    A：继承 AbstractAnnotationConfig

