package com.dao;

import com.domain.Member;
import com.domain.Orders;
import com.domain.Product;
import org.apache.ibatis.annotations.*;
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
     * @return java.util.List<com.domain.Orders>
     * @Author 长歌哲理
     * @Description 查询所有订单信息
     * 用注解很麻烦的操作
     * @Param []
     **/
    @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", javaType = Product.class, one = @One(select = "com.dao.ProductDao.findById")),
     })
    public List<Orders> findAll();

    /**
     * @Description dao层根据订单id查询订单详细信息
     * 涉及到一对多,多对多表操纵
     * @Param [orderId]
     * @return com.domain.Orders
     **/
    @Select("SELECT * FROM orders WHERE id = #{ordersId} ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", javaType = Product.class, one = @One(select = "com.dao.ProductDao.findById")),
            @Result(column = "memberId", property = "member", javaType = Member.class, one = @One(select = "com.dao.MemberDao.findById")),
            @Result(column = "id", property = "travellers", javaType = java.util.List.class, many = @Many(select = "com.dao.TravellerDao.findByOrdersId"))
    })
            Orders findById(String ordersId);

}
