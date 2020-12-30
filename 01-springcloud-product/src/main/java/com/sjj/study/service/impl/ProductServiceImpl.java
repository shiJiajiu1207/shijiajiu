package com.sjj.study.service.impl;

import com.sjj.study.dao.ProductDao;
import com.sjj.study.entity.Product;
import com.sjj.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 10:52
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).get();
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }

    @Override
    public void insert(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(Long id) {
        productDao.deleteById(id);
    }
}
