package com.hqz.springcloudconsumer;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
@EnableFeignClients
@EnableRedisHttpSession
@MapperScan("com.hqz.springcloudconsumer.dao")
public class SpringcloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumerApplication.class, args);
	}

//	@Autowired
//	private Environment env;
//
//	@Bean
//	public DataSource dataSource(){
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.setUrl(env.getProperty("spring.datasource.url"));
//		dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
//		dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
//		dataSource.setInitialSize(2);
//		dataSource.setMaxActive(20);
//		dataSource.setMinIdle(0);
//		dataSource.setMaxWait(60000);
//		dataSource.setValidationQuery("SELECT 1");
//		dataSource.setTestOnBorrow(false);
//		dataSource.setTestWhileIdle(true);
//		dataSource.setPoolPreparedStatements(false);
//		return dataSource;
//	}
}
