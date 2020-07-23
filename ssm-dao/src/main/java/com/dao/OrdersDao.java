package com.dao;

import com.domain.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: Orders的dao层接口
 */
@Repository
public interface OrdersDao {

    /**
     * @Author 长歌哲理
     * @Description 查询所有订单信息
     * 用注解很麻烦的操作
     * @Param []
     * @return java.util.List<com.domain.Orders>
     **/
    @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.dao.ProductDao.findById"))
    })
    public List<Orders> findAll();
}
