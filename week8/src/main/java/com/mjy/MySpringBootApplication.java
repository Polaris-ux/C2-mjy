package com.mjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author
 * @description
 * @create 2021-03-29 18:20
 */
@SpringBootApplication
@MapperScan("com.mjy.dao")// mybatis 的注解 把当前包下的类进行管理并 加入IOC容器
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }
}
