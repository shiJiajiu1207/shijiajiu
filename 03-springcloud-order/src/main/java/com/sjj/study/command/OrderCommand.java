//package com.sjj.study.command;
//
//import com.netflix.hystrix.*;
//import com.netflix.ribbon.proxy.annotation.Hystrix;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @Description:
// * @auther: shijiajiu
// * @Date: 2020/07/29 10:13
// */
//public class OrderCommand extends HystrixCommand<String> {
//    private RestTemplate restTemplate;
//    private Long id;
//
//    public OrderCommand(RestTemplate restTemplate, Long id) {
//        super(setter());
//        this.restTemplate = restTemplate;
//        this.id = id;
//    }
//
//    /*private static Setter setter() {
//        // 服务分组
//        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("order_product");
//        // 服务标识
//        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("product");
//        // 线程池名称
//        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("order_product_pool");
//
//        *//** 线程池配置
//         * withCoreSize : 线程池大小为10
//         * withKeepAliveTimeMinutes: 线程存活时间15秒
//         * withQueueSizeRejectionThreshold :队列等待的阈值为100
//         * 超过100执行拒绝 策略*//*
//
//        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter().
//                withCoreSize(50)
//                .withKeepAliveTimeMinutes(15).withQueueSizeRejectionThreshold(100);
//        // 命令属性配置Hystrix 开启超时
//        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrat egy.THREAD)
//                .withExecutionTimeoutEnabled(false);
//
//
//        return HystrixCommand.Setter.withGroupKey(groupKey).andCommandKey(commandKey).andThread
//        PoolKey(threadPoolKey).andThreadPoolPropertiesDefaults(threadPoolProperties).andCommandPropertiesDefau
//        lts(commandProperties);
//    }*/
//
//    @Override
//    protected String run() throws Exception {
//        return restTemplate.getForObject("http://shop-service- product/product/" + id, String.class);
//    }
//
//    @Override
//    protected String getFallback() {
//        return "熔断降级";
//    }
//
//}
