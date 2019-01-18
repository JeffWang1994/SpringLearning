package Part3;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Created by wangjiangfeng on 2018/12/26.
 */
@Configuration
@Profile("dev")
public class DevelopmentProfileConfig {

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath=schema.sql")
                .addScript("classpath=test-data.sql")
                .build();
    }
}
