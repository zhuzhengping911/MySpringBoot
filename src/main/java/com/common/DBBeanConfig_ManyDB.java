package com.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by zhuzhengping on 2017/3/8.
 * 多数据源配置
 * 注意datasource的import
 */
@Configuration
@EnableTransactionManagement
public class DBBeanConfig_ManyDB {

    @Bean(name = "oneDataSource")
    @Qualifier("oneDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource oneDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "twoDataSource")
    @Qualifier("twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource twoDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oneJdbcTemplate")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "twoJdbcTemplate")
    public JdbcTemplate twoJdbcTemplate(@Qualifier("twoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
