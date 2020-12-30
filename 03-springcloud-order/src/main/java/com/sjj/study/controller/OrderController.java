package com.sjj.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sjj.study.service.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sjj.study.entity.Product;

import java.util.List;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 11:02
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductFeignClient productFeignClient;

    /*@Autowired
    private RestTemplate restTemplate;*/

    /**
     * 注入DiscoveryClient :
     *  springcloud提供的获取原数组的工具类
     *      调用方法获取服务的元数据信息
     *
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "orderFallBack")
    @RequestMapping("/{id}")
    public Product insertOrder(@PathVariable Long id){

        //List<ServiceInstance> instances = discoveryClient.getInstances("01-SPRINGCLOUD-PRODUCT");
        //ServiceInstance instance = instances.get(0);

        Product product = productFeignClient.findById(id);
        return product;
    }

    /**
     * 服务降级
     */
    public Product orderFallBack(Long id){
        Product product = new Product();
        product.setProductName("服务降级回调");
        return product;
    }

   /* @RequestMapping("/{id}")
    public Product insertOrder(@PathVariable Long id){

        List<ServiceInstance> instances = discoveryClient.getInstances("01-SPRINGCLOUD-PRODUCT");
        ServiceInstance instance = instances.get(0);

        Product product = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+id, Product.class);
        return product;
    }*/

}
