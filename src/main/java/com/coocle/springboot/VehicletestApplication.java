package com.coocle.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching //允许缓存
@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,//排除springBoot的默认数据源配置
    RedisAutoConfiguration.class,//排除springBoot的默认Redis配置
    RedisRepositoriesAutoConfiguration.class//排除springBoot的默认Redis配置
})
@MapperScan("com.coocle.springboot.mapper")
@ComponentScan({"com.coocle.springboot"})
public class VehicletestApplication {

  public static void main(String[] args) {
    SpringApplication.run(VehicletestApplication.class, args);
  }
}
