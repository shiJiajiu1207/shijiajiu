package com.sjj.study.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Description: 商品实体类
 * @auther: shijiajiu
 * @Date: 2020/07/01 10:48
 */
@Data
@Entity
@Table(name="tb_product")
public class Product {
    @Id
    private Long id;
    private String productName;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private Integer inventory;
}
