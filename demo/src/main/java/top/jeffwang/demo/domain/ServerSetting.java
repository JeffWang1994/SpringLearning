package top.jeffwang.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 服务器配置
// 实体类配置
@Component
@PropertySource({"classpath:resource.properties"})
@ConfigurationProperties(prefix = "test")
public class ServerSetting {

    //名称
    //@Value("${name}")
    private String name;

    //域名
    //@Value("${domain}")
    private String domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public ServerSetting(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }
}
