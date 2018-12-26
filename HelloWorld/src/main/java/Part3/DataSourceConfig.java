package Part3;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Created by wangjiangfeng on 2018/12/26.
 */
@Configuration
public class DataSourceConfig {

    @Bean(destroyMethod="shutdown")
    @Profile("dev")
    public DataSource embeddedDataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath=schema.sql")
                .addScript("classpath=test-data.sql")
                .build();
    }

    @Bean
    @Profile("prod")
    public DataSource jndiDataSource(){
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }
}
