package single.sugarzh.multi_datasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源配置类
 * */
@Configuration
public class DataSourceConfig {

    //数据源：singleLearnDataSource
    @Bean(name = "singleLearnDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.singlelearn")
    public DataSource singleLearnDataSource(){
        return DataSourceBuilder.create().build();
    }

    //数据源：moreDsDataSource
    @Bean(name = "moreDsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.moreds")
    public DataSource moreDsDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源；通过AOP动态切换不同数据源
     * @return
     * */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(singleLearnDataSource());

        //配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("singleLearnDataSource", singleLearnDataSource());
        dsMap.put("moreDsDataSource", moreDsDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置transactional注解事物
     * @return
     * */
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
