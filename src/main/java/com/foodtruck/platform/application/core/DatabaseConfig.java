package com.foodtruck.platform.application.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by narumi12 on 2017. 7. 2..
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="dbsource.food")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSourceTransactionManager getTransactionManager(){
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory.getObject();
    }

    @Bean(destroyMethod="clearCache")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception{
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sessionTemplate;
    }
}
