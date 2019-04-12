# 第6章 渲染Web视图
    将模型数据渲染为HTML
    使用JSP视图
    通过tiles定义视图布局
    使用Thymeleaf视图

## 6.1 理解视图解析
    > 将控制器中的请求处理的逻辑和视图中的渲染实现解耦是SpringMVC的一个重要特点。
    个人理解：
        其实就是想说，如果我修改了控制器里的model属性，那么就必然要修改HTML。
        实现解耦的过程就是将在HTML和控制器的传递之间，添加一个过渡，JSP。
    实现解耦的重要任务就由Spring视图解析器(ViewResolver)来完成。

    Spring这么高级的东西，肯定内置了很多种视图解析器，用于解决各种情况。
    具体懒得看，现在用不到，用到了再查呗~
    最常用的为：
        1. InternalResourceViewResolver 一般用于解析JSP
        2. TilesViewResolver 一般用于解析Apache Tiles
        3. FreeMarkerViewResolver和VelocityViewResolver 分别对应FreeMarker和Velocity模板视图

## 6.2 创建JSP视图
    1. 配置适用于JSP的视图解析器
    2. 将JSP文件放置在WEB-INF目录下
    配置的方法：见代码。
    配置的主要内容就是加前缀和后缀。

    使用Spring的JSP库
        见表6.2 (记得住算我输)
    主要分为以下几大功能：
        1. 将表单绑定到模型上
        2. 展示错误
        3. 国际化信息
        4. 创建URL

## 6.3 使用Apache Tiles视图定义布局
    1. 配置Tiles视图解析器
        @Bean
        Public TilesConfigurer tilesConfigurer(){
            TilesConfigurer tiles = new TilesConfigurer();
            tiles.setDefinitions(new String[]{
                "/WEB-INF/layout/tiles.xml"     // 定义Tile定义的位置
            });
            tiles.setCheckRefresh(true);    //启动刷新功能
            return tiles;
        }
    2. 定义Tiles
        > Apache Tiles 提供了一个文档类型定义(document type definition, DTD), 用来在XML文件中指定Tile的定义。
        在这个XML文件需要包含一个<definition>元素，这个元素包含多个<put-attribute>元素。

## 6.4 使用Thymeleaf
    要想在Spring中使用Thymeleaf，需要配置三个启动Thymeleaf和Spring集成的bean
        1. ThymeleafViewResolver: 将逻辑视图名称解析成Thymeleaf模板视图
        2. SpringTemplateEngine: 处理模板并渲染结果
        3. TemplateResolver: 加载Thymeleaf模板
        
    