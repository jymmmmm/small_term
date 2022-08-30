package utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:h2datasource.properties")
@Profile("default")
public class H2DataSourceConfig {

    @Autowired
    Environment environment;

    /**
     * 定义数据源
     *
     * @return
     */
    @Bean
    DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(this.environment.getProperty("jdbc.url"));
        dataSourceBuilder.username(this.environment.getProperty("jdbc.user"));
        dataSourceBuilder.password(this.environment.getProperty("jdbc.password"));
        return dataSourceBuilder.build();
    }
}
