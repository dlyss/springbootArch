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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by dongliangyu on 2018/8/15.
 */
@Configuration
@MapperScan(basePackages = "com.baike.mapper.hdcms", sqlSessionTemplateRef = "hdcmsreadSqlSessionTemplate")
public class HdcmsReadBatisConfig {
    @Bean(name = "hdcmsread")
    @ConfigurationProperties(prefix = "spring.datasource.hdcmsread")
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();

    }

    @Bean(name = "hdcmsreadSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("hdcmsread") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // sessionFactory.setPlugins(new Interceptor[]{new PageInterceptor()});
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/hdcms/*.xml"));
        return sessionFactory.getObject();
    }


    @Bean(name = "hdcmsreadSqlSessionTemplate")
    public SqlSessionTemplate setHdcmsSqlSessionTemplate(@Qualifier("hdcmsreadSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
