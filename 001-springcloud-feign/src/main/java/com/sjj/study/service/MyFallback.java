package com.sjj.study.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import com.sjj.study.service.FeignService;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2021/01/28 14:01
 */
@Component
public class MyFallback implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public String hello(String name) {
                return "不好意思【" + name + "】，feign系统出错了,"+throwable.getMessage();
            }
        };
    }
   /* @Override
    public String hello(String name) {
        return "不好意思【" + name + "】，系统出错了";
    }*/
}
