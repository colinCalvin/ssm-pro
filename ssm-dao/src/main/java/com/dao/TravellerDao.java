package com.dao;

import com.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: Traveller的dao层接口
 */
@Repository
public interface TravellerDao {

    /**
     * @Description 涉及到夺标操作 因此需要通过中间表的orderId查询TravellerId
     * 然后查询出对应的traveller的信息
     * @Param [ordersId]
     * @return java.util.List<com.domain.Traveller>
     **/
    @Select("SELECT * FROM traveller WHERE id IN ( SELECT travellerId FROM order_traveller WHERE orderId = #{ordersId}) ")
    public List<Traveller> findByOrdersId(String ordersId);
}
