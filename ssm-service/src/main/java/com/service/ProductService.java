package com.service;

import com.domain.Product;
import org.springframework.stereotype.Service;

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
}
