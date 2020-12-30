package com.sjj.study.service;

import com.sjj.study.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/21 11:25
 */
@FeignClient(name = "01-SPRINGCLOUD-PRODUCT")
public interface ProductFeignClient {

    @RequestMapping(value = "/product/{id}")
    Product findById(@PathVariable("id") Long id);

}
