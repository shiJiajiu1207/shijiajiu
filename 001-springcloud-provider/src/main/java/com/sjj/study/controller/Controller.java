package com.sjj.study.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: provider
 * @auther: shijiajiu
 * @Date: 2021/01/26 15:07
 */
@RestController
public class Controller {

    @RequestMapping("/get/{name}")
    public String getString(@PathVariable String name){
        return "你好【" + name + "】这里是eureka1";
    }

    @RequestMapping("/service/{name}")
    public String hello(@PathVariable String name){
        return "你好【"+name+"】这里是fergn";
    }

}
