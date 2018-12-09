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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by L.Answer on 2018-12-07 10:06
 */
// 表明这个类为一个配置类
@Configuration
// 配置 mybatis 的接口类放的包路径
@MapperScan(basePackages = "com.springboot.datasources.dao.db1", sqlSessionTemplateRef  = "db1SqlSessionTemplate")
public class DataSource1Config {

    @Bean(name = "db1DataSource")
    // 读取 application.properties 中的配置参数映射成为一个对象, prefix表示参数的前缀
    @ConfigurationProperties(prefix = "answer.datasources.db1")
    // 表示这个数据源是默认数据源
    @Primary
    public DataSource dbDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "db1SqlSessionFactory")
    @Primary
    // @Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory xwSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置配置文件
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:/mybatis/mybatis-config.xml"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db1/*.xml"));
        return bean.getObject();
    }



    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager xwTransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }



    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate xwSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}