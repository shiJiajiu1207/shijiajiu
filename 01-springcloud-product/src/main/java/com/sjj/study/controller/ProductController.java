package com.sjj.study.controller;

import com.sjj.study.entity.Product;
import com.sjj.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 11:02
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/{id}")
    public Product findById(@PathVariable Long id){
        Product byId = productService.findById(id);
        byId.setProductName("11111111111");
        return byId;
    }

}
