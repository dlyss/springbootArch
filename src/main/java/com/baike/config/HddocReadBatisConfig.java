package com.baike.config;

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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


import javax.sql.DataSource;


/**
 * Created by dongliangyu on 2018/8/15.
 */
@Configuration
@MapperScan(basePackages = "com.baike.mapper.hddoc", sqlSessionTemplateRef = "hddocreadSqlSessionTemplate")
public class HddocReadBatisConfig {
    @Bean(name = "hddocread")
    @ConfigurationProperties(prefix = "spring.datasource.hddocread")
    @Primary
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();

    }

    @Bean(name = "hddocreadSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hddocread") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // sessionFactory.setPlugins(new Interceptor[]{new PageInterceptor()});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/hddoc/*.xml"));
        return sessionFactory.getObject();
    }


    @Bean(name = "hddocreadSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("hddocreadSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
