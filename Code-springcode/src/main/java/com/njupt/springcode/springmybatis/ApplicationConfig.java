package com.njupt.springcode.springmybatis;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author wall
 * @date 2019/7/4  17:15
 * @description
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerConnectionSource driverManagerConnectionSource = new DriverManagerConnectionSource();
        driverManagerConnectionSource.setDriverClass("com.mysql.jdbc.Driver");
        driverManagerConnectionSource.setUser("root");
        driverManagerConnectionSource.setPassword("798657709");
        driverManagerConnectionSource.setUrl("jdbc:mysql://localhost:3306/javajdbctest?characterEncoding=utf-8");
        return (DataSource) driverManagerConnectionSource;
    }
}
