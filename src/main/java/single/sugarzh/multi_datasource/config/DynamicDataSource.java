package single.sugarzh.multi_datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源为："+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
