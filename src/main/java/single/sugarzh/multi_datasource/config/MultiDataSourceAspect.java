package single.sugarzh.multi_datasource.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class MultiDataSourceAspect {

    @Pointcut("@annotation(single.sugarzh.multi_datasource.config.TargetDataSource)")
    public void doDs(){}


    @Before("doDs()")
    public void switchDataSource(JoinPoint jp){
        //获得当前访问的class
        Class<?> className = jp.getTarget().getClass();
        //获得访问的方法名
        String methodName = jp.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)jp.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@TargetDataSource注解
            if (method.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource annotation = method.getAnnotation(TargetDataSource.class);
                // 取出注解中的数据源名
                dataSource = annotation.name();
            }
        } catch (Exception e) {
            log.error("switch datasource failed, "+ e.toString());
        }

        log.info("切换数据源。。。。。");
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("doDs()")
    public void restoreDataSource(JoinPoint jp){
        log.info("释放数据源。。。。。");
        DataSourceContextHolder.clearDB();
    }
}
