package com.dao;

import com.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: role角色的dao层接口
 */
@Repository
public interface RoleDao {

    /**
     * @Description 因为role角色和user用户之间是多对多的关系
     * 因此需要依靠中间表来查询role角色信息
     * @Param [userId]
     * @return java.util.List<com.domain.Role>
     **/
    @Select("SELECT * FROM role WHERE id IN (SELECT roleId FROM users_role WHERE userId = #{userId} ")
    public List<Role> findRoleByUserId(String userId);
}
