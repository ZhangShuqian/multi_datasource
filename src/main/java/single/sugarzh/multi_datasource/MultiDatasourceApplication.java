package single.sugarzh.multi_datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * 禁用springboot默认加载的application.properties单数据源配置
 * */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MultiDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class, args);
    }

}
