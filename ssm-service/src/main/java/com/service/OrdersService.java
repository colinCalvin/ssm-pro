package com.service;

import com.domain.Orders;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: Orders的service层接口
 */
public interface OrdersService {

    /**
     * @Author 长歌哲理
     * @Description 查询所有订单信息
     * @Param []
     * @return java.util.List<com.domain.Orders>
     **/
    List<Orders> findAll(int page, int size);
}
