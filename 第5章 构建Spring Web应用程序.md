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
## Sorry,这么就没有更新，因为这本书中的Spittr，我一直没有跑通～编译成功，但是无法登陆localhost:8080/spittr/
>>>>>>> 13ce8387fbc87cf3567ec9a00ef2b9149f4ba161

=======
## 2019-1-18 我终于跑通了，也找到了问题所在。非常愚蠢的错误。使用intelliJ这个非常智能的IDE会自动帮你配置好了web.xml。而该xml配置与WebApplicationInitial中如果不同的话，会出现OneorMoreListener的错误。总之跑通了...

### 个人理解
    Q：如何搭建SpringMVC？
    A：搭建SpringMVC就好像搭桥连接三个岛。
    1. 要建立好中枢连接点, DispatcherServlet.
        在WebAppInitializer.java中，设置getServletMappings()，这是将URL路径(比如"/","/login")映射到DispatcerServlet上。
        然后，配置两套配置类。
        getRootConfigClasses()和getServletConfigClasses()。
        RootConfig用于配置ContextLoaderListener创建的上下文中的用于驱动中间层和数据层的Bean。
        ServletConfig用于配置DispatcherServlet应用上下文中的Bean。
1. 配置WebConfig---其中包含视图解析器.
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
   1. 建立后端的岛——控制器Controller.
    > 控制器只是方法上加了@RequestMapping注解的类。
        所以最简单的控制器编写就是POJO，最后在类和方法上加注解:
            @Controller
            @RequestMapping(value="/", method=GET) 
   2. 建立前端的岛---视图JSP.
        正常编写你想要的视图页面。

## 输出模型数据
   1. 定义模型数据类
    Spittle类: 包含消息内容、时间戳和位置信息。
   2. 定义一个数据访问的Repository。这个功能是获取Spittle列表。
    可以调用SpittleRepostory接口，实现一个简单的类。
   3. 定义SpittleController
      1. 类上声明@Controller
      2. 构造器上声明@Autowired。注入SpittleRepository。
      3. spittles方法上声明@RequestMapping("/spittles")。在方法中把spittle添加到模型中。
      4. return "spittles"返回视图名

## 输入请求数据
    从客户端传输到服务器只有三种数据类型：
       1. 查询参数(Query Parameter)
       2. 表单参数(Form Parameter)
       3. 路径变量(Path Variable)
### 查询参数
    任务内容：Spittle分页。下一页的功能；前往指定页的功能。
    需要传输的参数为：before参数; count参数
    1. 在Controller里，添加新的方法。@RequestMapping(...)
    2. 该方法的输入参数加入从客户端传入的参数并标记上@RequestParam(value="",defaultValue=..) long max,
### 路径变量
    任务内容：根据给定的ID来展现某一个Spittle记录。
    1. 需要将SpittleController中spittle方法的输入参数中加入
        @PathVariable("SpittleID") long spittleID
        Model model
    2. 在根据传入的spittleID去spittleRepository中查找相应的spittle，并添加到Model中
    3. 最后将model发送到指定的jsp中。
        return "spittle"
### 表单参数
    任务内容：提供用户注册页面，传入用户注册信息，并根据用户名返回用户注册信息。
    这里涉及3件事情。一个一个来。
    1. 提供用户注册页面，大约等同于home页面的制作。
    2. 传入用户注册信息
       1. 由于是传入，就不是GET了，而是POST。
            @RequestMapping(value="/register", method=POST)
       2. 调用spitterRepository.save()方法，将注册信息保存起来。
       3. 重定向指定页面: return "redirect:/spitter/"+spitter.getUsername();
    3. 返回用户注册信息
       1. 由于是传出，就应该是GET
            @RequestMapping(value="/{username}", method=GET)
       2. 在spitterRepository中根据username查找出刚存入的注册用户信息。
       3. 将model发送到指定的jsp中。
            return "profile"
### 传入参数校验
    为了校验用户在填写表单时的参数正确性，spring给出一套简单的校验注释。
    只需要在需要校验的变量上标上@NotNull,@Size等等就可以进行校验。
    具体可以看书上表5.1

# 这一章就结束了。总的来说，书中只描述了部分代码，要想实验spittr，需要自己补充。实现了Spittr的基本功能，查询显示库内的spittle信息，用户注册和查询用户信息等功能，作为一个好开头吧～





