package com.sjj.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 11:19
 */
@EntityScan("com.sjj.study.entity")
@SpringBootApplication
@EnableEurekaClient
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
