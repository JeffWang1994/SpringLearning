package com.jeffwang.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

@Configuration
@ComponentScan(basePackages = "com.jeffwang")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

    /**
     * 配置JSP视图解析器
     * @return
     */
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置国际化信息源
     * @return
     */
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    /**
     * 配置Tiles视图解析器
     * @return
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[]{
                "/WEB-INF/layout/tiles.xml" //指定Tile定义的位置
        });
        tiles.setCheckRefresh(true);    // 启动刷新功能
        return tiles;
    }
    @Bean
    public ViewResolver viewResolver(){
        return new TilesViewResolver();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
