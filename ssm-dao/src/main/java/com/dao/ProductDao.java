package com.dao;

import com.domain.Product;
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
    @Select("select * from product")
    public List<Product> findAll();

}
