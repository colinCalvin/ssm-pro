package com.service;

import com.domain.Product;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: Product的service层接口
 */
public interface ProductService {

    /**
     * @Author 长歌哲理
     * @Description 业务层查询苏哦有产品信息
      * @Param []
     * @return java.util.List<com.dao.Product>
     **/
    public List<Product> findAll();

    /**
     * @Author 长歌哲理
     * @Description 添加产品
     * @Param [product]
     * @return void
     **/
    void save(Product product);
}
