package com.sjj.study.controller;

import com.sjj.study.service.FeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2021/01/28 13:49
 */
@RestController
public class FeignController {

    @Resource
    FeignService feignService;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return feignService.hello(name);
    }
}
