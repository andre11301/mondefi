package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**

 *  start  Stringboot

 * @author andre

 * @Time 2018/10/29

 *

 */

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan(basePackages = "com.dao")
@EnableTransactionManagement
public class SpringbootWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootWebApplication.class, args);
    }
}
