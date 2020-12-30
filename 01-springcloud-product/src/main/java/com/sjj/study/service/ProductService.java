package com.sjj.study.service;

import com.sjj.study.entity.Product;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 10:50
 */
public interface ProductService {

    Product findById(Long id);

    void update(Product product);

    void insert(Product product);

    void delete(Long id);

}
