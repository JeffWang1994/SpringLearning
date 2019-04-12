# 第7章 Spring MVC的高级技术
    Spring MVC 配置的替代方案
    处理文件上传
    在控制器中处理异常
    使用flash属性

## 7.1 Spring MVC配置的替代方案
    1. 可能遇到的情况1：如果要实现multipart请求和文件上传功能，那就需要Servlet对multipart配置的支持，则需要DispatchServlet的registration来启动multipart请求。
        需要重载customizeRegistration()来设置MultipartConfigElement。
    2. 当你想要注册多个Servlet、Filter、Listener的话，应该怎么办？
        只需要创建一个新的初始化器，实现WebApplicationInitialization接口。
    3. 如果非要用XML配置呢？
        那就在XML配置中，搭建DispatcherServlet和ContextLoaderListener

## 7.2 处理Multipart形式的数据
    主要用于解决用户文件上传问题。
    Multipart格式的数据会将一个表单拆分为多个部分(part)，每个部分对应一个输入域，在一般的表单输入域中，它所对应的部分中会放置文本型数据，如果上传文件就变成了二进制数据。
    1. 配置multipart解析器
        Spring会内置两个MultipartResolver供我们选择：
            1. CommonsMultipartResolver: 使用Jakarta Commons FileUpload 解析 multipart 请求
            2. StandardServletMultipartResolver: 依赖于 Servlet 3.0 对 multipart 请求的支持 (优先选择这个！)
    
