package com.sjj.study.controller;

import com.netflix.appinfo.InstanceInfo;


//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2021/01/26 15:25
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/consumer/{name}")
    public String getString(@PathVariable String name){

        ServiceInstance instance = discoveryClient.getInstances("001-SPRINGCLOUD-PROVIDER").get(0);

//        return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/get/shijiajiu", String.class);
        return restTemplate.getForObject("http://001-SPRINGCLOUD-PROVIDER/get/shijiajiu", String.class);
    }

    public String error(){
        return "出错了";
    }

}
