package com.springboot.datasources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by L.Answer on 2018-12-07 10:06
 */
@Configuration
//@Import({DataSourceAutoConfiguration.class,PagePlugin.class})
@MapperScan(basePackages = "com.springboot.datasources.dao.db2", sqlSessionTemplateRef  = "db2SqlSessionTemplate")
public class DataSource2Config {

//    @Autowired
//    private PagePlugin pagePlugin;

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "answer.datasources.db2")
    public DataSource dbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory xwSqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        // 设置分页插件
//        bean.setPlugins(new Interceptor[]{pagePlugin});
        // 设置配置文件
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:/mybatis/mybatis-config.xml"));
        // 设置mapper映射文件
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db2/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager xwTransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate xwSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}