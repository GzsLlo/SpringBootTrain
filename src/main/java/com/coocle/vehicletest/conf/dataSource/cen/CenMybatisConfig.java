/**
 * Copyright 2018 asiainfo Inc.
 **/

package com.coocle.vehicletest.conf.dataSource.cen;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author:jiangchao
 * @CreateDate:2018/10/6
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = {"com.coocle.vehicletest.mapper.cen"}, sqlSessionTemplateRef = "cenSqlSessionTemplate")
public class CenMybatisConfig {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "cen-datasource")
  public DataSource cenDataSource() {
    return DataSourceBuilder.create().build();
  }

  /**
   * cenSqlSessionFactory.
   *
   * @param dataSource
   * @return
   * @throws Exception
   */
  @Bean
  public SqlSessionFactory cenSqlSessionFactory(@Qualifier("cenDataSource") DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    //添加XML目录
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    try {
      bean.setMapperLocations(resolver.getResources("classpath*:mapper/cen/modules/*/*.xml"));
      return bean.getObject();
    } catch (Exception e) {
      logger.error("getResources error = {}", e);
      throw new RuntimeException(e);
    }
  }

  /**
   * cenSqlSessionTemplate.
   *
   * @param sqlSessionFactory
   * @return
   * @throws Exception
   */
  @Bean
  public SqlSessionTemplate cenSqlSessionTemplate
  (@Qualifier("cenSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
    return template;
  }

}

