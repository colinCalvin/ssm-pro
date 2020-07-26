package com.dao;

import com.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: 用于登录验证的dao接口
 */
public interface UserDao {

    /**
     * @return com.domain.UserInfo
     * @Description 根据用户名查找对应的用户信息
     * 注解参数：property对应UserInfo中的成员变量，column对应UserInfo中变量对应的数据库中的变量
     * javaType表示返回值类型，many表示一对多的关联查询，主要用于返回结果多个的情况，FetchType表示师傅延迟加载
     * @Param [username]
     **/
    @Select("SELECT * FROM users WHERE username = #{username} ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class, many = @Many(select = "com.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);
}
