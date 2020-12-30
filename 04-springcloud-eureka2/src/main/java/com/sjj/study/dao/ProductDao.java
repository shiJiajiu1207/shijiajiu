package com.sjj.study.dao;

import com.sjj.study.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @auther: shijiajiu
 * @Date: 2020/07/01 10:53
 */

public interface ProductDao extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {
}
