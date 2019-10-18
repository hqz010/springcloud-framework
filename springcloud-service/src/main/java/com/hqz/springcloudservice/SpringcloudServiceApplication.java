package com.hqz.springcloudservice;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@SpringBootApplication
@RestController
@MapperScan("com.hqz.springcloudservice.dao")
public class SpringcloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceApplication.class, args);
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
