package com.sjj.study;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 11:19
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(Application.class,args);
    }
}
