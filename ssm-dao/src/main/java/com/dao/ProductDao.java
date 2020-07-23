package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 长歌哲理
 * @Description: Product的dao接口
 */
@Repository
public interface ProductDao {

    /**
     * @Author 长歌哲理
     * @Description 查询所有产品信息
     * @Param []
     * @return java.util.List<com.dao.Product>
     **/
    @Select("SELECT * FROM product")
    public List<Product> findAll();

    /**
     * @Author 长歌哲理
     * @Description 添加产品
     * @Param [product]
     * @return void
     * #{productNum} mybatis表达式，一定不能忘记写#{}
     **/
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * @Description 根据id查询韩品信息
     * @Param [id]
     * @return com.domain.Product
     **/
    @Select("SELECT * FROM product WHERE id = #{id}")
    public Product findById(String id);
}
