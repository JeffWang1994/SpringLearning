package top.jeffwang.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ServletComponentScan
@MapperScan("top.jeffwang.demo.mapper")
public class DemoApplication {

    // 正常启动
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // 使用war包启动
    // 类需要继承extends SpringBootServletinitializer
    // @Override
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
    //      return application.sources(DemoApplication.class);
    //  }
    // public static void main(String[] args) throws Exception {
    //      SpringApplication.run(DemoApplication.class, args);
    //  }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
                factory.setMaxFileSize(DataSize.of(10240, DataUnit.MEGABYTES));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(1024000));
        return factory.createMultipartConfig();
    }

}
