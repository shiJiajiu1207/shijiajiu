package com.sjj.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2021/01/28 10:37
 */
@FeignClient(value = "001-SPRINGCLOUD-PROVIDER",fallbackFactory = MyFallback.class)
public interface FeignService {

    @RequestMapping("/service/{name}")
    String hello(@PathVariable String name);

}
